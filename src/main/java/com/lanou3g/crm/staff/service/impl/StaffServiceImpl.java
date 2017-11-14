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
public class StaffServiceImpl implements StaffService {

    private StaffDao staffDao;

    /**
     * 判断登录
     * 当输入的登录信息存在 可以登录
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        List<Staff> staffs = staffDao.queryStaff(staff);
        if (staffs.size()!=0){
            return staff;
        }else {
            return null;
        }
    }

    /**
     * 用来接收dao层的查询结果
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    /**
     * 添加员工 判断添加的员工是否存在
     * 若存在 则添加失败
     * @param staff
     * @return
     */
    @Override
    public boolean save(Staff staff) {
        List<Staff> staffs = staffDao.queryStaff(staff);
        if (staffs.size()!=0){
            return false;
        }else {
            staffDao.save(staff);
            return true;
        }
    }

    @Override
    public boolean delete(String staffId) {
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


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
