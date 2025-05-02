import { useState } from 'react';
import {auth,db} from "../firebase.js"

import { useDrag, useDrop } from 'react-dnd';
import { collection, addDoc, query, getDocs, updateDoc, doc } from 'firebase/firestore';

import { SendHorizontal } from 'lucide-react';

import './dashboard.css'
import Sidebar from '../components/sidebar'


import { DragDropContext, Droppable, Draggable } from '@hello-pangea/dnd';


function Dashboard(){

    const [projectName, setProjectName] = useState("");
    const [projectCreated, setProjectCreated] = useState(false);
    const [projectId, setProjectId] = useState(null);

    const [taskName, setTaskName] = useState(""); // State for new task name
    const [tasks, setTasks] = useState([]); // State to hold tasks in "To Do" column

    const handleCreateProject = async () => {
        const userId = auth.currentUser?.uid;

        if (!userId) {
            alert("User not logged in!");
            return;
        }
        
        if (!projectName.trim()) {
            alert("Please enter a project name!");
            return;
        }

        try {
        const docRef = await addDoc(collection(db, "users", userId, "projects"), {
            name: projectName,
            createdAt: new Date(),
            tasks:[],
        });
        setProjectId(docRef.id);
        setProjectCreated(true);
        } catch (error) {
        console.error("Error adding project:", error);
        }
    };

    const handleAddTask = async() => {
        if (!taskName.trim()) {
            alert("Please enter a task name!");
            return;
        }

        const newTask = {
            name: taskName,
            status: "To Do",
            createdAt: new Date(),
        };

        try {
            // Add task to Firestore under the selected project
            const taskRef = doc(db, "users", auth.currentUser.uid, "projects", projectId);
            await updateDoc(taskRef, {
                tasks: [...tasks, newTask], // Append the new task to the existing tasks array
            });

            setTaskName(""); // Clear input
            setTasks(prevTasks => [...prevTasks, newTask]); // Update local state to display tasks
        } catch (error) {
            console.error("Error adding task:", error);
        }
    };

    // Handle task status change (when dragging)
    const handleDragEnd = async (result) => {
        const { destination, source } = result;

        // If dropped outside of a droppable area (cancel the operation)
        if (!destination) return;

        // If dropped in the same place (no change needed)
        if (destination.droppableId === source.droppableId && destination.index === source.index) {
            return;
        }

        const updatedTasks = Array.from(tasks);
        const [movedTask] = updatedTasks.splice(source.index, 1);
        movedTask.status = destination.droppableId; // Update task status based on column

        // Reorder the tasks list
        updatedTasks.splice(destination.index, 0, movedTask);

        // Update Firestore with new task list
        const taskRef = doc(db, "users", auth.currentUser.uid, "projects", projectId);
        await updateDoc(taskRef, {
            tasks: updatedTasks
        });

        // Update local state
        setTasks(updatedTasks);
    };


    return(

        <>

            <Sidebar/>
            <div className="dashboard">
                {!projectCreated ? (
                    <div className="project-input">
                        <input
                            type="text"
                            placeholder="Enter Project Name"
                            value={projectName}
                            onChange={(e) => setProjectName(e.target.value)}
                        />
                        <button className="projectCreate" onClick={handleCreateProject}>
                            <SendHorizontal />
                        </button>
                    </div>
                ) : (
                    <div className="project-board">
                        <h2>{projectName}</h2>

                        {/* Drag and Drop Context */}
                        <DragDropContext onDragEnd={handleDragEnd}>
                            <div className="columns">
                                {/* To Do Column */}
                                <Droppable droppableId="To Do">
                                    {(provided) => (
                                        <div
                                            className="column"
                                            ref={provided.innerRef}
                                            {...provided.droppableProps}
                                        >
                                            <h3>To Do</h3>
                                            <div className="add-task">
                                                <input
                                                    type="text"
                                                    placeholder="Add a task"
                                                    value={taskName}
                                                    onChange={(e) => setTaskName(e.target.value)}
                                                />
                                                <button onClick={handleAddTask}>Add Task</button>
                                            </div>

                                            {/* Render tasks in To Do */}
                                            {tasks.filter(task => task.status === "To Do").map((task, index) => (
                                                <Draggable key={task.name} draggableId={task.name} index={index}>
                                                    {(provided) => (
                                                        <div
                                                            className="task"
                                                            ref={provided.innerRef}
                                                            {...provided.draggableProps}
                                                            {...provided.dragHandleProps}
                                                        >
                                                            {task.name}
                                                        </div>
                                                    )}
                                                </Draggable>
                                            ))}

                                            {provided.placeholder}
                                        </div>
                                    )}
                                </Droppable>

                                {/* In Progress Column */}
                                <Droppable droppableId="In Progress">
                                    {(provided) => (
                                        <div
                                            className="column"
                                            ref={provided.innerRef}
                                            {...provided.droppableProps}
                                        >
                                            <h3>In Progress</h3>
                                            {tasks.filter(task => task.status === "In Progress").map((task, index) => (
                                                <Draggable key={task.name} draggableId={task.name} index={index}>
                                                    {(provided) => (
                                                        <div
                                                            className="task"
                                                            ref={provided.innerRef}
                                                            {...provided.draggableProps}
                                                            {...provided.dragHandleProps}
                                                        >
                                                            {task.name}
                                                        </div>
                                                    )}
                                                </Draggable>
                                            ))}
                                            {provided.placeholder}
                                        </div>
                                    )}
                                </Droppable>

                                {/* Completed Column */}
                                <Droppable droppableId="Completed">
                                    {(provided) => (
                                        <div
                                            className="column"
                                            ref={provided.innerRef}
                                            {...provided.droppableProps}
                                        >
                                            <h3>Completed</h3>
                                            {tasks.filter(task => task.status === "Completed").map((task, index) => (
                                                <Draggable key={task.name} draggableId={task.name} index={index}>
                                                    {(provided) => (
                                                        <div
                                                            className="task"
                                                            ref={provided.innerRef}
                                                            {...provided.draggableProps}
                                                            {...provided.dragHandleProps}
                                                        >
                                                            {task.name}
                                                        </div>
                                                    )}
                                                </Draggable>
                                            ))}
                                            {provided.placeholder}
                                        </div>
                                    )}
                                </Droppable>
                            </div>
                        </DragDropContext>
                    </div>
                )}
            </div>
        </>
    )

}

export default Dashboard