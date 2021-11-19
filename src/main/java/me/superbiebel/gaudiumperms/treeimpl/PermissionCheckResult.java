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
    public static PermissionCheckResult getFromString(String value) {
        if (value.equals(PermissionCheckResult.TRUE.toString())) {
            return PermissionCheckResult.TRUE;
        } else if (value.equals(PermissionCheckResult.FALSE.toString())) {
            return PermissionCheckResult.FALSE;
        } else if (value.equals(PermissionCheckResult.UNDEFINED.toString())) {
            return PermissionCheckResult.UNDEFINED;
        } else {
            throw new IllegalArgumentException("Could not find value");
        }
    }
}
