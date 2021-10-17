package me.superbiebel.gaudiumperms;

import me.superbiebel.gaudiumperms.treeimpl.PermissionCheckResult;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCollection;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PermissionCollectionTests {

    @Test
    void testAddPermission() {
        assertDoesNotThrow(() -> {
            PermissionCollection tree = new PermissionCollection();
            tree.addPermission("this:is:a:test", true);
        });
    }
    @Test
    void testCheckSpecificPermission() {
        PermissionCollection tree = new PermissionCollection();
        tree.addPermission("this:is:a:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:a:test"));
    }
    @Test
    void testCheckSingleWildcardPermission() {
        PermissionCollection tree = new PermissionCollection();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:some:test"));
    }
    @Test
    void testCheckSingleWildcardPermissionUndefined() {
        PermissionCollection tree = new PermissionCollection();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.UNDEFINED, tree.checkPermissionInTree("this:is:some"));
    }
    @Test
    void testCheckPermissionWithSingleEndingWildcard() {
        PermissionCollection tree = new PermissionCollection();
        tree.addPermission("this:*:*:test", true);
        tree.addPermission("this:is:a:test:you:know", false);
        assertEquals(PermissionCheckResult.UNDEFINED, tree.checkPermissionInTree("this:is:a:test"));
    }
    @Test
    void testCheckFalseOverridePermission() {
        PermissionCollection tree = new PermissionCollection();
        tree.addPermission("this:is:*:test", true);
        assertEquals(PermissionCheckResult.TRUE, tree.checkPermissionInTree("this:is:some:test"));
    }
}
