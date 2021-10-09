package me.superbiebel.gaudiumperms;

import me.superbiebel.gaudiumperms.treeimpl.PermissionCheckResult;
import me.superbiebel.gaudiumperms.treeimpl.PermissionTree;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermissionTreeTests {

    @Test
    void testAddPermission() {
        assertDoesNotThrow(() -> {
            PermissionTree tree = new PermissionTree();
            tree.addPermission("this:is:a:test", true);
        });
    }
    @Test
    void testCheckSpecificPermission() {
        PermissionTree tree = new PermissionTree();
        tree.addPermission("this:is:a:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:a:test"));
    }
    @Test
    void testCheckSingleWildcardPermission() {
        PermissionTree tree = new PermissionTree();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:some:test"));
    }
    @Test
    void testCheckSingleWildcardPermissionUndefined() {
        PermissionTree tree = new PermissionTree();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.UNDEFINED, tree.checkPermissionInTree("this:is:some"));
    }
    @Test
    void testCheckPermissionWithSingleEndingWildcard() {
        PermissionTree tree = new PermissionTree();
        tree.addPermission("this:*:*:test", true);
        tree.addPermission("this:is:a:test:you:know", false);
        assertEquals(PermissionCheckResult.UNDEFINED, tree.checkPermissionInTree("this:is:a:test"));
    }
    @Test
    void testCheckFalseOverridePermission() {
        PermissionTree tree = new PermissionTree();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:some:test"));
    }
}
