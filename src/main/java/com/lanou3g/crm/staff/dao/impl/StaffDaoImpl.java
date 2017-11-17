package com.lanou3g.crm.staff.dao.impl;

import com.lanou3g.crm.page.action.PageHibernateCallback;
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


    // TODO: 17/11/17
    /**
     * 按员工登录名和密码查询指定员工
     * @param staff
     * @return
     */
    @Override
    public List<Staff> findStaffByLoginNameAndLoginPwd(Staff staff){
        String hql = "from Staff T_STAFF where loginName = ? and loginPwd = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(hql, staff.getLoginName(), staff.getLoginPwd());
        return list;
    }



    @Override
    public List<Staff> queryStaff(Staff staff) {
        return getHibernateTemplate().findByExample(staff);
    }

    //按id查询员工的信息
    @Override
    public Staff staffById(String staffId) {
        Staff staff = getHibernateTemplate().get(Staff.class, staffId);
        return staff;
    }

    //按员工姓名查询员工
    @Override
    public List<Staff> findStaffsByStaffName(String staffName) {
        String sql = "from Staff T_STAFF where staffName like ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql,"%"+ staffName+ "%");
        return list;
    }


    //按职位id查询员工
    @Override
    public List<Staff> findStaffsByPostId(String postId) {
        String sql = "from Staff T_STAFF where post.postId = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, postId);
        return list;
    }

    //按部门id查询员工
    @Override
    public List<Staff> findStaffsByDepId(String depId) {
        String sql = "from Staff T_STAFF where post.department.depId = ?";
        List<Staff> list = (List<Staff>) getHibernateTemplate().find(sql, depId);
        return list;
    }


    /**
     * 获得总的数据数目 -- 带条件的
     * @return
     */
    @Override
    public int getTotalRecord() {
        String hql = "select count(c) from Staff c where 1=1";
        List<Long> find = (List<Long>) getHibernateTemplate().find(hql);
        if (find!= null){
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 获取到的数据
     * @param startIndex  开始索引
     * @param pageSize    每页显示的记录
     * @return
     */
    @Override
    public List<Staff> findAllStaffs( int startIndex, int pageSize) {
        String hql = "from Staff where 1 = 1";
        //hql是没有分页函数的,我们可以使用execute来实现
        return getHibernateTemplate().execute(
                new PageHibernateCallback<Staff>(hql,startIndex,pageSize));
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

    /**
     * 添加或更新
     * @param staff
     * @return
     */
    @Override
    public boolean saveOrUpdate(Staff staff) {
        System.out.println("******"+staff.getStaffId()+"*******");
        getHibernateTemplate().saveOrUpdate(staff);
        return true;
    }

    @Override
    public Staff findById(Staff staff) {
        return null;
    }



}
