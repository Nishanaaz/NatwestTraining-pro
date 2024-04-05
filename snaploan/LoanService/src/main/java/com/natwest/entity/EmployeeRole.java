package com.natwest.entity;

public enum EmployeeRole {
    SALES_MANAGER("Sales Manager"),
    MANAGER("Manager"),
    BRANCH_MANAGER("Branch Manager");

    private final String roleName;

    EmployeeRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
