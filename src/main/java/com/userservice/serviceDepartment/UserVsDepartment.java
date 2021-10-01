package com.userservice.serviceDepartment;

import com.userservice.entity.User;

public class UserVsDepartment {
    private User user;
    private Department department;

    public UserVsDepartment() {
    }

    public UserVsDepartment(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
