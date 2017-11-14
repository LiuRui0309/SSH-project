package com.lanou3g.crm.department.service.impl;

import com.lanou3g.crm.department.dao.DepartmentDao;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;


    //添加或更新
    @Override
    public boolean saveOrUpdate(Department department) {
        if (!department.getDepName().trim().equals("")){
            departmentDao.saveOrUpdate(department);
            return true;
        }
        return false;
    }

    //添加
    @Override
    public boolean save(Department department) {
        departmentDao.save(department);
        return true;
    }

    //更新
    @Override
    public boolean update(Department department) {
        departmentDao.update(department);
        return true;
    }

    //查询所有
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }


    @Override
    public boolean delete(String id) {
        return false;
    }


    @Override
    public Department findById(Department department) {
       return departmentDao.findById(department);
    }



}
