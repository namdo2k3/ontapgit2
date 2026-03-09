package com.example.Phim1.controller;

import com.example.Phim1.model.Phim;
import com.example.Phim1.model.VeDat;
import com.example.Phim1.repo.PhimRepository;
import com.example.Phim1.repo.VeDatRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletVeDat", value = {"/ServletVeDat"
    ,"/ve-dat/hien-thi"
    ,"/ve-dat/view-update"
    ,"/ve-dat/them"
    ,"/ve-dat/sua"
    ,"/ve-dat/xoa"
})
public class ServletVeDat extends HttpServlet {
    VeDatRepository veDatRepository = new VeDatRepository();
    PhimRepository phimRepository = new PhimRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uri = request.getRequestURI();
if(uri.contains("/ve-dat/hien-thi")) {
    hienThi(request,response);
}else if(uri.contains("/ve-dat/view-update")) {
    viewUpdate(request,response);
}else if(uri.contains("/ve-dat/xoa")) {
    xoa(request,response);
}
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        veDatRepository.XoaVeDat(id);
        response.sendRedirect("/ve-dat/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("vd",veDatRepository.getById(id));
        request.setAttribute("listPhim", phimRepository.getAll());
        request.getRequestDispatcher("/view/view-update.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listVeDat", veDatRepository.getAll());
        request.setAttribute("listPhim", phimRepository.getAll());
        request.getRequestDispatcher("/view/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uri = request.getRequestURI();
if(uri.contains("/ve-dat/them")) {
    them(request,response);
}else if(uri.contains("/ve-dat/sua")) {
    sua(request,response);
}
    }

    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String nguoiDat = request.getParameter("nguoiDat");
        Integer soLuongVe = Integer.valueOf(request.getParameter("soLuongVe"));
        String ngayChieu = request.getParameter("ngayChieu");
        Boolean daThanhToan = Boolean.valueOf(request.getParameter("daThanhToan"));
        Integer idPhim = Integer.valueOf(request.getParameter("idPhim"));
        Phim phim = phimRepository.getById(idPhim);
        VeDat veDat = new VeDat(id,nguoiDat,soLuongVe,ngayChieu,daThanhToan,phim);
        veDatRepository.SuaVeDat(veDat);
        response.sendRedirect("/ve-dat/hien-thi");
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nguoiDat = request.getParameter("nguoiDat");
        Integer soLuongVe = Integer.valueOf(request.getParameter("soLuongVe"));
        String ngayChieu = request.getParameter("ngayChieu");
        Boolean daThanhToan = Boolean.valueOf(request.getParameter("daThanhToan"));
        Integer idPhim = Integer.valueOf(request.getParameter("idPhim"));
        Phim phim = phimRepository.getById(idPhim);
        VeDat veDat = new VeDat(null,nguoiDat,soLuongVe,ngayChieu,daThanhToan,phim);
        veDatRepository.ThemVeDat(veDat);
        response.sendRedirect("/ve-dat/hien-thi");
    }
}
