package me.superbiebel.gaudiumperms.permissionevaluator;

import me.superbiebel.gaudiumperms.treeimpl.PermissionCheckResult;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCollection;

public interface IPermissionEvaluator {

    static PermissionCheckResult checkForPermission(String permission, PermissionCollection permissionTree) {
        throw new UnsupportedOperationException("Did not implement method");
    }
}
