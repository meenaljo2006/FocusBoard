import { useEffect, useState } from "react";
import { auth, db } from "../firebase";
import { collection, getDocs,deleteDoc, doc,addDoc,updateDoc } from "firebase/firestore";

import Sidebar from "../components/sidebar";
import Footer from "../components/footer";
import { onAuthStateChanged } from "firebase/auth";

import { SendHorizontal ,CopyMinus,Trash2 } from 'lucide-react';
import Modal from "react-modal";
Modal.setAppElement('#root');

import { DragDropContext, Droppable, Draggable } from '@hello-pangea/dnd';

import "./dashboard.css"

function ProjectsPage() {

  const [projectName, setProjectName] = useState("");

  const [projects, setProjects] = useState([]);
  const [showModal, setShowModal] = useState(false);

  const [projectCreated, setProjectCreated] = useState(false);
  const [projectId, setProjectId] = useState(null);

  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState("");
  const [selectedProject, setSelectedProject] = useState(null);


  useEffect(() => {
    const unsubscribe = onAuthStateChanged(auth, async (user) => {
      if (user) {
        const userId = user.uid;
        const projectsRef = collection(db, "users", userId, "projects");
        const querySnapshot = await getDocs(projectsRef);
        const projectList = querySnapshot.docs.map(doc => ({
          id: doc.id,
          ...doc.data(),
        }));
        setProjects(projectList);
      } else {
        console.log("User not logged in");
      }
    });

    return () => unsubscribe(); // clean up listener
  }, []);

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
  
    });
    
    setProjectId(docRef.id);
    setProjectCreated(true);
    setProjectName(""); // Clear input field after successful project creation

    window.location.reload();

    } catch (error) {
    console.error("Error adding project:", error);
    }
  };

  const handleDelete = async (projectId) => {
    try {
      const user = auth.currentUser;
  
      if (!user) {
        alert("User not logged in!");
        return;
      }
  
      // Step 1: Get all tasks under the project
      const tasksRef = collection(db, "users", user.uid, "projects", projectId, "tasks");
      const taskSnapshot = await getDocs(tasksRef);
  
      // Step 2: Delete all tasks
      const deleteTasksPromises = taskSnapshot.docs.map(doc => deleteDoc(doc.ref));
      await Promise.all(deleteTasksPromises);
  
      // Step 3: Delete the project itself
      const projectDocRef = doc(db, "users", user.uid, "projects", projectId);
      await deleteDoc(projectDocRef);
  
      // Step 4: Update frontend state to reflect the deletion of the project
      setProjects(prevProjects => prevProjects.filter(p => p.id !== projectId));
  
      console.log("Project and all tasks deleted successfully.");
    } catch (error) {
      console.error("Error deleting project and tasks:", error.message || error);
    }
  };
  

  const handleView = async (projectId) => {
    const user = auth.currentUser;
    if (!user) return;
  
    const selected = projects.find(p => p.id === projectId);
    setSelectedProject(selected);
    console.log("Selected Project:", selected); // Log to check if selectedProject is correct 
  
    const tasksRef = collection(db, "users", user.uid, "projects", projectId, "tasks");
    const snapshot = await getDocs(tasksRef);
    const taskList = snapshot.docs.map(doc => ({
      id: doc.id,
      ...doc.data(),
    }));
    setTasks(taskList);
    setShowModal(true);
  };

  const handleAddTask = async () => {
    const user = auth.currentUser;
    if (!user || !selectedProject || newTask.trim() === "") return;
  
    const taskRef = collection(db, "users", user.uid, "projects", selectedProject.id, "tasks");
    const newTaskData = {
      name: newTask,
      status: "todo",
      createdAt: new Date()
    };
    const docRef = await addDoc(taskRef, newTaskData);
  
    setTasks([...tasks, { id: docRef.id, ...newTaskData }]);
    setNewTask("");
  };

  // Handle Drag and Drop
  const handleOnDragEnd = async (result) => {
    const { destination, source } = result;
    if (!destination) return;

    // If task is dropped into the same column, no changes needed
    if (destination.index === source.index && destination.droppableId === source.droppableId) return;

    const user = auth.currentUser;
    const taskId = result.draggableId;
    const newTasks = [...tasks];
    const taskIndex = newTasks.findIndex((task) => task.id === taskId);
    const task = newTasks[taskIndex];

    // Update task status based on column drop
    const newStatus = destination.droppableId;
    task.status = newStatus;
    newTasks[taskIndex] = task;

    // Update Firestore
    const taskRef = doc(db, "users", user.uid, "projects", selectedProject.id, "tasks", taskId);
    await updateDoc(taskRef, { status: newStatus });

    setTasks(newTasks);
  };

  const statusLabels = {
    todo: "To-Do 📝",
    inprogress: "In-Progress 🔄",
    complete: "Completed ✅"
  };
  
  return (
    <>

    <Sidebar/>
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

    <div className="project-list">
        <h2>Your Projects</h2>
        {projects.length === 0 ? (
            <p>No projects found !</p>
            
        ) : (
            <ul>
                {projects.map((project) => (
                    <li key={project.id}>
                      <div className="project-details">
                          <strong>{project.name}</strong>
                          <small>{project.createdAt?.toDate().toLocaleString()}</small>
                      </div>
                      <div className="project-buttons">
                          <button className="view-btn" onClick={() => handleView(project.id)}>View</button>
                          <button className="delete-btn" onClick={() => handleDelete(project.id)}><Trash2/></button>
                      </div>
                    </li>
                ))}
            </ul>
        )}



    {/* Modal for Task Management */}
    <Modal className="Modal" isOpen={showModal} onRequestClose={() => setShowModal(false)}>
      <div className="taskModal">
        <div className="taskHeader">
          <h2>{selectedProject?.name}</h2>
          <button onClick={() => setShowModal(false)} className="closeModalBtn"><CopyMinus size={16}/></button>
        </div>
        
        <div className="addTask">
          <input
            type="text"
            placeholder="Add a new task"
            value={newTask}
            onChange={(e) => setNewTask(e.target.value)}
          />
          <button onClick={handleAddTask}>Add Task</button>
        </div>

        <DragDropContext onDragEnd={handleOnDragEnd}>
          <div className="task-columns">
            {["todo", "inprogress", "complete"].map((status) => (
              <Droppable droppableId={status} key={status}>
                {(provided) => (
                  <div
                    className="task-column"
                    ref={provided.innerRef}
                    {...provided.droppableProps}
                  >
                    <h3>{statusLabels[status]}</h3>
                    {tasks.filter(task => task.status === status).map((task, index) => (
                      <Draggable key={task.id} draggableId={task.id} index={index}>
                        {(provided) => (
                          <div
                            className="task"
                            ref={provided.innerRef}
                            {...provided.draggableProps}
                            {...provided.dragHandleProps}
                          >
                            ⁍ {task.name}
                          </div>
                        )}
                      </Draggable>
                    ))}
                    {provided.placeholder}
                  </div>
                )}
              </Droppable>
            ))}
          </div>
        </DragDropContext>
        </div>
      </Modal>

    </div>
    
    </>
    
  );
}

export default ProjectsPage;
