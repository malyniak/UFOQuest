package servlets;

import service.Answer;
import service.IntroduceYourselfService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/introduce")
public class IntroduceYourselfServlet extends HttpServlet {
    IntroduceYourselfService service=IntroduceYourselfService.getService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String answer = request.getParameter("answer");
        service.checkAnswer(new Answer(answer));
        var nextUrl = service.getNextStep().getUrl();
        var requestDispatcher = request.getServletContext().getRequestDispatcher(nextUrl);
        requestDispatcher.forward(request,response);
    }
}
