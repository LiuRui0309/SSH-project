package com.lanou3g.crm.post.domain;

import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.staff.domain.Staff;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Post {
    private int postId;
    private String postName;

    private Department department;

    private Set<Staff> staffs = new HashSet<>();

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
