#!/bin/bash
cp hooks/commit-msg .git/hooks/commit-msg
chmod +x .git/hooks/commit-msg
echo "Hook installed successfully."
