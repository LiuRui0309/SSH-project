package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {
    /**
     * 添加员工
     * @param staff
     * @return
     */
    @Override
    public boolean save(Staff staff) {
        getHibernateTemplate().save(staff);
        return true;
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return (List<Staff>) getHibernateTemplate().find("from Staff T_STAFF");
    }

    /**
     * 按员工的属性查询所有满足条件的所有员工
     * @param staff
     * @return
     */
    @Override
    public List<Staff> queryStaff(Staff staff) {
        return getHibernateTemplate().findByExample(staff);
    }





    @Override
    public boolean delete(String staffId) {
        getHibernateTemplate().delete(staffId);
        return false;
    }

    @Override
    public boolean update(Staff staff) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Staff staff) {
        return false;
    }

    @Override
    public Staff findById(Staff staff) {
        return null;
    }



}
