package com.icu.schedule.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/api")
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用req.getSession()时，servlet会在响应头中设置响应头cookie记住jsessionid
        // Cookie:JSESSIONID=A5202FE3F8CCA7F9D3668409447D533C
        // HttpSession session = req.getSession();
        // System.out.println(session.getId());
        // System.out.println(session.isNew());
       // session.setAttribute("keya", "valuea");
       resp.addCookie(new Cookie("kk1", "vv1"));

        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            System.out.println("cookies is null");
        } else {
            System.out.println("--cookie for begin--");
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + "---" + cookie.getValue());
            }
            System.out.println("--cookie for end--");
        }

        PrintWriter writer = resp.getWriter();
        writer.println(new Date().toString());
        System.out.println("------------------------------------------------------------");
    }
}
