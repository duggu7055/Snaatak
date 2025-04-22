# ScyllaDB Documentation

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|          |           |         |  Durgesh Sharma   | Internal review      | Pritam        |
|          |           |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|          |             |                   | Durgesh Sharma   | L1 Review            | Abhishek V    |
|          |             |                   |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |


## Table of Contents

1. [Introduction](#introduction)
2. [Purpose](#purpose)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Important Ports](#important-ports)
6. [Conclusion](#conclusion)
7. [Contact](#contact)
8. [References](#references)

---

## Introduction

ScyllaDB is a high-performance, distributed NoSQL database designed for low-latency data access and high throughput. It is fully compatible with Apache Cassandra and Amazon DynamoDB, offering enhanced scalability and performance.

---
## Purpose

This document provides concise instructions for installing, configuring, and using ScyllaDB, helping developers and administrators quickly set it up and optimize performance.


---

## Key Features

| **Feature**                                          | **Description**                                                    |
|------------------------------------------------------|--------------------------------------------------------------------|
| Cassandra Compatibility                              | Fully compatible with Cassandra Query Language (CQL) and applications. |
| High Throughput                                      | Capable of handling 1 million requests per second on a single server. |
| Low Latency                                          | Optimized for real-time applications.                             |
| Shard-per-Core Architecture                         | Efficient resource utilization through shard-per-core design.     |
| Auto-tuning                                          | Dynamically adjusts configurations based on workload.             |
| Multi-Data Center Replication and Failover           | Built-in support for multi-data center replication and failover.  |


---

## Getting Started

### Pre-requisites

| **Requirement**           | **Details**                                                |
|---------------------------|------------------------------------------------------------|
| Operating System          | Linux (Ubuntu, CentOS, Debian)                             |
| Hardware Requirements     | Minimum 4 GB RAM, Dual-Core Processor, SSD Storage         |


---

## Software Overview

| **Software**   | **Version** | **Description**                                                              |
|----------------|-------------|------------------------------------------------------------------------------|
| ScyllaDB       | 5.4         | A highly scalable, distributed NoSQL database with Cassandra compatibility. |

---

## System Requirements

| **Requirement**           | **Minimum Recommendation**       |
|----------------------------|-----------------------------------|
| Processor/Instance Type    | Dual-Core/T2.medium instance     |
| RAM                        | 4 Gigabyte or Higher             |
| Operating System           | 64-bit Linux (Ubuntu, CentOS)    |

---

## Important Ports



| **Port** | **Description**                                                                 | **Purpose**                                  |
|----------|---------------------------------------------------------------------------------|----------------------------------------------|
| 7000     | Inter-node communication.                                                      | Used for communication between ScyllaDB nodes. |
| 7001     | TLS inter-node communication.                                                  | Secure communication between ScyllaDB nodes. |
| 9042     | Native CQL transport for client connections.                                   | Allows clients to connect using Cassandra Query Language (CQL). |
| 9180     | Scylla REST API.                                                               | Used to interact with ScyllaDB via REST API calls. |



---

## Dependencies

### Run-time Dependencies

| **Dependency** | **Version** | **Description**                                    |
|----------------|-------------|----------------------------------------------------|
| glibc         | 2.17+       | Required for runtime compatibility.               |
| Python        | 3.x         | Needed for setup scripts and monitoring tools.    |

### Other Dependencies

| **Dependency**  | **Version** | **Description**                                    |
|------------------|-------------|----------------------------------------------------|
| Java (JRE)      | 8+          | For JMX-based monitoring.                         |
| Docker          | 20.x+       | For containerized deployments.                    |

---

## Installation

### CentOS/RHEL

1. **Add the ScyllaDB repository**
   ```bash
   sudo curl -o /etc/yum.repos.d/scylla.repo https://downloads.scylladb.com/rpm/centos/scylla.repo
   
   ```

2. **Install ScyllaDB**
   ```bash
   sudo yum install -y scylla
   ```



### Ubuntu

   1. **Add the ScyllaDB Repository**
         ```bash
        sudo curl -o /etc/apt/sources.list.d/scylla.list https://downloads.scylladb.com/deb/ubuntu/scylla.list
        ```

2. **Update and Install ScyllaDB**
 -  To update the package follow, [Step 3](https://github.com/snaatak-Downtime-Crew/Documentation/blob/durgesh_scrums_3/common_stack/operating_system/ubuntu/sop/commoncommands/README.md#1-basic-system-commands) of basic commands
   
    ```bash
    sudo apt install -y scylla
    ```
### Start the Service:
After installation, start the ScyllaDB server:
   ```bash
    sudo systemctl start scylla-server
   ```
        

## Configuration
Modify the configuration file `scylla.yaml` located at `/etc/scylla/` to customize the setup:

- Set data directories.

- Adjust logging levels.

- Configure cluster-specific settings such as seeds, tokens, and replication factors.

## Conclusion
ScyllaDB is an excellent choice for applications requiring high performance, low latency, and scalability. Its compatibility with Cassandra ensures seamless integration for existing deployments while providing enhanced throughput and efficiency.

## Contact

| **Name**           | **Email Address**                                 |
|----------------|-----------------------------------------------|
| Durgesh Sharma | durgesh.sharma.snaatak@mygurukulam.co         |

## References

| **Link**                                             | **Description**                                              |
|------------------------------------------------------|--------------------------------------------------------------|
| [Official ScyllaDB Documentation](https://www.scylladb.com/documentation/) | Detailed official documentation of ScyllaDB.                 |
| [Installation Guide for ScyllaDB](https://www.scylladb.com/download/)      | Comprehensive guide to install ScyllaDB on various platforms. |
| [Cassandra Compatibility](https://www.scylladb.com/cassandra-compatibility/) | Information about ScyllaDB's compatibility with Cassandra.   |

