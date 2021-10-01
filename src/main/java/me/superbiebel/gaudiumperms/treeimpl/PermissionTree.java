package me.superbiebel.gaudiumperms.treeimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import me.superbiebel.gaudiumperms.Constants;
import me.superbiebel.gaudiumperms.treeimpl.node.PermissionNode;

public class PermissionTree {

    HashMap<String, PermissionNode> rootNodes = new HashMap<>();

    public void addPermission(String permission, boolean value) {
        List<String> stringPermissionNodes = new ArrayList<>(Arrays.asList(Utils.splitPermission(permission)));
        stringPermissionNodes.add(Constants.DOUBLE_WILDCARD); // add the ending double wildcard, must always be a leaf node
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
    public PermissionCheckResult checkPermissionInTree(String permission) {
        List<String> stringPermissionNodes = Arrays.asList(Utils.splitPermission(permission));
        PermissionNode rootnode = rootNodes.get(stringPermissionNodes.get(0));
        if (rootnode == null) {
            return PermissionCheckResult.UNDEFINED;
        }
        if (stringPermissionNodes.size() == 1) {
            return PermissionCheckResult.getFromBoolean(rootnode.isValue());
        }






        throw new UnsupportedOperationException("not implemented yet"); //TODO: remove exception when this method has finished development
    }
}