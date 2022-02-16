package sklep;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/SklepServlet")
public class SklepServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        OfertaSklepu sklep = new OfertaSklepu();
        ArrayList<Produkt> lista = sklep.pobierzOferte();
        for (int i = 0; i < lista.size(); i++) {
            Produkt p = lista.get(i);
            printWriter.println(p.getId());
            printWriter.println("<a href=/DodajDoKoszykaServlet?id="+ p.getId()+">");
            printWriter.println(p.getNazwa());
            printWriter.println("</a>");
            printWriter.println(p.getCena() + " zł ");


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
