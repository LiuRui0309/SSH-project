package com.lanou3g.crm.post.dao;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostDao extends BaseDao<Post> {
    List<Post> getPostByDepId(String depId);
}
