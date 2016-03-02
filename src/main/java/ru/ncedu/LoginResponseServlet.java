package ru.ncedu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Gorbatovskiy on 02.03.2016.
 */
public class LoginResponseServlet extends HttpServlet {
    private static HashMap<String, String> userDB;

    static {
        userDB = new HashMap<String, String>();
        userDB.put("admin", "admin");
        userDB.put("user", "qwerty");
        userDB.put("gscii", "javatask");
    }

    private void validate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String realPass = null;
        if (login != null && password != null) {
            realPass = userDB.get(login);
            if (realPass == null || !realPass.equals(password)) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Неверный логин/пароль");
            } else {
                getServletContext()
                        .getRequestDispatcher("/logininfo.jsp")
                        .forward(req, resp);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Недопустимое значение логина/праоля");

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        validate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req, resp);
    }
}
