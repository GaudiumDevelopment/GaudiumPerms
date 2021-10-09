package me.superbiebel.gaudiumperms.treeimpl;

import lombok.Getter;
import me.superbiebel.gaudiumperms.treeimpl.node.PermissionNode;

public class PermissionNodeLocation {
    @Getter
    private final PermissionNode permissionNode;
    @Getter
    private final int indexFromStringPermission;

    public PermissionNodeLocation(PermissionNode permissionNode, int indexFromStringPermission) {
        this.permissionNode = permissionNode;
        this.indexFromStringPermission = indexFromStringPermission;
    }
}
