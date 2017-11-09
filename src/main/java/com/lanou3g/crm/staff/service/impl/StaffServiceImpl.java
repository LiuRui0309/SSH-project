package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.staff.dao.StaffDao;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;


    @Override
    public void login(Staff staff) {
//        staffDao.save(staff);
    }
    @Override
    public boolean save(Staff staff) {
        return false;
    }

    @Override
    public boolean delete(Staff staff) {
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
        return null;
    }

    @Override
    public List<Staff> findAll(String condition, Object... params) {
        return null;
    }


}
