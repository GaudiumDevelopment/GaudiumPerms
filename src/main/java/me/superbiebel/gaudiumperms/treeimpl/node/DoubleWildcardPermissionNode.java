package me.superbiebel.gaudiumperms.treeimpl.node;

import me.superbiebel.gaudiumperms.Constants;

public class DoubleWildcardPermissionNode extends PermissionNode {
    public DoubleWildcardPermissionNode( boolean value) {
        super(Constants.DOUBLE_WILDCARD, value);
    }

    @Override
    public void addChild(PermissionNode child) {
        throw new UnsupportedOperationException("Cannot add child to double wildcard");
    }

    @Override
    public boolean removeChild(PermissionNode child) {
        throw new UnsupportedOperationException("Cannot remove child to double wildcard");
    }

    @Override
    public boolean hasChildren() {
        return false;
    }
}
