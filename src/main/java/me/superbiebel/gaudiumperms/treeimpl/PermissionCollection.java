package me.superbiebel.gaudiumperms.treeimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lombok.Getter;
import me.superbiebel.gaudiumperms.Constants;
import me.superbiebel.gaudiumperms.treeimpl.node.PermissionNode;

public class PermissionCollection {

    @Getter
    HashMap<String, PermissionNode> rootNodes = new HashMap<>();

    public synchronized void addPermission(String permission, boolean value) {
        List<String> stringPermissionNodes = new ArrayList<>(Arrays.asList(Utils.splitPermission(permission)));

        int doubleWildcardCount = Utils.checkDoubleWildcardCount(stringPermissionNodes);
        if (doubleWildcardCount > 1) {
            throw new IllegalArgumentException("invalid permission: multiple double wildcards");
        } else if (doubleWildcardCount == 0) {
            stringPermissionNodes.add(Constants.DOUBLE_WILDCARD); // add the ending double wildcard, must always be a leaf node
        }

        PermissionNode rootnode = rootNodes.get(stringPermissionNodes.get(0));

        if (rootnode == null) { //create rootnode if it doesn't exist
            rootnode = Utils.createNewPermissionNode(stringPermissionNodes.get(0), value);
            rootNodes.put(rootnode.getName(), rootnode);
        }

        PermissionNode currentNode = rootnode; //the current node is the node that is currently being checked and if necessary to be added some new nodes
        for (int i = 1; i < stringPermissionNodes.size(); i++) {
            PermissionNode foundNode = currentNode.getChild(stringPermissionNodes.get(i)); //get the node with the name that is currently being added, returns null if not found.
            if (foundNode == null) {
                foundNode = Utils.createNewPermissionNode(stringPermissionNodes.get(i), value);
                currentNode.addChild(foundNode);
            }
            currentNode = foundNode;
        }
    }
    public void addAllPermissions(String[] permissions, boolean[] values) {
        if (permissions.length != values.length) throw new IllegalArgumentException("Amount of values between the two collections is not equal!");
        for (int i = 0; i < permissions.length; i++) {
            addPermission(permissions[i], values[i]);
        }
    }
    public void addAllPermissions(List<String> permissions, List<Boolean> values) {
        for (int i = 0; i < permissions.size(); i++) {
            addPermission(permissions.get(i), values.get(i));
        }
    }
}