package me.superbiebel.gaudiumperms.treeimpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class PermissionTree {

    public static final Pattern permissionSplitPattern = Pattern.compile(":");

    Set<PermissionNode> rootNodes = new HashSet<>();

    public void addPermission(String permission, boolean value) {
        List<String> stringPermissionNodes = Arrays.asList(permissionSplitPattern.split(permission));
        stringPermissionNodes.add("*");
        PermissionNode rootnode = rootNodes.stream().filter(permissionNode -> permissionNode.getName().equals(stringPermissionNodes.get(0))).findAny().orElse(null);
        if (rootnode == null) {
            rootnode = new PermissionNode(stringPermissionNodes.get(0), value);
            rootNodes.add(rootnode);
        }
        PermissionNode currentNode = rootnode; //the current node is the node that is currently being checked and if necessary to be added some new nodes
        for (int i = 1; i < stringPermissionNodes.size(); i++) {
            PermissionNode foundNode = currentNode.getChildren().stream().filter(permissionNode -> permissionNode.getName().equals(stringPermissionNodes.get(0))).findAny().orElse(null);
            if (foundNode == null) {
                foundNode = new PermissionNode(stringPermissionNodes.get(i+1),value);
                currentNode.addChild(foundNode);
            }
            currentNode = foundNode;
        }
    }
    public PermissionCheckResult checkPermission(String permission) {
        List<String> stringPermissionNodes = Arrays.asList(permissionSplitPattern.split(permission));
        PermissionNode rootnode = rootNodes.stream().filter(permissionNode -> permissionNode.getName().equals(stringPermissionNodes.get(0))).findAny().orElse(null);
        if (rootnode != null) {
            if (stringPermissionNodes.size() == 1) {
                return PermissionCheckResult.FALSE;
            }
        }
    }
}
