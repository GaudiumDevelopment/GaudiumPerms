package me.superbiebel.gaudiumperms.treeimpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class PermissionNode {
    @Getter
    private final String name;
    @Getter
    private final boolean value;
    @Getter
    private final HashMap<String, PermissionNode> children = new HashMap<>();

    public PermissionNode(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public void addChild(PermissionNode child) {
        children.put(child.getName(),child);
    }
    public boolean removeChild(PermissionNode child) {
        return children.remove(child.getName()) != null;
    }
    public boolean hasChildren() {
        return children.isEmpty();
    }
}
