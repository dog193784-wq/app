# GitHub App Creation Notes for CareLink

If you are using **GitHub App creation** for automation (CI/CD, release tagging, dependency updates), use this checklist:

1. Create a GitHub App with least-privilege permissions:
   - Repository contents: Read/Write (only if automation needs commits/tags)
   - Pull requests: Read/Write (for PR comments/status)
   - Actions: Read (or Write only when dispatch is needed)
2. Install the app only on the CareLink repository.
3. Store App ID, Installation ID, and private key in GitHub Actions secrets.
4. Use short-lived installation tokens in workflows; never hardcode tokens.
5. Rotate private keys periodically and revoke old keys.
6. Keep release workflow separate from PR validation workflow.

> This document is intentionally focused on secure GitHub App setup for this repository.
