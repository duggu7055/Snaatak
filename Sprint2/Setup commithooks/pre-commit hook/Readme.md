# Setup Pre-Commit Hook

<div align="center">
    <img width="300" alt="Terraform" src="https://hamon.in/wp-content/uploads/2023/05/git-hooks.png">
</div>

---

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|       |           |         |  Durgesh Sharma   | Internal review      | Pritam        |
|          |           |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|         |             |                   | Durgesh Sharma   | L1 Review            | Abhishek V    |
|          |             |                   |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |

---

## Table of Contents

1. [Introduction](#introduction)
2. [Pre-requisites](#pre-requisites)
3. [Step-by-step Setup Guide](#step-by-step-setup-guide)
4. [Conclusion](#conclusion)
5. [Contact Information](#contact-information)
6. [References](#references)

---

## Introduction
Pre-commit hooks are a powerful way to enforce coding standards and project-specific rules before changes are committed to a repository. In this guide, we will set up a pre-commit hook to ensure all commit messages are mapped to JIRA ticket numbers. This helps maintain traceability and ensures consistency in development workflows.

---

## Pre-requisites
Before proceeding, ensure you have the following:

1. **Git** installed on your local machine. 
2. Access to your project repository.
3. Familiarity with basic Git operations.
4. A valid JIRA project with tickets to reference.

---

## Step-by-Step Setup Guide

### Step 1: Navigate to Your Repository
Open a terminal and navigate to your Git repository.

```bash
cd /path/to/your/repository
```

### Step 2: Create a Pre-Commit Hook File
Navigate to the `.git/hooks` directory and create a `commit-msg` hook file if it doesn’t already exist.

```bash
cd .git/hooks
nano commit-msg
```

### Step 3: Add Hook Logic
Insert the following script into the `commit-msg` file to enforce JIRA ticket mapping:

```bash
#!/bin/bash

# Regex to match JIRA ticket format (e.g., PROJ-1234)
JIRA_REGEX='[A-Z]+-[0-9]+'

# Read the commit message
COMMIT_MSG=$(cat "$1")

if ! [[ $COMMIT_MSG =~ $JIRA_REGEX ]]; then
  echo "\033[31mERROR: Commit message must include a valid JIRA ticket (e.g., PROJ-1234).\033[0m"
  exit 1
fi

exit 0
```

### Step 4: Make the Hook Executable
Set executable permissions for the hook file.

```bash
chmod +x commit-msg
```

### Step 5: Test the Hook
1. Try committing changes with and without a JIRA ticket in the commit message.
2. Example of a valid commit message:

   ```
   PROJ-1234: Fixed a bug in the authentication module.
   ```

3. Example of an invalid commit message:

   ```
   Fixed a bug in the authentication module.
   ```

The hook should reject commits without a valid JIRA ticket.

---

## Conclusion
By setting up this pre-commit hook, you ensure all commit messages are linked to JIRA tickets, improving traceability and aligning development processes with project management practices. This small but crucial step can significantly enhance collaboration and accountability within your team.

---

## Contact Information

| **Name**           | **Email Address**                                 |
|----------------|-----------------------------------------------|
| Durgesh Sharma | durgesh.sharma.snaatak@mygurukulam.co         |

---

## References
| Reference                         | Link                                              |
|-----------------------------------|---------------------------------------------------|
| Git Documentation on Hooks        | [Git Hooks](https://git-scm.com/docs/githooks)    |
| Husky                             | [Husky](https://typicode.github.io/husky/)        |
| Prettier Git Hooks                | [Prettier](https://prettier.io/docs/en/precommit.html) |


