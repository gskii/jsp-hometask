package ru.ncedu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Created by Gorbatovskiy on 02.03.2016.
 */
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Calendar calendar = Calendar.getInstance();
        StringBuilder date = new StringBuilder();
        date.append(calendar.get(Calendar.DAY_OF_MONTH)).append(":");
        date.append(calendar.get(Calendar.MONTH)).append(":");
        date.append(calendar.get(Calendar.YEAR));

        out.print("<div style=\"margin:auto; PADDING-TOP: 50%;\">"
                + date.toString()
                + "</div>"
        );
        out.close();
    }
}
