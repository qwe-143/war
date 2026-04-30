import { useState } from "react";
import { Line } from "react-chartjs-2";
import "chart.js/auto";
import { fetchWeather } from "../services/weatherService";

function Weather() {
  const [temps, setTemps] = useState([]);
  const [city, setCity] = useState("Hyderabad");

  const handleClick = async () => {
    if (city === "") {
      alert("Enter city");
      return;
    }

    const data = await fetchWeather(city);
    setTemps(data);
  };

  const chartData = {
    labels: ["1", "2", "3", "4", "5"],
    datasets: [
      {
        label: "Temperature (°C)",
        data: temps,
        borderColor: "blue",
      },
    ],
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h2>Weather Graph</h2>

      <input
        placeholder="Enter city"
        value={city}
        onChange={(e) => setCity(e.target.value)}
      />

      <br /><br />

      <button onClick={handleClick}>Get Weather</button>

      <br /><br />

      <Line data={chartData} />
    </div>
  );
}

export default Weather;