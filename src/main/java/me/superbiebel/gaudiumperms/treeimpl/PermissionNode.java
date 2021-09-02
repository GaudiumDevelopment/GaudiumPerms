package me.superbiebel.gaudiumperms.treeimpl;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class PermissionNode {
    @Getter
    private final String name;
    @Getter
    private final boolean value;
    @Getter
    private final Set<PermissionNode> children = new HashSet<>();

    public PermissionNode(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public void addChild(PermissionNode child) {
        children.add(child);
    }
    public boolean removeChild(PermissionNode child) {
        return children.remove(child);
    }
    public boolean hasChildren() {
        return children.isEmpty();
    }
}
