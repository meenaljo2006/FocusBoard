import { BrowserRouter as Router } from "react-router-dom";
import AppRoutes from "./appRoutes";
import { SpeedInsights } from "@vercel/speed-insights/react"
import { Analytics } from "@vercel/analytics/react"

function App() {
  return (
    <Router>
      <AppRoutes />
      <SpeedInsights />
      <Analytics />
    </Router>
  );
}

export default App;

