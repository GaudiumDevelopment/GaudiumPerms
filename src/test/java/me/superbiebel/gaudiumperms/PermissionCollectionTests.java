package me.superbiebel.gaudiumperms;

import javax.json.JsonArray;
import javax.json.JsonObject;
import me.superbiebel.gaudiumperms.permissionevaluator.PermissionEvaluatorA;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCheckResult;
import me.superbiebel.gaudiumperms.treeimpl.PermissionCollection;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;


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
    @ParameterizedTest
    @JsonFileSource(resources = "/permissionChecks.json")
    void testCheckPermissions(JsonObject jsonObject) {
        PermissionCollection tree = new PermissionCollection();

        JsonArray permissionsToBeAdded = jsonObject.getJsonArray("permissionsToBeAdded");
        for (int i = 0; i < permissionsToBeAdded.size();i++) {
            JsonObject permissionAddJsonObject = permissionsToBeAdded.getJsonObject(i);
            tree.addPermission(permissionAddJsonObject.getString("permission"), permissionAddJsonObject.getBoolean("value"));
        }

        JsonArray permissionsToBeChecked = jsonObject.getJsonArray("permissionsToBeChecked");
        for (int i = 0; i < permissionsToBeChecked.size();i++) {
            JsonObject permissionCheckJsonObject = permissionsToBeChecked.getJsonObject(i);
            assertEquals(PermissionCheckResult.getFromString(permissionCheckJsonObject.getString("value")), PermissionEvaluatorA.checkForPermission(permissionCheckJsonObject.getString("permission"), tree));
        }
    }
}
