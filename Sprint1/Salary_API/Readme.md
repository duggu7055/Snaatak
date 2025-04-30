
# POC Of Salary API

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|   26-04-2025       |  V1         |   28-04-2025      |  Durgesh Sharma   | Internal review      | Pritam        |
|   26-04-2025       |             |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|   26-04-2025       |             |         | Durgesh Sharma   | L1 Review            | Abhishek V    |
|   26-04-2025       |             |         |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |

# Table of Contents

1. [Pre-Requisites](#pre-requisites)
2. [System Requirements](#system-requirements)
3. [Architecture](#architecture)
4. [Ports](#ports)
5. [API Setup and Execution](#api-setup-and-execution)
   - [Update System Packages](#update-system-packages)
   - [Installing Dependencies for Salary API](#installing-dependencies-for-salary-api)
   - [Working with the Salary API Git Repository](#working-with-the-salary-api-git-repository)
   - [Starting the Application](#starting-the-application)
   - [Access the API](#access-the-api)
6. [Conclusion](#conclusion)
7. [Contact Information](#contact-information)
8. [References](#references)


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

![logo](https://github.com/duggu7055/Snaatak/blob/main/salari-api/daigram.drawio%20(2).png
)



---

# Ports

| **Port** | **Protocol/Service**       | **Description**                                                                 |
|----------|----------------------------|---------------------------------------------------------------------------------|
| 22       | SSH                        | Used for secure shell access to the server.                                    |
| 8080     | HTTP (Swagger UI)          | Used for accessing Swagger UI for API documentation.                          |
| 9042     | ScyllaDB                   | The default port for connecting to ScyllaDB (Cassandra-compatible database).   |
| 6379     | Redis                      | The default port for connecting to the Redis in-memory data store.            |
| 80       | HTTP                       | Used for standard web traffic and serving HTTP requests.                      |

---

# API Setup and Execution

## Update System Packages

> **Follow STEP 3**: [Update System Packages](https://github.com/snaatak-Downtime-Crew/Documentation/tree/main/common_stack/operating_system/ubuntu/sop/commoncommands).

![image](https://github.com/user-attachments/assets/b2e6de56-bfa2-467e-8f01-752e28c670ba)



## Installing Dependencies for Salary API
| **Tool**      | **Installation Steps**                                                                                              |
|---------------|--------------------------------------------------------------------------------------------------------------------|
| **ScyllaDB**  | Follow this [link](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-88-Adil/ot-ms-understanding/scylladb/poc/README.md) to install and configure ScyllaDB |
| **Redis**     | Follow this [link](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-84-PRINCE/ot-ms-understanding/redis/poc/README.md) to install and configure Redis     |
| **Java 17**   | `sudo apt install openjdk-17-jre-headless -y`                                                                      |
| **Maven**     | `sudo apt install maven -y`                                                                                        |
| **jq**        | `sudo apt install jq -y`                                                                                           |
| **make**      | `sudo apt install make -y`                                                                                         |

### golang-migrate
**1. Download and extract:**
   ```bash
   curl -L https://github.com/golang-migrate/migrate/releases/download/v4.15.2/migrate.linux-amd64.tar.gz | tar xvz
   ```
![image](https://github.com/user-attachments/assets/db964fba-0101-4ffe-9272-7333791c8c21)


**2. Move the binary:**
   ```bash
   sudo mv migrate /usr/local/bin/migrate
   ```
![image](https://github.com/user-attachments/assets/7365d422-ae73-4b5a-8fa9-9ed7d0299984)


## Working with the Salary API Git Repository
**1. Clone the repository:**
   ```bash
   git clone https://github.com/OT-MICROSERVICES/salary-api.git
   cd salary-api
   ```
![image](https://github.com/user-attachments/assets/8e564cf2-ed91-4817-988b-ee2f2614f6ce)

---
**2. Create a service file:**

A service file manages the salary API with systemd, enabling automatic startup, easy control via systemctl, and recovery from failures, ensuring reliable and seamless operation.

```bash
sudo nano /etc/systemd/system/salary-api.service
   ```


   ```bash
   [Unit]
Description=Salary API Service
After=network.target

[Service]
User=ubuntu
WorkingDirectory=/home/ubuntu/salary-api
ExecStart=/usr/bin/java -jar /home/ubuntu/salary-api/target/salary-0.1.0-RELEASE.jar
SuccessExitStatus=143
Restart=on-failure
Environment=JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
Environment=SCYLLA_HOST=private-ip
Environment=REDIS_HOST=private-ip

[Install]
WantedBy=multi-user.target

   ```
**3. Service File Commands**

Below are the commands to manage the `salary-api` service using `systemd`. These commands help reload systemd configuration, enable the service to start on boot, start the service manually, and check its current status.

| Command                                  | Description                                                              |
|------------------------------------------|--------------------------------------------------------------------------|
| `sudo systemctl daemon-reload`           | Reloads systemd manager configuration to recognize changes in service files. |
| `sudo systemctl enable salary-api.service` | Enables the service to start automatically on system boot.              |
| `sudo systemctl start salary-api.service` | Starts the `salary-api` service immediately.                            |
| `sudo systemctl status salary-api.service` | Displays the current status of the service, including logs and errors.  |

---


**4. Configure migration:**
   ```bash
   vi migration.json
   ```
   - Replace the IP address with your instance  private IP.

![image](https://github.com/user-attachments/assets/c4356793-6da1-49ad-9719-b43b41c0c935)


**5. Update application configuration:**
   ```bash
   vi src/main/resources/application.yml
   ```
   - Replace the IP address with your instance private IP.

![image](https://github.com/user-attachments/assets/de99c150-6601-4997-8478-d5cee451b77f)

**6. Update test configuration:**
   ```bash
   vi src/test/resources/application.yml
   ```
   - Replace the IP address with your instance private IP.

![image](https://github.com/user-attachments/assets/de99c150-6601-4997-8478-d5cee451b77f)


**7. Update Java API configuration:**
   ```bash
   vi src/main/java/com/opstree/microservice/salary/config/OpenAPIConfig.java
   ```
   - Replace the IP address with your **public** IP (in devserver.seturl).
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
![image](https://github.com/user-attachments/assets/9dfa0015-42e2-4f51-95ee-f15c7a6ad00f)

**8. Update test configurations:**
   ```bash
   sudo vi src/test/java/com/opstree/microservice/salary/config/OpenAPIConfigTests.java
   ```
   - Replace the IP address with your **public** IP (n assertEquals).

![image](https://github.com/user-attachments/assets/f1726629-4723-4a3c-9ef6-eac2d53922aa)


## Starting the Application

**1. Run migrations:**
   ```bash
   make run-migrations
   ```

**2. Build the application:**
   ```bash
   make build
   ```
![image](https://github.com/user-attachments/assets/72ad6be4-8492-49f4-919d-a3c35e44b5eb)
![image](https://github.com/user-attachments/assets/6e40042a-b47b-4a95-a9e4-23770f56a195)



**3. Start the application:**
   ```bash
   java -jar target/salary-0.1.0-RELEASE.jar
   ```

## Access the API
Visit the following URL in your browser:
```
http://<public-ip>:8080/salary-documentation
```
![image](https://github.com/user-attachments/assets/b662af12-0b41-4743-a28d-c70135533421)
![image](https://github.com/user-attachments/assets/aa56cc22-0b3e-416f-8a08-36c6655e8106)
![image](https://github.com/user-attachments/assets/033b28d8-0463-433e-a054-d319aa1976eb)




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



