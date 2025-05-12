# Setup Application Code Repositories

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**         |
|--------------------|-------------|-------------------|-------------------|----------------------|----------------------|
|                    |             |                   | Durgesh Sharma    | Internal review      | Pritam               |
|                    |             |                   | Durgesh Sharma    | L0 Review            | Shreya Jaiswal       |
|                    |             |                   | Durgesh Sharma    | L1 Review            | Abhishek V           |
|                    |             |                   | Durgesh Sharma    | L2 Review            | Abhishek Dubey       |

This guide explains how to set up application code repositories in a Version Control System (VCS).

---

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Step-By-Step Setup Guide](#step-by-step-setup-guide)
4. [Decision-Making Process](#decision-making-process)
5. [Conclusion](#conclusion)
6. [Contact Information](#contact-information)
7. [References](#references)

---

## Introduction

The OT-Microservices Project is a modular system designed to streamline organizational tasks using a microservices architecture. It includes the following components: Frontend, employee-api, attendance-api, and salary-api.

---

## Prerequisites

1. A working VCS (e.g., GitHub, GitLab, Bitbucket, etc.).
2. Admin or Owner access to your repositories.

---

## Step-By-Step Setup Guide

1. Go to GitHub and log in to your account.
2. Click the `+` icon in the top-right corner and select **New repository**.
3. Fill in the details:
   - **Repository Name**: Examples:
     - [Notification-worker](https://github.com/Team-Downtime-Crew/Notification-worker)
     - [Frontend](https://github.com/Team-Downtime-Crew/frontend)
     - [employee-api](https://github.com/Team-Downtime-Crew/employee-api)
     - [attendance-api](https://github.com/Team-Downtime-Crew/attendance-api)
     - [salary-api](https://github.com/Team-Downtime-Crew/salary-api)
   - **Description**: Add a brief description of the repository.
   - **Visibility**: Choose either **Public** or **Private**.
   - `Check` **Initialize this repository with a README**.
4. Click **Create repository**.

   ![Screenshot 2024-12-01 at 10 13 27 PM](https://github.com/duggu7055/Snaatak/blob/main/imgs/Capture.PNG)

---

## Decision-Making Process

The choice to use a micro-repository structure for this project was guided by the following factors:

1. **Modularity**:
   - Each repository corresponds to a specific microservice or component, promoting independent development and deployment.
   - Easier to maintain and scale individual services.

2. **Collaboration**:
   - Smaller, focused repositories enable different teams to work on individual components without stepping on each other’s toes.
   - Clear repository boundaries reduce merge conflicts and improve code review efficiency.

3. **Versioning and Dependency Management**:
   - Independent repositories allow for precise version control and dependency isolation.
   - Changes in one microservice do not inadvertently affect others.

4. **Deployment Pipelines**:
   - Separate repositories align well with CI/CD pipelines, allowing microservices to be built, tested, and deployed independently.

5. **Best Practices**:
   - The micro-repository approach aligns with industry best practices for microservices architecture.

   ![Screenshot 2024-12-01 at 10 13 27 PM](https://github.com/duggu7055/Snaatak/blob/main/imgs/Capture1.PNG)

---

## Conclusion

A well-organized repository structure is key to the success of the OT-Microservices Project. By setting up clear repositories, directories, and version control practices, you enable collaborative and maintainable development.

---

## Contact Information

| **Name**           | **Email Address**                              |
|---------------------|-----------------------------------------------|
| Durgesh Sharma      | durgesh.sharma.snaatak@mygurukulam.co         |

---

## References

| **Link**                                                 | **Description**        |
|----------------------------------------------------------|------------------------|
| [GitHub Repositories Guide](https://docs.github.com/en/repositories) | GitHub Documentation |
| [Monorepo vs Micro Repo](https://github.com/snaatak-Downtime-Crew/Documentation/blob/main/vcs_design%20%2B%20poc/mono-micro%20repo/conclusion%20document/README.md) | GitHub Documentation |

