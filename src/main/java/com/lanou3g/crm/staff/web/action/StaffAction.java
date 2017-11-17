package com.lanou3g.crm.staff.web.action;

import com.lanou3g.crm.base.BaseAction;
import com.lanou3g.crm.department.domain.Department;
import com.lanou3g.crm.department.service.DepartmentService;
import com.lanou3g.crm.page.domain.PageBean;
import com.lanou3g.crm.post.domain.Post;
import com.lanou3g.crm.post.service.PostService;
import com.lanou3g.crm.staff.domain.Staff;
import com.lanou3g.crm.staff.service.StaffService;
import com.lanou3g.crm.staff.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff, StaffService> {

    @Resource
    private StaffService staffService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PostService postService;

    private String depId;

    private Staff staff = getModel();

    private List<Staff> staffs;

    private List<Department> departments;

    private List<Post> posts;

    private String postId;

    private Staff staff1;


    //分页 pageNum, pageSize 并设置默认值
    private int pageNum = 1;

    public void setPageNum(int pageNum
    ) {
        this.pageNum = pageNum;
    }
    private int pageSize = 3;

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //分页
    //查询所有
    @SkipValidation
    public String findAll(){
        //分页
        PageBean<Staff> pageBean = staffService.findAllStaffs(staff,pageNum,pageSize);
        //将查询结果放到值栈中 jsp页面要通过#key方式获取到
        ActionContext.getContext().put("pageBean",pageBean);
        return "findAll";
    }


    public String login() {
        staff1 = staffService.findStaffByLoginNameAndLoginPwd(staff);
        if (staff1 != null) {
            sessionPut("login", staff1);
            return SUCCESS;
        }
        addFieldError("msg", "用户不存在");
        return INPUT;
    }

    //添加员工
    @SkipValidation
    public String addStaff() {
        System.out.println(postId);
        staff.setPost(new Post(postId));
//        if (true) {
        staffService.save(staff);
        return SUCCESS;
//        }
//        addFieldError("msg", "用户存在,更换用户名");
//        return INPUT;
    }

    /**
     * 查询全部员工
     *
     * @return
     */
    @SkipValidation
    public String findAllStaffs() {
        //高级查询显示部门列表
        departments = departmentService.findAll();



        //分页
        PageBean<Staff> pageBean = staffService.findAllStaffs(staff,pageNum,pageSize);
        //将查询结果放到值栈中 jsp页面要通过#key方式获取到
        ActionContext.getContext().put("pageBean",pageBean);





        //显示员工的列表
        //查询时提供的参数  depId postId staffName
        //当员工姓名存在时按姓名查询指定员工

        if (!StringUtils.isBlank(getModel().getStaffName())) {
            staffs = staffService.findStaffsByStaffName(getModel().getStaffName());
            //员工姓名不存在职位id存在
        } else if (!StringUtils.isBlank(postId) && !postId.equals("-1")) {
            staffs = staffService.findStaffsByPostId(postId);
            //员工姓名和职位id都不存在 部门id存在
        } else if (!StringUtils.isBlank(depId) && !depId.equals("-1")) {
            postId = null;
            staffs = staffService.findStaffsByDepId(depId);
        } else {
            depId = null;
            postId = null;
            //无条件查询所有
            staffs = staffService.findAll();
        }
        return SUCCESS;
    }

    //添加员工先查询部门
    @SkipValidation
    public String addStaffPre() {
        //添加员工显示部门列表
        departments = departmentService.findAll();
        return SUCCESS;
    }


    //根据部门Id查询对应的职位
    @SkipValidation
    public String getPostByDepId() {

        departments = departmentService.findAll();

        posts = postService.getPostByDepId(depId);

        return "success";
    }

    //员工编辑之前按员工id查询所有信息
    @SkipValidation
    public String editStaffPre() {
        departments = departmentService.findAll();
        staff1 = staffService.staffById(getModel().getStaffId());
        return "success";
    }

    @SkipValidation
    public String editStaff() {
        Staff staff = getModel();
        staff.setPost(new Post(postId));
        staffService.saveOrUpdate(staff);
        return "success";
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Staff getStaff() {
        return staff;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Staff getStaff1() {
        return staff1;
    }

    public void setStaff1(Staff staff1) {
        this.staff1 = staff1;
    }
}
