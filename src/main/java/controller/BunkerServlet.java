package controller;

import model.Game;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/bunker")
public class BunkerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Game game = new Game();
        session.setAttribute("game", game);
        request.getRequestDispatcher("bunker.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");

        if (game == null) {
            game = new Game();
            session.setAttribute("game", game);
        }

        String action = request.getParameter("action");
        try {
            game.makeChoice(action);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("game", game);

        if (game.isAlive()) {
            if (action.equals("outside")){
                request.getRequestDispatcher("outside.jsp").forward(request, response);
            } if (action.equals("bunker")){
                request.getRequestDispatcher("bunker.jsp").forward(request,response);
            }
        } else {
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}
