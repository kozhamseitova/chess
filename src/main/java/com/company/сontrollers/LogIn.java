package com.company.сontrollers;

import com.company.models.Messages;
import com.company.models.User;
import com.company.threads.GreetingServer;
import com.company.util.MessagesDB;
import com.company.util.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

@WebServlet(name = "LogIn")
public class LogIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        UserDB userDao = UserDB.getInstance();
        MessagesDB messagesDB = MessagesDB.getInstance();
        User user = userDao.getUserByEmail(email);
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            if(user.getPassword().equals(password)){
                if(user.getEmail().equals("admin@mail.com")){
                    request.getRequestDispatcher("jsp/choose.jsp").forward(request, response);
                }
                else {
                    ArrayList<Messages> messages = messagesDB.getMessages();
                    request.setAttribute("messages", messages);
                    request.getRequestDispatcher("jsp/chat.jsp").forward(request, response);
                }
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
