import { useState } from 'react';
import {auth,db} from "../firebase.js"
import { collection, addDoc } from 'firebase/firestore';

import './dashboard.css'
import Sidebar from '../components/sidebar'

function Dashboard(){

    const [projectName, setProjectName] = useState("");
    const [projectCreated, setProjectCreated] = useState(false);
    const [projectId, setProjectId] = useState(null);

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
        } catch (error) {
        console.error("Error adding project:", error);
        }
    };


    return(

        <>

            <Sidebar/>
            {/* <div className="dashboard"> 
                {!projectCreated ? (
                    <div className="project-input">
                        <input type="text" placeholder="Enter Project Name" value={projectName}
                        onChange={(e) => setProjectName(e.target.value)}></input>
                        <button onClick={handleCreateProject}>Create Project</button>
                    </div>
                ) : (
                    <div className="project-board">
                        <h2>{projectName}</h2>
                        <div className="columns">
                            <div className="column">To Do</div>
                            <div className="column">In Progress</div>
                            <div className="column">Completed</div>
                        </div>
                    </div>
                )}
            </div> */}

        </>
    )

}

export default Dashboard