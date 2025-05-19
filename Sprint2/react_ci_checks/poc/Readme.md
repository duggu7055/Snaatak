# POC : Static Code Analysis On React


## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**         |
|--------------------|-------------|-------------------|-------------------|----------------------|----------------------|
|                    |             |                   | Durgesh Sharma    | Internal review      | Pritam               |
|                    |             |                   | Durgesh Sharma    | L0 Review            | Shreya Jaiswal       |
|                    |             |                   | Durgesh Sharma    | L1 Review            | Abhishek V           |
|                    |             |                   | Durgesh Sharma    | L2 Review            | Abhishek Dubey       |


---

# Table of Contents
- [Introduction](#introduction)
- [Pre-requisites](#pre-requisites)
- [Security Ports](#security-ports)
- [Integration and Configuration Guide](#integration-and-configuration-guide)
  - [SonarQube](#step-2-sonarqube)
  -  [Steps to Integrate SonarQube with Jenkins](#steps-to-integrate-sonarqube-with-jenkins)
  -  [Steps to Jenkins Job and Configuration](#steps-to-jenkins-job-and-configuration)
  -  [Configuring a Webhook in GitHub](#configuring-a-webhook-in-github)

- [Workflow](#workflow)
- [Conclusion](#conclusion)
- [Contact Information](#contact-information)
- [References](#references)


---

# Introduction

This document provides a step-by-step guide for conducting a Proof of Concept (PoC) to set up Static Code Analysis. It includes details on the required prerequisites, build-time and runtime dependencies, and methods to resolve potential errors.

# Pre-requisites
| **Specification**      | **Details**         |
|-------------------------|---------------------|
| **Operating System**    | Ubuntu 22.04      |
| **Instance type**       | t2.medium             |
| **Hard Disk**           | 20 GB              |
| **RAM**                 | 4 GB               |

---

# Security ports

| **Port** | **Protocol** | **Source Side**    | **Destination Side** | **Use Case**                     |
|----------|--------------|--------------------|-----------------------|-----------------------------------|
| 22       | TCP          | Any                | Server               | SSH Access for remote login      |
| 5432     | TCP          | Application Server | Database Server      | PostgreSQL database access       |
| 9000     | TCP          | Any                | Server               |  SonarQube |
| 8080    | TCP          | Any                | Server               |  Jenkins |

---

# **Integration and Configuration Guide** 

## **Step 1. Update System Packages**

>
>  **Update system**  
>  **Follow Step 3 here**: [System update Commands](https://github.com/snaatak-Downtime-Crew/Documentation/blob/main/common_stack/operating_system/ubuntu/sop/commoncommands/README.md#1-basic-system-commands)
>
> 

## **Step 2. SonarQube**

>
>  **To install and configure the sonarqube**  
[Follow this document](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-157-Vardaan/application-ci/checks/java/static-code-analysis/poc/README.md) 
>   
>
> 

#### **Create a project in sonarqube**  
>
> We begin by providing the necessary project details for the code analysis.

![image](https://miro.medium.com/v2/resize:fit:720/format:webp/0*427zFkjPQH1yTNN_.png)

---

#### **Select the repository information for the code analysis** 
>
> choose the environment in which we’ll perform the build for code analysis `(e.g.- Jenkins)`

![image](https://miro.medium.com/v2/resize:fit:720/format:webp/0*LMnlD_lvrSgN1U0m.png)

---

#### **Generate Token: Create an authentication token in SonarQube**
>
> By utilizing this token, the appropriate platform for the project’s code analysis will be accessible.

![image](https://github.com/user-attachments/assets/8a2cc014-c67c-437c-b045-509adb3a0765)

---

## **Steps To Integrate SonarQube With Jenkins**

#### **Step 1:** **Install Pluggin**

 >
>First go to Jenkins dashboard and download the `SonarQube Scanner` plugin. 

![image](https://media.geeksforgeeks.org/wp-content/uploads/20240317071816/install-sonar.png)

---

#### **Step 2:** **Setup a sonarqube scanner**

 >Go to Jenkins dashboard and go inside the tools section. Here you setup a sonar scanner which will scan the code.
>

![image](https://media.geeksforgeeks.org/wp-content/uploads/20240317071948/sonar-scanner.png)

---

#### **Step 3:** **configure sonarqube server**

 >Now go into system section to configure sonarqube server.
>

![image](https://media.geeksforgeeks.org/wp-content/uploads/20240317072013/configure-sonar.png)

---

#### **Step 4:** **Create the secret text credential**

 >Create the secret text credential using Sonarqube token.
>

![image](https://media.geeksforgeeks.org/wp-content/uploads/20240317072035/secret-creation.png)

---

#### **Step 5:** **attach the credential to the sonarqube configuration**



![image](https://media.geeksforgeeks.org/wp-content/uploads/20240317072053/attach-the-jenkins-sonar.png)

---

## **Steps To Jenkins Job And The Configuration**

#### **Step 1:** **Create a pipeline**

 >Give the pipeline a name and select ok.
>

![image](https://www.tatvasoft.com/blog/wp-content/uploads/2025/04/image-6-52.jpg)

#### **Step 2: Jenkins job configuration**
 >On the configuration screen, select the General tab, and then select the GitHub project box. The Project URL should then be updated to include the URL you obtained from the repository.
>

![image](https://www.tatvasoft.com/blog/wp-content/uploads/2025/04/image-7-37.jpg)

---

 >Select the “GitHub hook trigger for GITScm polling” in the Build Triggers section, as seen in the picture below.
>

![image](https://www.tatvasoft.com/blog/wp-content/uploads/2025/04/image-8-31.jpg)

---

#### **Configure a Pipeline Job through a Direct Script**

 >an write the pipeline creation script by selecting the “Pipeline script” option in the “Definition” field. Check out the below image for reference.
 After writing the script here, click on the `“Save”` button at the end.
>

![image](https://www.tatvasoft.com/blog/wp-content/uploads/2025/04/image-11-14.jpg)

---

## **Configuring a Webhook in GitHub**
 >Open your GitHub repository’s “Settings” menu,
>

![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/2.PNG)

---

 >Then select the “Webhooks” tab.
>

![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/3.PNG)

---

 >Choose “Add webhook” on the “Webhooks” page.
>

![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/3.PNG)

---

 >add the Payload URL field to your Jenkins URL(/github-webhook/). For instance, `HTTP://addJenkinsURL/github-webhook/`..

 Alter the property of Content type to `“application/json”` and SSL Verification to` Disable (not recommended)` as well.
>

![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/4.PNG)

---

 >Select "Add Webhook"
>

![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/5.PNG)

---

## **Workflow**
Whenever a developer commits their code to GitHub, a webhook will trigger a Jenkins build. Jenkins will then build the code and generate a static analysis report, which will be displayed on the SonarQube server. This workflow ensures continuous integration, quality checks, and code health monitoring.

> Jenkins server
> 
![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/jen1.PNG)

---

> Sonarqube Server
> 
![image](https://github.com/duggu7055/Snaatak/blob/main/imgs/sona1.PNG)


---

## **Conclusion**
The POC demonstrates an automated CI/CD pipeline where GitHub commits trigger Jenkins builds, with static code analysis results displayed in SonarQube. This ensures efficient code quality checks and faster feedback, laying a strong foundation for a scalable DevOps workflow.

---

## Contact Information

| **Name**           | **Email Address**                                 |
|----------------|-----------------------------------------------|
| Durgesh Sharma | durgesh.sharma.snaatak@mygurukulam.co         |



---

## References
| Reference                         | Link                                              |
|-----------------------------------|---------------------------------------------------|
| Sonarqube Installation            | [Click Here](https://github.com/snaatak-Downtime-Crew/Documentation/blob/SCRUMS-157-Vardaan/application-ci/checks/java/static-code-analysis/poc/README.md)    |
| Static Code Analysis Document     | [Click Here](https://github.com/duggu7055/Snaatak/blob/main/Sprint2/react_ci_checks/Readme.md)        |









