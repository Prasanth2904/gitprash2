<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Webpage with Widgets</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 40px;
      background-color: #a12424;
      color: #333;
      text-align: center;
    }
    header, footer {
      background-color: #fff;
      padding: 20px;git 
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    .widget {
      margin: 20px auto;
      padding: 20px;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      max-width: 300px;
    }
    .widget h2 { margin-bottom: 10px; }
    .weather-icon { width: 80px; height: 80px; }
  </style>
</head>
<body>
  <header>
    <h1>My Enhanced Webpage</h1>
    <p>Time, Date & Weather Widgets</p>
  </header>

  <div class="widget" id="time-widget">
    <h2>Local Time & Date</h2>
    <div id="time"></div>
    <div id="date"></div>
  </div>

  <div class="widget" id="weather-widget">
    <h2>Weather in Chennai</h2>
    <div id="weather">
      <img id="weather-icon" src="" alt="">
      <div id="weather-desc"></div>
      <div id="temperature"></div>
    </div>
  </div>

  <footer>
    &copy; 2025 My Website
  </footer>

  <script>
    // Time & Date update
    function updateTimeDate() {
      const now = new Date();
      document.getElementById('time').textContent =
        now.toLocaleTimeString();
      document.getElementById('date').textContent =
        now.toLocaleDateString(undefined, { weekday:'long', year:'numeric', month:'long', day:'numeric' });
    }
    setInterval(updateTimeDate, 1000);
    updateTimeDate();

    // Weather fetch using OpenWeatherMap
    async function fetchWeather() {
      const apiKey = 'YOUR_API_KEY';
      const city = 'Chennai';
      const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}`;

      try {
        const res = await fetch(url);
        const data = await res.json();
        if (res.ok) {
          document.getElementById('weather-icon').src =
            `https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;
          document.getElementById('weather-desc').textContent =
            data.weather[0].description;
          document.getElementById('temperature').textContent =
            Math.round(data.main.temp) + '°C';
        } else {
          document.getElementById('weather').textContent =
            'Error: ' + data.message;
        }
      } catch (err) {
        document.getElementById('weather').textContent =
          'Error fetching weather';
        console.error(err);
      }
    }

    fetchWeather();
  </script>
</body>
</html>

