package me.superbiebel.gaudiumperms;

import me.superbiebel.gaudiumperms.treeimpl.PermissionTree;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PermissionTreeTests {

    @Test
    void testAddPermission() {
        assertDoesNotThrow(() -> {
            PermissionTree tree = new PermissionTree();
            tree.addPermission("this.is.a.test", true);
        });
    }
}
