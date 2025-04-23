
# Commit Hooks

## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|          |           |         |  Durgesh Sharma   | Internal review      | Pritam        |
|          |           |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|          |             |                   | Durgesh Sharma   | L1 Review            | Abhishek V    |
|          |             |                   |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |


## Table of Contents

1. [Introduction](#introduction)
2. [Purpose of Commit Hooks](#purpose-of-commit-hooks)
3. [Types of Commit Hooks](#types-of-commit-hooks)
4. [How to Use Git Hooks](#how-to-use-git-hooks)
5. [FAQ](#faq)
6. [Contact Information](#contact-information)
7. [References](#references)

---

## Introduction

Git commit hooks are scripts that automate tasks and enforce rules during the Git workflow. They help maintain code quality and consistency.

---


## Purpose of Commit Hooks

The primary goals of commit hooks include:

| Purpose                | Description                                                                 |
|------------------------|-----------------------------------------------------------------------------|
| Enforcing Code Quality | Ensure that code adheres to established standards and conventions.          |
| Automation             | Automate repetitive tasks such as formatting or testing.                    |
| Preventing Errors      | Catch mistakes early in the development cycle.                              |
| Enhancing Collaboration| Facilitate better team workflows by implementing shared practices.          |

---

## Types of Commit Hooks

Git hooks are divided into two categories:

### 1. Client-Side Hooks

These hooks are triggered on individual developers' machines and primarily assist in tasks like code validation and preparation. Examples include:

| Hook Name            | Description                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| **Pre-Commit**       | Runs before a commit is created to check for issues in the staged changes.  |
| **Prepare-Commit-Msg** | Edits the commit message template before the commit is finalized.          |
| **Commit-Msg**       | Validates or modifies the commit message.                                   |
| **Post-Commit**      | Runs after the commit is finalized and can be used for notifications.       |


### 2. Server-Side Hooks

These hooks execute on the server hosting the Git repository and enforce rules at a broader level. Examples include:

| Hook  Name             | Description                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **Pre-Receive**    | Runs before changes are accepted into the repository.                      |
| **Update**         | Checks individual branches before updates.                                 |
| **Post-Receive**   | Executes tasks after changes are accepted, such as notifying external services. |

---

## How to Use Git Hooks

### Setting Up Git Hooks

1. Navigate to the `.git/hooks` directory in your Git project.
2. Identify the hook script you want to customize (e.g., `pre-commit`).
3. Create or modify the script file, ensuring it is executable:

   ```bash
   chmod +x .git/hooks/<hook-name>
   ```

4. Add your desired script logic to automate tasks or enforce rules.



## FAQ

#### Q1: Are Git hooks version-controlled?

No, Git hooks are not version-controlled. They are stored locally in the `.git/hooks` directory. You can use tools like Husky or shell scripts to share hook configurations.

#### Q2: Can I bypass a Git hook?

Yes, you can bypass a hook by using the `--no-verify` flag when running Git commands, e.g.,

```bash
git commit --no-verify
```

#### Q3: Are hooks only available in Git?

No, other version control systems like Mercurial also provide similar hook functionality.

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




