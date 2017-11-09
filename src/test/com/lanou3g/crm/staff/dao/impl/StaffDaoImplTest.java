package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.post.domain.Post;
import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class StaffDaoImplTest {
    @Resource
    private StaffDao staffDao;

    @Test
    public void save(){
        Post post = new Post();
        Department department = new Department();
        post.setPostName("讲师");
        department.setDepName("教研部");
        Staff staff = new Staff();
        staff.setStaffName("张威");
        staff.setLoginName("zw");
        staff.setLoginPwd("123");
        staff.setPost(post);
        post.setDepartment(department);
        staffDao.save(staff);
    }
}