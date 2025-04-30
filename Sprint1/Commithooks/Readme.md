

# Understanding of Commit Hooks

<div align="center">
    <img width="300" alt="Terraform" src="https://hamon.in/wp-content/uploads/2023/05/git-hooks.png">
</div>




## Author Information

| **Created**       | **Version** | **Last Modified** | **Author**        | **Level**            | **Reviewer**  |
|--------------------|-------------|-------------------|-------------------|----------------------|---------------|
|   26-04-2025      |   V1        | 28-04-2025        |  Durgesh Sharma   | Internal review      | Pritam        |
|   26-04-2025        |           |         |   Durgesh Sharma  | L0 Review            | Shreya Jaiswal|
|   26-04-2025        |             |                   | Durgesh Sharma   | L1 Review            | Abhishek V    |
|   26-04-2025       |             |                   |  Durgesh Sharma  | L2 Review            | Abhishek Dubey    |


## Table of Contents

1. [Introduction](#introduction)
2. [Purpose of Commit Hooks](#purpose-of-commit-hooks)
3. [Types of Commit Hooks](#types-of-commit-hooks)
4. [How to Use Git Hooks](#how-to-use-git-hooks)
5. [Feature](#feature)
6. [FAQs](#faqs)
7. [Conclusion](#conclusion)
8. [Contact Information](#contact-information)
9. [References](#references)

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

<img width="900" length="600" alt="Terraform" src="https://d8it4huxumps7.cloudfront.net/uploads/images/652f8091f32cc_git_hooks_06.jpg?d=2000x2000">

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

---

## Feature

| Feature                          | Description                                                                                  |
|----------------------------------|----------------------------------------------------------------------------------------------|
| **Automation of Tasks**          | Streamlines repetitive tasks, ensuring efficient and consistent execution.                  |
| **Pre-Commit and Post-Commit Support** | Integrates hooks to enforce rules before committing or after pushing code.                  |
| **Quality Control**              | Ensures adherence to coding standards and project guidelines through automated checks.       |
| **Customization**                | Allows configuration to match specific project needs and workflows.                         |
| **Error Prevention**             | Reduces errors by catching potential issues early in the development lifecycle.              |
| **Lightweight Execution**        | Operates with minimal overhead, ensuring performance is not hindered.                       |




---

## FAQs

#### 1. What are Git commit hooks?
Git commit hooks are scripts that run automatically during various stages of the Git lifecycle (e.g., before a commit, after a commit). They help enforce rules, automate tasks, and maintain code quality.

#### 2. How do commit hooks help with error prevention?
By automating checks before and after commits, commit hooks can catch issues like coding errors, missing tests, or violations of code standards early, preventing them from entering the repository.

#### 3. Can commit hooks be customized?
Yes, commit hooks are highly customizable. Developers can write scripts for specific checks and tasks that suit the needs of their project, such as running linters or formatting code.

#### 4. Do I need special permissions to use commit hooks?
Yes, the hook scripts need to be executable. You can use the chmod +x command to give them the necessary permissions.

#### 5. Can server-side hooks be used in collaboration with client-side hooks?
Yes, server-side hooks can be used to enforce rules on the repository level, while client-side hooks allow developers to ensure code quality before it reaches the repository.

---

## Conclusion

Commit hooks enhance development by automating checks and enforcing standards during commits. They help catch errors early, improve code quality, and maintain workflow consistency, making them an essential tool for robust software development.

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




