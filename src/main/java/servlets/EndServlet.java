package servlets;

import service.Answer;
import service.EndQuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lose")
public class EndServlet extends HttpServlet {
    EndQuestService endQuestService=EndQuestService.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String answer = request.getParameter("answer");
        endQuestService.checkAnswer(new Answer(answer));
        var nextUrl = endQuestService.getNextStep().getUrl();
        var requestDispatcher = request.getServletContext().getRequestDispatcher(nextUrl);
        requestDispatcher.forward(request,response);
    }
}
