package formy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/radio")
public class ServletRadio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forma = request.getParameter("payment");
        response.getWriter().println(forma);

//        getServletContext().getRequestDispatcher("/radio.html")
//                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String radio = request.getParameter("payment");
    response.getWriter().println(radio);
    }
}
