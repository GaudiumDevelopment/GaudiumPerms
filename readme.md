# explanation of the PermissionTree

## General rules to construct the permission tree
1. Every branch must end in a double wildcard. (the system will add this implicitly), so this:is: a:test becomes this:is: a:test:**, this has to do with the tree otherwise not being able to store these implicit wildcards.

## rules of permissionevaluator A
1. More specific permissions will override more generic permissions. (non wildcards override wildcards)
2. Temporary permissions will override permanent permissions.
3. Permissions with less wildcards always override permissions with more wildcards.
4. Double wildcard ("**") cannot have any children ever. It is ALWAYS a leaf node.
