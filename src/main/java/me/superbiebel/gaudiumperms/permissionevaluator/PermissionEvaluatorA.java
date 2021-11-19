package me.superbiebel.gaudiumperms.permissionevaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.superbiebel.gaudiumperms.Constants;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCheckResult;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCollection;
import me.superbiebel.gaudiumperms.treeimpl.Utils;
import me.superbiebel.gaudiumperms.treeimpl.node.PermissionNode;

public class PermissionEvaluatorA implements IPermissionEvaluator {

    private PermissionEvaluatorA() {
    }

    public static PermissionCheckResult checkForPermission(String permission, PermissionCollection permissionTree) {
        List<String> stringPermissionNodes = new ArrayList<>();
        Collections.addAll(stringPermissionNodes, Utils.splitPermission(permission));
        int doubleWildcardCount = Utils.checkDoubleWildcardCount(stringPermissionNodes);
        if (doubleWildcardCount > 1 ) {
            throw new IllegalArgumentException("Too many double wildcards for permission check");
        } else if (stringPermissionNodes.get(stringPermissionNodes.size() - 1).equals(Constants.DOUBLE_WILDCARD)) {
            stringPermissionNodes.remove(stringPermissionNodes.size() - 1);
        }

        PermissionNode rootnode = permissionTree.getRootNodes().get(stringPermissionNodes.get(0));
        if (rootnode == null) { //if there are no permissions in the tree
            return PermissionCheckResult.UNDEFINED;
        }
        if (stringPermissionNodes.size() == 1) {//if only the root permissions are available
            return PermissionCheckResult.getFromBoolean(rootnode.isValue());
        }
        PermissionNode currentNode = rootnode;
        for (int i = 1; i <= stringPermissionNodes.size(); i++) {
            PermissionNode foundnode;
            if (i == stringPermissionNodes.size()) {
                if ((foundnode = currentNode.getChild(Constants.DOUBLE_WILDCARD)) != null) {
                    return PermissionCheckResult.getFromBoolean(foundnode.isValue());
                } else {
                    return PermissionCheckResult.UNDEFINED;
                }
            }
            if (currentNode.hasChildren()) {
                if ( (foundnode = currentNode.getChild(stringPermissionNodes.get(i))) != null) {
                    currentNode = foundnode;
                } else if ((foundnode = currentNode.getChild(Constants.SINGLE_WILDCARD)) != null) {
                    currentNode = foundnode;
                } else if ((foundnode = currentNode.getChild(Constants.DOUBLE_WILDCARD)) != null) {
                    return PermissionCheckResult.getFromBoolean(foundnode.isValue());
                } else {
                    return PermissionCheckResult.UNDEFINED;
                }
            } else {
                throw new IllegalStateException("Could not find a double wildcard as leaf, because the last node didn't have any children");
            }
        }
        throw new IllegalStateException("went out of loop");
    }
}
