# explanation of the PermissionTree
## rules
1. Every branch must end in a wildcard. (the system will add this implicitly), so this:is:a:test becomes this:is:a:test:**, this has to do with the tree otherwise not being able to store these implicit wildcards.
2. More specific permissions will override more generic permissions. (non wildcards override wildcards)
3. Temporary permissions will override permanent permissions.
4. Permissions with less wildcards always override permissions with more wildcards.
5. Double wildcard ("**") cannot have any children ever. It is ALWAYS a leaf node.