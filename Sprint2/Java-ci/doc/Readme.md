# **Documentation and POC of DAST (Dynamic Application Security Testing) in Java CI Checks**

![image](https://github.com/user-attachments/assets/4aa0c132-1fbb-45bc-ad5f-2a631586676a)

---

## **Author Information**

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|                   |             |                   | Durgesh Sharma    | Internal review      | Pritam        |
|                   |             |                   | Durgesh Sharma    | L0 Review            | Shreya Jaiswal|
|                   |             |                   | Durgesh Sharma    | L1 Review            | Abhishek V    |
|                   |             |                   | Durgesh Sharma    | L2 Review            | Abhishek Dubey|

---

## **Table of Contents**

1. [**Introduction**](#introduction)
2. [**What is DAST?**](#what-is-dast)
3. [**Why DAST?**](#why-dast)
4. [**Workflow of DAST**](#workflow-of-dast)
5. [**Different Tools Used in DAST**](#different-tools-used-in-dast)
6. [**Tool Comparison**](#tool-comparison)
7. [**Advantages of DAST**](#advantages-of-dast)
8. [**POC: DAST Using OWASP ZAP**](#poc-dast-using-owasp-zap)
9. [**Best Practices**](#best-practices)
10. [**Recommendation and Conclusion**](#recommendation-and-conclusion)
11. [**Contact Information**](#contact-information)
12. [**References**](#references)

---

## **Introduction**
This document outlines Dynamic Application Security Testing (DAST) in Java CI pipelines, covering key concepts, tools, workflows, best practices, and a POC using OWASP ZAP.

## **What is DAST?**
Dynamic Application Security Testing (DAST) simulates attacks on a running web application to identify vulnerabilities. It evaluates the application from an external perspective, mimicking the approach of potential attackers.

## **Why DAST?**
| **Point**                           | **Explanation**                                                                 |
|-------------------------------------|---------------------------------------------------------------------------------|
| **Helps developers find security issues** | Identifies vulnerabilities early in the development process.                    |
| **Catching problems early is cheaper** | Fixing issues early in the Software Development Life Cycle (SDLC) is cost-effective. |
| **Unfound vulnerabilities lead to breaches** | Prevents data breaches and financial losses by uncovering vulnerabilities.       |
| **Unchecked vulnerabilities damage reputation** | Protects a company’s reputation from the fallout of security lapses.             |
| **DAST reduces human error**        | Mitigates mistakes during SDLC through automated testing.                       |

## **Workflow of DAST**
---
 ![image](https://xebia.com/wp-content/uploads/2023/02/HowDastWorks-1024x386.png.webp)

---

## **Different Tools Used in DAST**
| **Tool Name**                | **Description**                                                                 | **Features**                                                  |
|------------------------------|---------------------------------------------------------------------------------|----------------------------------------------------------------|
| **OWASP ZAP**                 | Open-source security testing tool.                                              | Automated scanners, vulnerability detection, active and passive scanning. |
| **Burp Suite**                | Comprehensive platform for web application security testing.                    | Intercepting proxy, vulnerability scanning, custom extensions.   |
| **Acunetix**                  | Automated security scanner for web applications.                                | Detects SQL injection, XSS, and other vulnerabilities.            |
| **AppSpider**                 | Dynamic application security testing tool.                                      | Scanning for Java frameworks, automated vulnerability discovery. |

## **Tool Comparison**
| **Tool Name**   | **Cost**      | **Ease of Use** | **Features**               | **Customization**   |
|-----------------|---------------|-----------------|----------------------------|----------------------|
| OWASP ZAP       | Free          | Moderate        | Basic and essential scans  | High                 |
| Burp Suite      | Expensive     | High            | Comprehensive tools        | High                 |
| Acunetix        | Expensive     | Easy            | Broad vulnerability scans  | Moderate             |
| AppSpider       | High          | Moderate        | Java-specific capabilities | High                 |

## **Advantages of DAST**
| **Advantage**                 | **Description**                                                              |
|-------------------------------|------------------------------------------------------------------------------|
| **Real-time vulnerability detection** | Identifies issues during the application’s runtime.                          |
| **Simulates real-world attacks**       | Mimics hacker techniques to expose weaknesses.                              |
| **Supports CI/CD integration**         | Integrates with pipelines to ensure ongoing security.                      |
| **Risk reduction**                     | Reduces the likelihood of breaches and ensures compliance with standards.  |

## **POC: DAST Using OWASP ZAP**

---


>
>Here is the Proof of Concept (PoC) document for your reference : [document](https://github.com/duggu7055/Snaatak/blob/main/Sprint2/Java-ci/poc/Readme.md)


---

## **Best Practices**
| **Best Practice**                         | **Description**                                                                |
|------------------------------------------|--------------------------------------------------------------------------------|
| **Define clear testing scope**            | Ensure only relevant parts of the application are tested.                     |
| **Integrate into CI/CD pipelines**        | Automate security testing for consistent evaluations.                         |
| **Regularly update tools**                | Use the latest updates to address emerging threats.                           |
| **Test in staging environments**          | Avoid disrupting production with security scans.                              |
| **Combine with other AST techniques**     | Use SAST and IAST along with DAST for comprehensive security coverage.        |

## **Recommendation and Conclusion**
For this project, **OWASP ZAP** is recommended due to its open-source nature, extensive community support, and suitability for Java applications. Its features and cost-effectiveness make it an ideal choice for initial and ongoing security testing.

## **Contact Information**
| **Name**           | **Email Address**                              |
|---------------------|-----------------------------------------------|
| Durgesh Sharma      | durgesh.sharma.snaatak@mygurukulam.co         |

## **References**
| **Link** | **Description** |
|------------------------------------------------------|------------------|
| https://www.ibm.com/topics/dynamic-application-security-testing| DAST and types |
| https://www.techmagic.co/blog/dast| DAST tool |
