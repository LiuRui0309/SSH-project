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

    @Override
    public boolean save(Staff staff) {
        getHibernateTemplate().save(staff);
        return true;
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
    public Staff findById(Serializable id) {
        return null;
    }

    @Override
    public List<Staff> findAll() {
        List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff T_STAFF");
        return staffs;
    }


    @Override
    public Staff findById(Staff staff) {
        return null;
    }

    @Override
    public List<Staff> queryStaff(Staff staff) {
        return getHibernateTemplate().findByExample(staff);
    }
}
