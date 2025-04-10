import { useState } from "react";
import "./App.css";

function App() {
  // Embed JSON data directly
  const [data] = useState({
    Python: {
      totalEmployed: 130,
      predictedSalary: 1018500.0,
      demandScore: 95,
    },
    Java: {
      totalEmployed: 95,
      predictedSalary: 1050000.0,
      demandScore: 90,
    },
    SQL: {
      totalEmployed: 75,
      predictedSalary: 945000.0,
      demandScore: 80,
    },
    PowerBI: {
      totalEmployed: 55,
      predictedSalary: 882000.0,
      demandScore: 75,
    },
    React: {
      totalEmployed: 65,
      predictedSalary: 1008000.0,
      demandScore: 85,
    },
  });

  const [searchTerm, setSearchTerm] = useState("");

  const filteredData = Object.entries(data).filter(([skill]) =>
    skill.toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div className="App">
      <h1>Job Market Insights Platform</h1>
      <div className="search-container">
        <input
          placeholder="Search skills..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
        <button onClick={() => setSearchTerm("")}>Search</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>Skill</th>
            <th>Industry</th>
            <th>Employed (2024)</th>
            <th>Predicted Salary (2025, INR)</th>
            <th>Demand Score</th>
          </tr>
        </thead>
        <tbody>
          {filteredData.map(([skill, stats]) => (
            <tr key={skill}>
              <td>{skill}</td>
              <td>Tech</td>
              <td>{stats.totalEmployed}K</td>
              <td>₹{stats.predictedSalary.toLocaleString()}</td>
              <td>{stats.demandScore}</td>
            </tr>
          ))}
        </tbody>
      </table>
      <h2>Visual Dashboard</h2>
      <div className="dashboard">
        <div className="chart">
          <h3>Top Skills 2024</h3>
          <iframe
            src="https://datawrapper.dwcdn.net/RtMkS/1/"
            width="100%"
            height="400px"
            frameBorder="0"
          ></iframe>
        </div>
        <div className="chart">
          <h3>Predicted Salaries for 2025</h3>
          <iframe
            src="https://datawrapper.dwcdn.net/11GA6/1/"
            width="100%"
            height="400px"
            frameBorder="0"
          ></iframe>
        </div>
        <div className="chart">
          <h3>Demand Score Trends (2022-2024)</h3>
          <iframe
            src="https://datawrapper.dwcdn.net/g32MQ/1/"
            width="100%"
            height="400px"
            frameBorder="0"
          ></iframe>
        </div>
      </div>
    </div>
  );
}

export default App;
