package com.lanou3g.crm.department.dao.impl;

import com.lanou3g.crm.department.dao.DepartmentDao;
import com.lanou3g.crm.department.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    /**
     * 添加或更新
     * @param department
     * @return
     */
    @Override
    public boolean saveOrUpdate(Department department) {
        getHibernateTemplate().saveOrUpdate(department);
        return true;
    }

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findAll() {
        List<Department> departments = (List<Department>)
                getHibernateTemplate().find("from Department T_DEP");
        return departments;
    }

    //通过id查询
    @Override
    public Department findById(Department department) {
        Department department1 = getHibernateTemplate().
                get(Department.class, department.getDepId());
        return department1;
    }

    @Override
    public boolean save(Department department) {
        return true;
    }

    @Override
    public boolean update(Department department) {
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


}
