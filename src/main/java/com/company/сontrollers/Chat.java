package com.company.сontrollers;

import com.company.models.Messages;
import com.company.util.MessagesDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Chat")
public class Chat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("textInput");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        MessagesDB messagesDb = MessagesDB.getInstance();
        messagesDb.addMessages(email, message);

        ArrayList<Messages> messages = messagesDb.getMessages();
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("jsp/chat.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String d = request.getParameter("d");

        MessagesDB messagesDb = MessagesDB.getInstance();

        if(d.equals("d")){
            messagesDb.removeFromMessages();
        }


        ArrayList<Messages> messages = messagesDb.getMessages();
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("jsp/chat.jsp").forward(request, response);
    }


}
