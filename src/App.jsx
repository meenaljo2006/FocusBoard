import { BrowserRouter as Router } from "react-router-dom";
import AppRoutes from "./appRoutes";
import { SpeedInsights } from "@vercel/speed-insights/react"

function App() {
  return (
    <Router>
      <AppRoutes />
      <SpeedInsights />
    </Router>
  );
}

export default App;

