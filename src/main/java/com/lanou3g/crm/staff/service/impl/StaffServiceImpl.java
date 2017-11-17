package com.lanou3g.crm.staff.service.impl;

import com.lanou3g.crm.page.domain.PageBean;
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
     *
     * @param staff
     * @return
     */
    @Override
    public Staff login(Staff staff) {
        List<Staff> staffs = staffDao.queryStaff(staff);
        if (staffs.size() != 0) {
            return staff;
        } else {
            return null;
        }
    }

    //查询员工的所有信息
    @Override
    public Staff staffById(String staffId) {
        return staffDao.staffById(staffId);
    }


    //按员工的姓名查询员工
    @Override
    public List<Staff> findStaffsByStaffName(String staffName) {
       return staffDao.findStaffsByStaffName(staffName);
    }

    //按职位id查询员工
    @Override
    public List<Staff> findStaffsByPostId(String postId) {
        return staffDao.findStaffsByPostId(postId);
    }

    //按部门id查询员工
    @Override
    public List<Staff> findStaffsByDepId(String depId) {
        return staffDao.findStaffsByDepId(depId);
    }

    /**
     * 分页查询
     * @param staff
     * @param pageNum  当前页
     * @param pageSize 每页显示的条目数
     * @return
     */
    @Override
    public PageBean<Staff> findAllStaffs(Staff staff, int pageNum, int pageSize) {
        //分页
        //获取总记录数
        int totalRecord = staffDao.getTotalRecord();
        //创建对象
        PageBean<Staff> pageBean = new PageBean<Staff>(pageNum,pageSize,totalRecord);
        //分页数据
        List<Staff> data = staffDao.findAllStaffs(pageBean.getStartIndex(),pageBean.getPageSize());
        //将获取到的分页数据封装到PageBean中
        pageBean.setData(data);
        return pageBean;
    }

    // TODO: 17/11/17
    @Override
    public Staff findStaffByLoginNameAndLoginPwd(Staff staff) {
        List<Staff> staffs = staffDao.findStaffByLoginNameAndLoginPwd(staff);
        for (Staff staff1 : staffs) {
            if (staff1.getLoginName().equals(staff.getLoginName())&&staff1.getLoginPwd().equals(staff.getLoginPwd())){
                return staff1;
            }
        }
        return null;
    }

    /**
     * 用来接收dao层的查询结果
     *
     * @return
     */
    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    /**
     * 添加员工 判断添加的员工是否存在
     * 若存在 则添加失败
     *
     * @param staff
     * @return
     */
    @Override
    public boolean save(Staff staff) {
        staffDao.saveOrUpdate(staff);
        return true;
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
        staffDao.saveOrUpdate(staff);
        return true;
    }

    @Override
    public Staff findById(Staff staff) {
        return null;
    }


    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
