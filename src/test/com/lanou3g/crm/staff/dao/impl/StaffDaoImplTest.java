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

/**
 * Created by dllo on 17/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-config.xml")
public class StaffDaoImplTest {
    @Resource
    private StaffDao staffDao;

    @Test
    public void save() {
        Post post = new Post();
        Department department = new Department();
        post.setPostName("总监");
        department.setDepName("教研部");
        Staff staff = new Staff();
        staff.setStaffName("老孟");
        staff.setLoginName("lm");
        staff.setLoginPwd("1");
        staff.setPost(post);
        post.setDepartment(department);
        staffDao.save(staff);
    }

    @Test
    public void findAll() {
        staffDao.findAll();
    }
}