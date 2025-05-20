# Jenkins AWS Infrastructure 

<div align="center">
    <img width="600" height="300" alt="Terraform" src="https://logos-world.net/wp-content/uploads/2023/12/Jenkins-Emblem.png">
</div>

## Author Information

| **Last Modified** | **Version** | **Author**        | **Level**            | **Reviewer**         |
|--------------------|-------------|-------------------|----------------------|----------------------|
|    19-05-2025     |   V1        | Durgesh Sharma    | Internal review      | Pritam               |
|                   |             | Durgesh Sharma    | L0 Review            | Shreya Jaiswal       |
|                   |             | Durgesh Sharma    | L1 Review            | Abhishek V           |
|                   |             | Durgesh Sharma    | L2 Review            | Abhishek Dubey       |

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Infrastructure Diagram](#infrastructure-diagram)
4. [Conclusion](#conclusion)
5. [Contact Information](#contact-information)
6. [References](#references)

## Introduction

This README explains how to set up Jenkins on Amazon Web Services (AWS) cloud infrastructure, including a diagram of the architecture and deployment details.

## Prerequisites

| Tool                  | Description                                  |
|-----------------------|----------------------------------------------|
| AWS Management Console | Required for provisioning AWS resources.    |

## Description

| Name                          | Description                                                         |
|-------------------------------|---------------------------------------------------------------------|
| **User Access**               | Users connect through the internet.                                |
| **Public Subnets & Security Groups** | Public components allow internet traffic, controlled by security rules. |
| **Private Components & NAT Gateway** | Private resources access the internet securely through a NAT gateway. |
| **Bastion Instances**         | Provide secure access to private resources.                        |
| **VPCs (Virtual Private Clouds)** | Isolated networks for all components.                             |
| **Load Balancer & High Availability** | Distributes traffic to ensure the system stays online and performs well. |

## Infrastructure Diagram

![Diagram](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjm9uiQLf3Y2PPlZxPHvhSssk7FQhln8Bl_zx-rPHRbWe7Uv7sbsi3FvdsCVijfn6fNxg4pG6joa6AyuzmQ9RHDEvxIWGXn-8AnwJINVt93u0ueZEEVXKZr_0tCWvg2kfhyphenhyphenUXxMNrWfULzwqSiV4Fo2IlXXLplw7A2XLLoLTEOl4JqADf_Ym3HWhWCnF1o/s16000/Untitled%20Diagram.drawio.png)

## Conclusion

The Jenkins AWS Infrastructure outlined here ensures high availability, security, and scalability for continuous integration and deployment workflows. By leveraging AWS services such as VPC, Load Balancers, and NAT Gateways, alongside Jenkins' robust capabilities, this setup provides a reliable platform for managing CI/CD pipelines. The modularity of this architecture also facilitates easy scaling and monitoring, making it suitable for diverse project needs.

---

## Contact Information

| **Name**           | **Email Address**                              |
|---------------------|-----------------------------------------------|
| Durgesh Sharma      | durgesh.sharma.snaatak@mygurukulam.co         |

---

## References

| Source                                                                                  | Description              |
|----------------------------------------------------------------------------------------|--------------------------|
| [AWS Jenkins Integration](https://docs.aws.amazon.com/jenkins/latest/userguide/)       | Official AWS Jenkins Documentation |
| [Jenkins CI/CD Best Practices](https://www.jenkins.io/doc/book/pipeline/)             | Jenkins Pipeline Best Practices |
