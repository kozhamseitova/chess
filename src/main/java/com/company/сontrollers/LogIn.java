package com.company.сontrollers;

import com.company.models.User;
import com.company.util.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogIn")
public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDB userDao = UserDB.getInstance();
        User user = userDao.getUserByEmail(email);
        if(user!=null){
            if(user.getPassword().equals(password)){
                String status = request.getParameter("chess");
                HttpSession session = request.getSession(true);
                session.setAttribute("user",user);
                session.setAttribute("status", status);
                session.setMaxInactiveInterval(60);
                Cookie ck=new Cookie("email",email);
                response.addCookie(ck);

                request.getRequestDispatcher("jsp/main.jsp").forward(request, response);
            }else{
                String mess = "Incorrect password, try again!!!";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("jsp/log.jsp").forward(request, response);
            }
        }else{
            String mess = "Incorrect username, try again!!!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("jsp/log.jsp").forward(request, response);
        }
    }
}
