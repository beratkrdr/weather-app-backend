# 🌦️ Weather API Wrapper Service

Weather API Wrapper Service is a lightweight RESTful Spring Boot application that fetches real-time weather data from the **OpenWeatherMap API** and caches responses using **Redis** to improve performance.

## ✨ Features

- Fetch weather data by city name using OpenWeatherMap API
- Cache results in Redis
- Asynchronous and reactive HTTP calls using WebClient
- Environment variable support for API keys and config
- Domain Driven Design (DDD) architecture

## 🔧 Technologies

- Spring Boot 3.5
- Spring WebFlux (WebClient)
- Redis (Spring Data Redis)
- Java 17+
- Maven
- Lombok

## 🚀 Getting Started

> Make sure the following tools are installed on your system:

- Java 17+
- Maven 3+
- Redis (localhost:6379 or your custom config)

### 1. Clone the repository

```bash
git clone https://github.com/beratkrdr/weather-app.git
cd weather-app
```

### 2. Add your configuration

Update `application.properties` file in `src/main/resources`:

```properties
weather.api.key=YOUR_OPENWEATHERMAP_API_KEY
weather.api.url=https://api.openweathermap.org/data/2.5/weather
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

### 3. Build the project

```bash
mvn clean install
```

### 4. Run the application

```bash
mvn spring-boot:run
```

App will start at:  
📌 `http://localhost:8080`

---

## 📡 API Usage

### `GET /api/weather?city=London`

Fetches current weather data for a given city. If the data has been requested within the last 12 hours, it is served from Redis cache.

#### ✅ Sample Response

```json
{
  "city": "London",
  "temperature": 21.7,
  "description": "few clouds",
  "humidity": 65,
  "windSpeed": 3.6
}
```

---

## 🧠 Caching Strategy

- Redis is used to store API responses with the city name as the key
- Data is automatically removed after 12 hours
- If Redis is unavailable, fallback to fresh API call (no crash)
