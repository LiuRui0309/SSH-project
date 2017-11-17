<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    <%-- 点击高级查询, 也走查询所有的员工的 action --%>
    <script type="text/javascript">
        function condition() {
            document.getElementById("conditionFormId").submit();
        }
    </script>

    <script type="text/javascript">
        function showPage(num) {
            document.getElementById("pageNum").value = num;
            document.forms[0].submit();
        }
    </script>

    <script>
        function onDeptSelected(value) {
            //输出value的值
            console.log(value)
            //根据value的值发送请求.
            //获取二级列表的json数据
            var data = new FormData();
            data.append("depId", value);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    //对请求回来的数据进行解析
                    json = eval('(' + this.responseText + ')');
                    //获取服务器的标签
                    postSelect = document.getElementById("postSelectId");
                    //获取option标签
                    optionEle = postSelect.getElementsByTagName("option");
                    //获取option的数量
                    length = optionEle.length;
                    //使用循环清空所有的option标签
                    for (var i = 0; i < length; i++) {
                        postSelect.removeChild(optionEle[0]);
                    }
                    postSelect.innerHTML = "<option value = '-1'>--选择职位--</option>";
                    //将json数据插入到option中
                    for (var i = 0; i < json.length; i++) {
                        //创建一个option标签
                        option = document.createElement("option")
                        //设置value属性
                        option.setAttribute("value", json[i].postId);
                        //创建文本
                        text = document.createTextNode(json[i].postName)
                        //把文本信息添加到option中
                        option.appendChild(text);
                        //把option标签添加到servers的select中
                        postSelect.appendChild(option);
                    }
                }
            });
            xhr.open("POST", "http://localhost:8080/staff/getPostByDepId.action");
            xhr.send(data);
        }
    </script>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="condition()">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="/staff/staffAction_addStaffPre.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll.action"
      method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">
                <select name="depId" onchange="onDeptSelected(this.value)">
                    <option value="-1">--请选择部门--</option>
                    <s:iterator value="departments" var="deptm">
                        <s:iterator value="staffs" var="staff">
                            <s:if test="#deptm.depId==staff.post.department.depId">
                                <option value="${deptm.depId}"
                                        selected="selected">${staff.post.department.depName}</option>
                            </s:if>
                        </s:iterator>
                        <option value="${deptm.depId}">${deptm.depName}</option>
                    </s:iterator>
                </select></td>
            <td width="80px">职务：</td>
            <td width="200px">
                <select name="postId" id="postSelectId">
                    <option value="">--请选择职务--</option>
                </select>
            </td>

            <td width="80px">姓名：</td>
            <td width="200px">
                <input type="text" name="staffName" value="" size="12"/>
            </td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <s:iterator value="staffs">
        <tr class="table">
            <td align="center"><s:property value="staffName"/></td>
            <td align="center"><s:property value="gender"/></td>
            <td align="center"><s:property value="onDutyDate"/></td>
            <td align="center"><s:property value="post.department.depName"/></td>
            <td align="center"><s:property value="post.postName"/></td>
            <td width="7%" align="center">
                    <%--编辑--%>
                <s:a namespace="/staff" action="staffAction_editStaffPre">
                    <s:param name="staffId" value="staffId"/>
                    <s:param name="postId" value="post.postId"/>
                    <s:param name="depId" value="post.department.depId"/>
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
                </s:a>
            </td>
        </tr>
    </s:iterator>


</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            第<s:property value="%{#pageBean.pageNum}"/>页/共<s:property
                value="#pageBean.totalPage"/>页</span>
            <s:a action="staffAction_findAllStaffs">
                首页
                <s:param name="pageNum" value="'1'"/>
            </s:a>
            <s:if test="%{#pageBean.pageNum > 1}">
                <s:a action="staffAction_findAllStaffs">
                    上一页
                    <s:param name="pageNum" value="%{#pageBean.pageNum - 1}"/>
                </s:a>
            </s:if>
            <s:iterator var="i" begin="%{#pageBean.start}" end="%{#pageBean.end}">
                <s:if test="%{#i eq #pageBean.pageNum}">
                    <font color="red">
                        <s:property value="%{#i}"/>
                    </font>
                </s:if>
                <s:else>
                    <s:a action="staffAction_findAllStaffs">
                        [<s:property value="%{#i}"/>]
                        <s:param name="pageNum" value="%{#i}"/>
                    </s:a>
                </s:else>
            </s:iterator>
            <s:if test="%{#pageBean.pageNum < #pageBean.totalPage}">
                <s:a action="staffAction_findAllStaffs">
                    <s:param name="pageNum" value="%{#pageBean.pageNum + 1}"/>
                    下一页
                </s:a>
            </s:if>
            <s:a action="staffAction_findAllStaffs">
                <s:param name="pageNum" value="%{#pageBean.totalPage}"/>
                尾页
            </s:a>
        </td>
    </tr>
</table>

</body>
</html>
