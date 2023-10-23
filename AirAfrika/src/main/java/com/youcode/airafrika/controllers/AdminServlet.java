package com.youcode.airafrika.controllers;

import com.youcode.airafrika.services.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class AdminServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init() throws ServletException {
        adminService = new AdminService();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("views/admin/login.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(adminService.login(email, password)) {
            req.getSession().setAttribute("isAuthenticated", true);
            resp.sendRedirect(req.getContextPath() + "/flight?action=list");
        } else {
            req.getSession().setAttribute("isAuthenticated", false);
            req.setAttribute("credentials", false);
            req.getRequestDispatcher("/views/admin/login.jsp").forward(req, resp);
        }
    }
}
