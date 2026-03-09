<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/7/2026
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ve-dat/sua" method="post">
    <input type="number" name="id" value="${vd.id}" readonly >
    <br>
    <label>Người đặt</label>
    <input type="text" name="nguoiDat" value="${vd.nguoiDat}" required>
    <br>
    <label>Số lượng vé</label>
    <input type="number" name="soLuongVe" value="${vd.soLuongVe}" required>
    <br>
    <label>Ngày chiếu</label>
    <input type="date" name="ngayChieu" value="${vd.ngayChieu}" required>
    <br>
    <label>Đã thanh toán</label>
    <input type="radio" name="daThanhToan" value="false"    ${vd.daThanhToan == false ? "checked" : ""} required>No
    <input type="radio" name="daThanhToan" value="true"     ${vd.daThanhToan == true ? "checked" : ""}  >Yes
    <br>
    <label>Tên phim</label>
    <select name="idPhim">
        <c:forEach items="${listPhim}" var="p">
                <option value="${p.id}" label="${p.tenPhim}" ${vd.phim.id == p.id ? "selected" : ""}></option>
        </c:forEach>
    </select>
    <br>
    <button>Sua</button>
</form>
</body>
</html>
