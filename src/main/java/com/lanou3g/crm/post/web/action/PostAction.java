package com.lanou3g.crm.post.web.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import com.lanou3g.crm.post.domain.Post;
import com.lanou3g.crm.post.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 17/11/13.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post, PostService> {

    @Resource
    private PostService postService;

    @Resource
    private DepartmentService departmentService;

    private List<Department> departments;

    private List<Post> posts;


    //查询全部职位
    public String findAllPost() {
        posts = postService.findAll();
        return SUCCESS;
    }

    //添加或者更新
    public String addOrEditPost() {
        postService.saveOrUpdate(getModel());
        return SUCCESS;
    }

    //添加更新之前
    public String addOrEditPostPre() {
        departments = departmentService.findAll();
        if (getModel().getPostId()==null||getModel().getDepartment().getDepId()==null) {
            return SUCCESS;
        } else {
            Post post = postService.findById(getModel());
            applicationPut("postId", post.getPostId());
            applicationPut("postName", post.getPostName());
            return SUCCESS;
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<Post> getPosts() {
        return posts;
    }
}