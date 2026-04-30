const API_KEY = "4ec1fe7a7d7b620c908b98d212e774da";

export const fetchWeather = async (city) => {
  try {
    const res = await fetch(
      `https://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${API_KEY}&units=metric`
    );

    const data = await res.json();

    // safety check
    if (!data.list) {
      alert("Invalid city or API issue");
      return [];
    }

    return data.list.slice(0, 5).map(item => item.main.temp);

  } catch (error) {
    alert("Error fetching data");
    return [];
  }
};