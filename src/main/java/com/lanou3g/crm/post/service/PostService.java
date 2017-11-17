package com.lanou3g.crm.post.service;

import com.lanou3g.crm.base.BaseDao;
import com.lanou3g.crm.post.domain.Post;

import java.util.List;

/**
 * Created by dllo on 17/11/13.
 */
public interface PostService extends BaseDao<Post> {

    List<Post> getPostByDepId(String depId);
}
