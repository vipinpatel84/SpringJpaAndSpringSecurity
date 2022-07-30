package com.springdata.jpa.roles;

import com.google.*;
import com.google.common.collect.Sets;

import java.util.Set;

import static com.springdata.jpa.roles.JpaApplicationRolePermission.*;

/**
 * Application Roles defined using Enums
 */
public enum JpaApplicationRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_WRITE,COURSE_READ)),
    ADMINTRAINEE(Sets.newHashSet(STUDENT_READ,COURSE_READ));
    private final Set<JpaApplicationRolePermission> permissionSet;

    JpaApplicationRoles(Set<JpaApplicationRolePermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<JpaApplicationRolePermission> getPermissionSet() {
        return permissionSet;
    }
}
