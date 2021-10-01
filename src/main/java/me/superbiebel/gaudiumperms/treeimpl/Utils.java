package me.superbiebel.gaudiumperms.treeimpl;

import java.util.Collection;
import java.util.regex.Pattern;
import me.superbiebel.gaudiumperms.Constants;
import me.superbiebel.gaudiumperms.treeimpl.node.DoubleWildcardPermissionNode;
import me.superbiebel.gaudiumperms.treeimpl.node.PermissionNode;

public class Utils {


    private static final Pattern permissionSplitPattern = Pattern.compile(":");

    private Utils() {
    }

    public static String[] splitPermission(String permission) {
        return permissionSplitPattern.split(permission);
    }
    public static PermissionNode searchPermissionNodeInList(Collection<PermissionNode> permissionNodeList, String searchedString) {
        return permissionNodeList.stream().filter(permissionNode -> permissionNode.getName().equals(searchedString)).findAny().orElse(null);
    }
    public static boolean isWildcardNode(PermissionNode permissionNode) {
        return permissionNode.getName().equals(Constants.SINGLE_WILDCARD) || permissionNode.getName().equals(Constants.DOUBLE_WILDCARD);
    }
    public static PermissionNode createNewPermissionNode(String permission, boolean value) {
        if (permission.equals(Constants.DOUBLE_WILDCARD)) {
            return new DoubleWildcardPermissionNode(value);
        } else {
            return new PermissionNode(permission, value);
        }
    }
}
