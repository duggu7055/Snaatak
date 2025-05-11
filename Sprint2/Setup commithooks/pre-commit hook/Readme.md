Setup Pre-Commit Hook
Introduction
Pre-commit hooks are a powerful way to enforce coding standards and project-specific rules before changes are committed to a repository. In this guide, we will set up a pre-commit hook to ensure all commit messages are mapped to JIRA ticket numbers. This helps maintain traceability and ensures consistency in development workflows.

Pre-requisites
Before proceeding, ensure you have the following:

Git installed on your local machine. Download Git
Access to your project repository.
Familiarity with basic Git operations.
A valid JIRA project with tickets to reference.
Step-by-Step Setup Guide
Step 1: Navigate to Your Repository
Open a terminal and navigate to your Git repository.

cd /path/to/your/repository
Step 2: Create a Pre-Commit Hook File
Navigate to the .git/hooks directory and create a commit-msg hook file if it doesn’t already exist.

cd .git/hooks
nano commit-msg
Step 3: Add Hook Logic
Insert the following script into the commit-msg file to enforce JIRA ticket mapping:

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
Step 4: Make the Hook Executable
Set executable permissions for the hook file.

chmod +x commit-msg
Step 5: Test the Hook
Try committing changes with and without a JIRA ticket in the commit message.

Example of a valid commit message:

PROJ-1234: Fixed a bug in the authentication module.
Example of an invalid commit message:

Fixed a bug in the authentication module.
The hook should reject commits without a valid JIRA ticket.

Conclusion
By setting up this pre-commit hook, you ensure all commit messages are linked to JIRA tickets, improving traceability and aligning development processes with project management practices. This small but crucial step can significantly enhance collaboration and accountability within your team.

Contact Information
For questions or assistance, feel free to reach out:

Email: devops.support@example.com
GitHub Issues: Open an Issue
References
Git Hooks Documentation
JIRA Documentation
