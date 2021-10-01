package me.superbiebel.gaudiumperms.treeimpl.node;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

public class PermissionNode {
    @Getter
    private final String name;
    @Getter
    private final boolean value;
    @Getter
    private final Map<String, PermissionNode> children = new HashMap<>();

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
    @Nullable
    public PermissionNode getChild(String name) {
        return children.get(name);
    }
    public boolean hasChildren() {
        return children.isEmpty();
    }
}
