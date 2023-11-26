package servlets;

import service.Answer;
import service.CaptainBridgeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/captain")
public class CaptainBridgeServlet extends HttpServlet {
    CaptainBridgeService captainBridgeService=CaptainBridgeService.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String answer = request.getParameter("answer");
        captainBridgeService.checkAnswer(new Answer(answer));
        var nextUrl = captainBridgeService.getNextStep().getUrl();
        var requestDispatcher = request.getServletContext().getRequestDispatcher(nextUrl);
        requestDispatcher.forward(request,response);
    }
}
