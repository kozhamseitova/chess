package com.company.сontrollers;

import com.company.connection.Server;
import com.company.models.Messages;
import com.company.util.MessagesDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StartGame")
public class StartGame extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String status = request.getParameter("chess");

        String mess1;
        if(status.equals("white")){
            mess1 = "Server choose white, client plays with black";
        }
        else
            mess1 = "Server choose black, client plays with white";

        MessagesDB messagesDB = MessagesDB.getInstance();
        ArrayList<Messages> messages = messagesDB.getMessages();
        request.setAttribute("messages", messages);

        request.setAttribute("mess1", mess1);
        request.getRequestDispatcher("jsp/chat.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
