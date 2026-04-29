# 🌤️ WeatherWise Explorer — Smart Outing Planner

<div align="center">

**Plan smarter outings with real-time weather + curated location recommendations**

*Weather Forecasts • Location Intelligence • Outing Suggestions • Full-Stack Java*

[![GitHub stars](https://img.shields.io/github/stars/mayankOli-09/WeatherWise_Explorer?style=social)](https://github.com/mayankOli-09/WeatherWise_Explorer)
[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Build-Maven-red?logo=apachemaven)](https://maven.apache.org/)
[![Weather API](https://img.shields.io/badge/Powered%20by-OpenWeatherMap-blue?logo=cloudflare)](https://openweathermap.org/api)

</div>

---

## 🎯 What is WeatherWise Explorer?

WeatherWise Explorer is a **full-stack Java Spring Boot application** that takes the guesswork out of planning your day out. It combines **live weather data** with **curated location insights** to recommend the best places to visit — right now or in the forecast window.

No more checking weather apps and Google Maps separately. WeatherWise brings it all together.

---

## ✨ Key Features

| Feature | Description |
|--------|-------------|
| 🌦️ **Real-Time Weather** | Fetches live conditions using the OpenWeatherMap API |
| 📍 **Smart Location Picks** | Recommends places based on current or forecasted weather |
| 🗓️ **Forecast-Aware Planning** | Suggests outings for upcoming days, not just today |
| 🖥️ **Full-Stack Java** | Spring Boot backend with a clean, responsive frontend |
| ⚡ **Fast & Lightweight** | Built with Maven for quick builds and easy dependency management |

---

## 🚀 Quick Start

### Prerequisites

Make sure you have the following installed:

- **Java 17+**
- **Maven 3.6+**
- An **OpenWeatherMap API key** → [Get one free here](https://openweathermap.org/api)

### Setup & Run

```bash
# 1. Clone the repository
git clone https://github.com/mayankOli-09/WeatherWise_Explorer.git
cd WeatherWise_Explorer

# 2. Add your API key
# Open src/main/resources/application.properties and set:
# weather.api.key=take from openmeteo

# 3. Build the project
mvn clean install

# 4. Run the application
mvn spring-boot:run
```

Then open your browser at **`http://localhost:8080`** and start exploring! 🗺️

---

## 🔑 API Key Configuration

In `src/main/resources/application.properties`:

```properties
weather.api.key=your_openweathermap_api_key
server.port=8080
```

> **Get your free API key** at [openweathermap.org](https://openweathermap.org/api) — the free tier is more than enough to run this project.

---

## 🏗️ Project Structure

```
WeatherWise_Explorer/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/weatherwise/
│   │   │       ├── controller/       # REST & MVC controllers
│   │   │       ├── service/          # Weather + location business logic
│   │   │       └── model/            # Data models & DTOs
│   │   └── resources/
│   │       ├── templates/            # Frontend (HTML/Thymeleaf)
│   │       ├── static/               # CSS, JS, assets
│   │       └── application.properties
├── pom.xml
└── README.md
```

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| **Backend** | Java 17, Spring Boot 3.x |
| **Build Tool** | Apache Maven |
| **Weather Data** | OpenWeatherMap REST API |
| **Frontend** | HTML, CSS, JavaScript (Spring MVC / Thymeleaf) |
| **HTTP Client** | RestTemplate / WebClient |

---

## 📸 How It Works

```
User enters location
        ↓
WeatherWise fetches real-time weather via OpenWeatherMap API
        ↓
App analyzes conditions (sunny, rainy, windy, etc.)
        ↓
Smart engine recommends best-fit locations to visit
        ↓
User gets a curated outing plan — instantly!
```

---

## 🤝 Contributing

Contributions are welcome! Here's how:

```bash
# Fork the repo, then:
git checkout -b feature/your-feature-name
git commit -m "Add: your feature description"
git push origin feature/your-feature-name
# Open a Pull Request 🎉
```


<div align="center">

Built with ❤️ by <a href="https://github.com/mayankOli-09">Mayank Oli</a> &nbsp;|&nbsp; ⭐ Star this repo if it helped you!

</div>
