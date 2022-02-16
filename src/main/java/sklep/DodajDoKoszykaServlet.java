package sklep;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DodajDoKoszykaServlet", value = "/DodajDoKoszykaServlet")
public class DodajDoKoszykaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int numerPoduktu = Integer.parseInt(id);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Dodany produkt do koszyka " + numerPoduktu);

        OfertaSklepu sklep = new OfertaSklepu();

        Produkt znalezionyProdukt = sklep.znajdzProdukt(numerPoduktu);

        Koszyk koszyk = (Koszyk) request.getSession().getAttribute("koszyk");
        if(koszyk == null){
            koszyk = new Koszyk();
            request.getSession().setAttribute("koszyk", koszyk);

        }
        koszyk.dodajDoKoszyka(znalezionyProdukt);
        printWriter.println(koszyk.toString());

    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
