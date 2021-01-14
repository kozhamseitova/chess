package chat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ChatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //date
        SimpleDateFormat dateFormat=new SimpleDateFormat("HH:mm a, dd MMM", Locale.ENGLISH);
        req.setAttribute("time", dateFormat.format(Calendar.getInstance().getTime()));

        req.setAttribute("message", "some info");

        req.getRequestDispatcher("chat.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        String text = req.getParameter("textInput");

        System.out.println(file);
        System.out.println(text);

    }
}
