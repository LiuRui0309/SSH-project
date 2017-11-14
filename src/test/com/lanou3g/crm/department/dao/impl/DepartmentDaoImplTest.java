package com.lanou3g.crm.department.dao.impl;

import com.lanou3g.crm.department.dao.DepartmentDao;
import com.lanou3g.crm.department.domain.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*.xml")
public class DepartmentDaoImplTest {

    @Resource
    private DepartmentDao departmentDao;

    @Test
    public void test() {
        Department department = new Department();
        department.setDepName("职规");
        departmentDao.save(department);
    }

    @Test
    public void testFindAll() {
        List<Department> departments = departmentDao.findAll();
        System.out.println(departments);
    }

    @Test
    public void saveOrUpdateTest() {
        Department department = new Department();
        department.setDepName("职规");
        departmentDao.saveOrUpdate(department);
    }

    @Test
    public void findByIdTest() {
        Department department = new Department();
        department.setDepId("2c9090fc5fb2dd06015fb2dd0ab10000");
        Department byId = departmentDao.findById(department);
        System.out.println(byId);
    }
}