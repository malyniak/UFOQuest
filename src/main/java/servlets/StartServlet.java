package servlets;

import service.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    StartService service=StartService.getService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String answer = request.getParameter("answer");
        service.checkAnswer(new Answer(answer));
        var nextUrl = service.getNextStep().getUrl();
        var requestDispatcher = request.getServletContext().getRequestDispatcher(nextUrl);
        requestDispatcher.forward(request,response);
    }
}
