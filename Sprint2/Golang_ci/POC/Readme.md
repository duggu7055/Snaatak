
# POC : Golang  Static Code Analysis 

---

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**         |
|--------------------|-------------|-------------------|-------------------|----------------------|----------------------|
|                    |             |                   | Durgesh Sharma    | Internal review      | Pritam               |
|                    |             |                   | Durgesh Sharma    | L0 Review            | Shreya Jaiswal       |
|                    |             |                   | Durgesh Sharma    | L1 Review            | Abhishek V           |
|                    |             |                   | Durgesh Sharma    | L2 Review            | Abhishek Dubey       |

---

## Table fo content
- [Introduction](#introduction)
- [Prerequisites](#pre-requisites)
- [System Requirements](#system-requirements)
- [Dependencies](#dependencies)
- [Getting Started](#getting-started)
- [Conclusion](#conclusion)
- [Contact Information](#contact-information)
- [References](#references)

## Introduction
GolangCI-Lint combines multiple linters into a fast, unified tool that catches issues early. It automates code quality checks to enforce best practices and prevent errors before production.


## Pre-requisites

### System Requirements

| Hardware Specifications | Minimum Recommendation |
|-------------------------|-------------------------|
| CPU                     | 1 GHz                   |
| RAM                     | 512 MB                  |
| Disk Space              | 100 MB                  |

### Dependencies

#### Build Time Dependency
- Go  (version 1.20.5 or higher)

## Getting Started 

### Step 1 : Install Go

> [Follow this document]()
>
>


### Step 2 : Install GolangCI-Lint
Install GolangCI-Lint using the following command:
```
curl -sSfL https://raw.githubusercontent.com/golangci/golangci-lint/master/install.sh | sudo sh -s -- -b /usr/local/bin v1.64.8
```
Verify the installation:
```
golangci-lint --version
```



### Step 3 : Clone the project repository
We have a projcet which is based on go language 
```
git clone https://github.com/OT-MICROSERVICES/employee-api.git
```


### Step 4 : Run GolangCI-Lint
```
cd employee-api

```

### Step 5 : Create `.golangci.yml` file
>  The `.golangci.yml` file is used to configure the settings for the GolangCI-Lint tool, which runs static code analysis on Go projects.
>

```
touch .golangci.yml
```


### Step 6 : edit  `.golangci.yml` file
```
nano .golangci.yml

```

### Step 7 : Run GolangCI-Lint
```
golangci-lint run --config .golangci.yml

```


### 



## Conclusion
GolangCI-Lint is a fast, flexible tool for static code analysis in Go projects. It ensures high code quality by detecting errors and vulnerabilities early in development, making it an essential choice for our project.

## Contact Information

| **Name**           | **Email Address**                              |
|---------------------|-----------------------------------------------|
| Durgesh Sharma      | durgesh.sharma.snaatak@mygurukulam.co         |

## References 

| Reference                                | Link                                                                 |
|-----------------------------------------|----------------------------------------------------------------------|
| **Official ESLint Documentation**       | [ESLint Docs](https://eslint.org/docs/latest/)                      |
| **SonarQube for JavaScript**            | [SonarQube Docs](https://www.sonarqube.org/features/multi-languages/javascript/) |
