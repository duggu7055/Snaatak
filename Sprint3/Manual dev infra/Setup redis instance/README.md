# Setup Redis Instance Manually on AWS - Documentation

<div align="center">
    <img width="600" height="300" alt="Terraform" src="https://1000logos.net/wp-content/uploads/2020/08/Redis-Logo.png">
</div>


## Author Information

| **Last Modified** | **Version** | **Author**        | **Level**            | **Reviewer**         |
|--------------------|-------------|-------------------|----------------------|----------------------|
| 18-05-2025        | V1          | Durgesh Sharma    | Internal review      | Pritam               |
|                   |             | Durgesh Sharma    | L0 Review            | Shreya Jaiswal       |
|                   |             | Durgesh Sharma    | L1 Review            | Abhishek V           |
|                   |             | Durgesh Sharma    | L2 Review            | Abhishek Dubey       |

---

## Table of Contents
1. [Purpose](#purpose)
2. [Introduction](#introduction)
3. [Key Features of Redis on AWS](#key-features-of-redis-on-aws)
4. [Benefits of Setting Up Redis on AWS](#benefits-of-setting-up-redis-on-aws)
5. [Setup Redis Instance on AWS](#setup-redis-instance-on-aws)
6. [Configuring Security Groups for Redis](#configuring-security-groups-for-redis)
7. [Conclusion](#conclusion)
8. [Contact Information](#contact-information)
9. [References](#references)

---

## Purpose
This document serves as a guide to manually setting up **Redis on AWS**. It provides step-by-step instructions for configuring a Redis instance and securing it using AWS Security Groups, ensuring controlled access to the Redis instance.

---

## Introduction
**Redis** is a high-performance, in-memory data structure store used for caching, session management, and message brokering. Running Redis on AWS provides scalability, security, and integration with other AWS services, making it an ideal choice for cloud-native applications.

---

## Key Features of Redis on AWS

| Key Feature               | Description                                                                                         |
|---------------------------|-----------------------------------------------------------------------------------------------------|
| **In-Memory Storage**     | Redis stores data in memory for ultra-fast access.                                                |
| **Persistence**           | Allows for data durability with AOF (Append-Only File) and RDB (Redis Database) snapshotting.     |
| **Built-in Replication**  | Supports primary-replica configurations for high availability.                                     |
| **Flexible Data Types**   | Offers strings, lists, sets, hashes, and other data types to support various use cases.           |

---

## Benefits of Setting Up Redis on AWS

| Benefit                     | Description                                                                                         |
|-----------------------------|-----------------------------------------------------------------------------------------------------|
| **Scalability**             | Easily scale vertically by upgrading instance types as your workload grows.                       |
| **Security**                | Integration with AWS security features, including Security Groups and VPCs, helps manage access and secure data. |
| **High Availability**       | AWS infrastructure enables reliable and redundant setups for Redis.                                 |
| **Ease of Integration**     | Redis on AWS works seamlessly with other AWS services like EC2, Lambda, and RDS.                   |

---

## Setup Redis Instance on AWS

1. **Launch an EC2 Instance**:
   - Open the **EC2 Dashboard** in the AWS Management Console.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/1.PNG)

   - Select Instances and click Launch Instances.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/2.PNG)

2. **Instance Configuration**:
   - Name your EC2 instance.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/3.PNG)

   - Choose the Amazon Machine Image (AMI) based on your requirements (e.g., Amazon Linux or Ubuntu).
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/4.PNG)

   - Select the instance type.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/5.PNG)

   - Create either a new key pair or use an existing one.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/6.PNG)

3. **Configure Network and Subnet** based on your VPC setup:
   > Assign an **Elastic IP** (optional) if you need a static IP address.
   >
   ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/8.PNG)

4. **Storage and Tags**:
   - Allocate sufficient **storage** as per your needs, and tag the instance for easy identification.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/9.PNG)

5. **Launch and Monitor**:
   - Click on **Launch Instance** to create your instance and monitor it in the dashboard.
     ![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/redis%20instance/11.PNG)

---

## Configuring Security Groups for Redis

For detailed instructions on configuring security groups for Redis, please refer to the [Security Group POC](https://github.com/mygurukulam-p10/Documentation-P10-Snaatak/tree/main/Manual-Dev-Infra-Setup/Setup%20redis%20manually/Security%20Group).

---

## Conclusion

Setting up Redis manually on AWS enables fine-tuned control over performance, security, and scalability. By configuring the Redis instance and securing it with AWS Security Groups, you can build a robust and secure caching solution for your applications.

---

## Contact Information

| **Name**           | **Email Address**                              |
|---------------------|-----------------------------------------------|
| Durgesh Sharma      | durgesh.sharma.snaatak@mygurukulam.co         |

---

## References

| Reference                                  | Link                                                                                                     |
|--------------------------------------------|----------------------------------------------------------------------------------------------------------|
| AWS Documentation on EC2                   | [EC2 Documentation](https://docs.aws.amazon.com/ec2/index.html)                                          |
| Redis Documentation                        | [Redis Documentation](https://redis.io/documentation)                                                    |

---
