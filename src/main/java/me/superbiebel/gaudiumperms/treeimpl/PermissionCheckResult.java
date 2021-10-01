package me.superbiebel.gaudiumperms.treeimpl;

public enum PermissionCheckResult {
    TRUE, FALSE, UNDEFINED;

    PermissionCheckResult() {
    }
    public static PermissionCheckResult getFromBoolean(boolean value) {
        if (value) {
            return PermissionCheckResult.TRUE;
        } else {
            return PermissionCheckResult.FALSE;
        }
    }
}
