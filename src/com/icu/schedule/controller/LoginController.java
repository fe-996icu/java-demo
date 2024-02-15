package com.icu.schedule.controller;

import com.icu.schedule.common.Result;
import com.icu.schedule.utils.WebUtil;
import com.icu.schedule.vo.LoginParamVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xxxxxxxxxxxxxxxxx");
        LoginParamVO vo = WebUtil.readJson(req, LoginParamVO.class);
        System.out.println(vo);

        // LoginParamVO vo = new LoginParamVO("a", "b");
        // Object o1 = Result.ok(vo);
        // WebUtil.writeJson(resp,  Result.ok(vo));
    }
}
