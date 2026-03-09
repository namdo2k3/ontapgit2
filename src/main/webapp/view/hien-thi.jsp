<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 3/7/2026
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>dddddddd</h1>
<form action="/ve-dat/them" method="post">
    <label>Người đặt</label>
    <input type="text" name="nguoiDat" required>
    <br>
    <label>Số lượng vé</label>
    <input type="number" name="soLuongVe" required>
    <br>
    <label>Ngày chiếu</label>
    <input type="date" name="ngayChieu" required>
    <br>
    <label>Đã thanh toán</label>
    <input type="radio" name="daThanhToan" value="false" required>No
    <input type="radio" name="daThanhToan" value="true" >Yes
    <br>
    <label>Tên phim</label>
    <select name="idPhim">
        <c:forEach items="${listPhim}" var="p">
            <option value="${p.id}" label="${p.tenPhim}"></option>
        </c:forEach>
    </select>
    <br>
    <button>Add</button>
</form>
<table border="1" style="border-collapse: collapse">
    <thead>
        <tr>
            <th>Stt</th>
            <th>Id</th>
            <th>Người đặt</th>
            <th>Số lượng vé</th>
            <th>Ngày chiếu</th>
            <th>Đã thanh toán</th>
            <th>Tên phim</th>
            <th>Thể loại</th>
            <th>Thời lượng</th>
            <th>Hành động</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listVeDat}" var="vd" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${vd.id}</td>
                <td>${vd.nguoiDat}</td>
                <td>${vd.soLuongVe}</td>
                <td>${vd.ngayChieu}</td>
                <td>${vd.daThanhToan == false ? "No" : "Yes"}</td>
                <td>${vd.phim.tenPhim}</td>
                <td>${vd.phim.theLoai}</td>
                <td>${vd.phim.thoiLuong}</td>
                <td>
                    <a href="/ve-dat/xoa?id=${vd.id}"><button>Xoa</button></a>
                    <a href="/ve-dat/view-update?id=${vd.id}"><button>Sua</button></a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
