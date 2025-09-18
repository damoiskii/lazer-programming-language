#!/bin/bash

# Script to merge deploy branch into main branch
# This script will update main with changes from deploy

set -e  # Exit on any error

echo "🔄 Starting merge from deploy to main branch..."

# Check if we're in a git repository
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo "❌ Error: Not in a git repository"
    exit 1
fi

# Get current branch
CURRENT_BRANCH=$(git branch --show-current)
echo "📍 Current branch: $CURRENT_BRANCH"

# Fetch latest changes from remote
echo "📥 Fetching latest changes from remote..."
git fetch origin

# Check if deploy branch exists
if ! git show-ref --verify --quiet refs/heads/deploy; then
    echo "❌ Error: deploy branch does not exist locally"
    exit 1
fi

# Check if main branch exists
if ! git show-ref --verify --quiet refs/heads/main; then
    echo "❌ Error: main branch does not exist locally"
    exit 1
fi

# Switch to main branch
echo "🔀 Switching to main branch..."
git checkout main

# Pull latest main from remote
echo "⬇️  Pulling latest main from remote..."
git pull origin main

# Merge deploy branch into main
echo "🔀 Merging deploy branch into main..."
git merge deploy --no-ff -m "Merge deploy branch into main"

# Check if merge was successful
if [ $? -eq 0 ]; then
    echo "✅ Successfully merged deploy into main"
    
    # Ask if user wants to push to remote
    echo ""
    read -p "🚀 Do you want to push the updated main branch to remote? (y/n): " -n 1 -r
    echo ""
    
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        echo "⬆️  Pushing main to remote..."
        git push origin main
        echo "✅ Successfully pushed main to remote"
    else
        echo "⏸️  Skipping push to remote. Run 'git push origin main' when ready."
    fi
    
    # Switch back to original branch if it wasn't main
    if [ "$CURRENT_BRANCH" != "main" ]; then
        echo "🔄 Switching back to $CURRENT_BRANCH branch..."
        git checkout "$CURRENT_BRANCH"
    fi
    
    echo ""
    echo "🎉 Merge completed successfully!"
    echo "📊 Summary:"
    echo "   - deploy branch merged into main"
    echo "   - You are now on: $(git branch --show-current)"
    
else
    echo "❌ Merge failed. Please resolve conflicts manually."
    echo "💡 Tips:"
    echo "   - Use 'git status' to see conflicted files"
    echo "   - Edit files to resolve conflicts"
    echo "   - Use 'git add <file>' after resolving conflicts"
    echo "   - Use 'git commit' to complete the merge"
    exit 1
fi