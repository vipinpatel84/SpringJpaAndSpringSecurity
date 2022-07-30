package com.springdata.jpa.roles;

public enum JpaApplicationRolePermission {

    STUDENT_READ("STUDENT:READ"),
    STUDENT_WRITE("STUDENT:WRITE"),
    COURSE_READ("COURSE:READ"),
    COURSE_WRITE("COURSE:WRITE");

    private final String permission;

    JpaApplicationRolePermission(String permission) {
        this.permission = permission;
    }
}
