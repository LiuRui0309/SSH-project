package com.lanou3g.crm.department.domain;

import com.lanou3g.crm.post.domain.Post;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/9.
 */
public class Department
{
    private String depId;
    private String depName;

    private Set<Post> posts = new HashSet<>();

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
