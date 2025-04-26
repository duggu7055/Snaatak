
# Salary API

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|          |           |         |  Durgesh Sharma   | Internal review      | Pritam        |
|          |           |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|          |             |                   | Durgesh Sharma   | L1 Review            | Abhishek V    |
|          |             |                   |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |

# Table of Contents

1. [Pre-Requisites](#pre-requisites)
2. [System Requirements](#system-requirements)
3. [Architecture](#architecture)
4. [Installation](#installation)
   - [Update System Packages](#update-system-packages)
   - [Installing Dependencies for Salary API](#installing-dependencies-for-salary-api)
   - [Working with the Salary API Git Repository](#working-with-the-salary-api-git-repository)
   - [Starting the Application](#starting-the-application)
   - [Access the API](#access-the-api)
5. [Conclusion](#conclusion)
6. [Contact Information](#contact-information)
7. [References](#references)


---

# Pre-Requisites
The Salary API application have some database, cache manager and package dependencies. Some of the dependencies are optional and some are mandatory. To compile the application, we only need maven as build tool, but for running the application following things are required:-



| Tool/Resource                          | Description                                                                                              |
|----------------------------------------|----------------------------------------------------------------------------------------------------------|
| [ScyllaDB](https://www.scylladb.com/)  | A high-performance NoSQL database designed for low-latency and high throughput, ideal for big data applications. |
| [Redis](https://redis.io/)             | An in-memory data structure store used as a database, cache, and message broker, known for its speed and flexibility. |
| [Migrate](https://github.com/golang-migrate/migrate) | A database migration tool for managing schema changes, supporting many different databases.            |
| [Maven](https://maven.apache.org/)     | A build automation tool primarily used for Java projects to manage dependencies and build lifecycle.     |

---

# System Requirements

| Requirement   | Details                      |
|---------------|------------------------------|
| OS            | Ubuntu or other Linux-based OS |
| RAM           | 4 GB minimum                |
| Disk Space    | 20 GB                       |
| Processor     | Dual-core recommended       |
| Instance Type | t2.medium                   |

---

# Architecture

![logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiuRhRs1-8S8j6QR7e6XYG2y-4hVo8bOz656bCQ1_pTv6R9ty6W6XC5r0oQ_C-58hFb__dtbHCpgP9VVhlgXtA2MUbAhdlQVtEiX-rG00TZKmEE-VXnA0069mT-LKO0z1FPkhmz4xICp0LnHNu-k2eRjxXyDLf9rRtB4kljiUWPC09WSd2xpyrybH8EEaU/s16000/archi.png)

---

# Installation

## Update System Packages
```bash
sudo apt update
```
## Installing Dependencies for Salary API
| **Tool**      | **Installation Steps**                                                                                 |
|-----------|---------------------------------------------------------------------------------------------------|
| **ScyllaDB**  | Follow this [link]() to install and Configure ScyllaDB                                                          |
| **Redis**      | Follow this [link](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-84-PRINCE/ot-ms-understanding/redis/poc/README.md) to install and Configure Redis                                                             |
| **Java 17**   | `sudo apt install openjdk-17-jre-headless -y`                                                     |
| **Maven**     | `sudo apt install maven -y`                                                                       |
| **jq**        | `sudo apt install jq -y`                                                                          |
| **make**      | `sudo apt install make -y`                                                                        |

### golang-migrate
**1. Download and extract:**
   ```bash
   curl -L https://github.com/golang-migrate/migrate/releases/download/v4.15.2/migrate.linux-amd64.tar.gz | tar xvz
   ```

**2. Move the binary:**
   ```bash
   sudo mv migrate /usr/local/bin/migrate
   ```

## Working with the Salary API Git Repository
**1. Clone the repository:**
   ```bash
   git clone https://github.com/OT-MICROSERVICES/salary-api.git
   cd salary-api
   ```

**2. Configure migration:**
   ```bash
   vi migration.json
   ```
   - Replace the IP address with your instance  private IP.

**3. Update application configuration:**
   ```bash
   vi src/main/resources/application.yml
   ```
   - Replace the IP address with your instance private IP.

**4. Update test configuration:**
   ```bash
   vi src/test/resources/application.yml
   ```
   - Replace the IP address with your instance private IP.

**5. Update Java API configuration:**
   ```bash
   vi src/main/java/com/opstree/microservice/salary/config/OpenAPIConfig.java
   ```
   - Replace the IP address with your **public** IP.
   - Add the following for CORS support:
     ```java
     @Bean
     public CorsFilter corsFilter() {
       CorsConfiguration config = new CorsConfiguration();
       config.addAllowedOrigin("*");
       config.addAllowedMethod("*");
       config.addAllowedHeader("*");
       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**", config);
       return new CorsFilter(source);
     }
     ```

**6. Update test configurations:**
   ```bash
   sudo vi src/test/java/com/opstree/microservice/salary/config/OpenAPIConfigTests.java
   ```
   - Replace the IP address with your **public** IP.

## Starting the Application

**1. Run migrations:**
   ```bash
   make run-migrations
   ```

**2. Build the application:**
   ```bash
   make build
   ```

**3. Start the application:**
   ```bash
   java -jar target/salary-0.1.0-RELEASE.jar
   ```

## Access the API
Visit the following URL in your browser:
```
http://<public-ip>:8080/salary-documentation
```

---

# Conclusion
The Salary API, a key component of the OT-Microservices system, manages salary transactions efficiently. It leverages ScyllaDB for scalable storage, Redis for caching, Migrate for database versioning, Swagger for documentation, and Maven for builds. Designed for high performance and seamless integration, it ensures fast data access, scalability, and enterprise-grade reliability.


## Contact Information
| **Name**           | **Email Address**                                 |
|----------------|-----------------------------------------------|
| Durgesh Sharma | durgesh.sharma.snaatak@mygurukulam.co         |


---

## References
| Reference               | Link                                                                           |
|-------------------------|--------------------------------------------------------------------------------|
| ScyllaDB Introduction documentation    | [Click here](https://github.com/duggu7055/Snaatak/blob/main/Sprint1/Scylla%20documentation/Readme.md)                             |
| ScyllaDB Installation documentation    | [Click here](https://docs.github.com)                             |
| Redis Installation Guide              | [Click here](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-84-PRINCE/ot-ms-understanding/redis/poc/README.md)                               |
| Maven                   | [Click here](https://maven.apache.org/what-is-maven.html)                                           |



