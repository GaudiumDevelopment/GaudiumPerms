# explanation of the PermissionTree
## rules
1. Every branch must end in a wildcard. (the system will add this implicitly), so this:is:a:test becomes this:is:a:test:*, this has to do with the tree otherwise not being able to store these implicit wildcards.
2. more specific permissions will override more generic permissions. (non wildcards override wildcards)
3. temporary permissions will override permanent permissions.