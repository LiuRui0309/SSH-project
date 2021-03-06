<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
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
            xhr.open("POST", "/staff/getPostByDepId.action");
            xhr.send(data);
        }
    </script>


</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="/staff/staffAction_edit.action" method="post">

    <input type="hidden" name="staffId" value="${staff1.staffId}"/>

    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>登录名：</td>
            <td><input type="text" name="loginName" value="${staff1.loginName}"/></td>
            <td>密码：</td>
            <td><input type="password" name="loginPwd" value="${staff1.loginPwd}"/></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="${staff1.staffName}"/></td>
            <td>性别：</td>
            <td>
                <%--<input type="radio" name="gender" checked="checked" value="男"/>男--%>
                <%--<input type="radio" name="gender" value="女"/>女--%>

                <c:if test="${staff1.gender=='男'}">
                    <input type="radio" name="gender" checked="checked" value="男"/>男
                    <input type="radio" name="gender" value="女"/>女
                </c:if>

                <c:if test="${staff1.gender=='女'}">
                    <input type="radio" name="gender" value="男"/>男
                    <input type="radio" name="gender" checked="checked" value="女"/>女
                </c:if>
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select name="depId" onchange="onDeptSelected(this.value)">
                    <%--<option value="">--请选择部门--</option>--%>
                    <s:iterator value="departments" var="dept">
                        <s:if test="#dept.depId==staff1.post.department.depId">
                            <option value="${dept.depId}" selected="selected">${staff1.post.department.depName}</option>
                        </s:if>
                        <s:else>
                            <option value="${dept.depId}">${dept.depName}</option>
                        </s:else>
                    </s:iterator>
                </select></td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select name="postId" id="postSelectId">
                    <option value="${postId}">${staff1.post.postName}</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="${staff1.onDutyDate}" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
    </table>
</form>

</body>
</html>
