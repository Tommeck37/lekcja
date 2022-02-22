package pakietMapy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ServletListaImion", value = "/ServletListaImion")
public class ServletListaImion extends HttpServlet {
    private List<String> listaImion;

    public void init() {
        System.out.println("Init servletu ListaImion");
        listaImion = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String akcja = request.getParameter("akcja");
        if (akcja == null) {
            wyświetlListe(request, response);
        } else if (akcja.equals("dodaj")) {
            dodajDoListy(request, response);
        } else if (akcja.equals("usun")) {
            usunZListy(request, response);
        } else if (akcja.equals("sortuj")) {
            wyswietlPosortowanaListe(request, response);
        }else if(akcja.equals("wyloguj")){
            request.getSession().invalidate();
        } else {
            response.getWriter().println("Brak akcji: może być: dodaj lub usun lub sortuj ");
        }
        wyswietlPosortowanaListe(request, response);
        wyswietlSesje(request, response);
        response.getWriter().println("<br>");
        response.getWriter().println("<br>");
        response.getWriter().println("<a href='/ServletListaImion?akcja=wyloguj'>Wyloguj</a>");
    }

    private void wyświetlListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("To jest lista " + listaImion);
    }

    private void dodajDoListy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        listaImion.add(imie);
        response.getWriter().println(listaImion);
    }

    private void usunZListy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        listaImion.remove(imie);
        response.getWriter().println(listaImion);

    }

    private void wyswietlPosortowanaListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collections.sort(listaImion);
        response.getWriter().println(listaImion);

    }
        private void wyswietlSesje(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession httpSession = request.getSession();
        String imieZSessji = (String) httpSession.getAttribute("imie");
        String haslo = (String) httpSession.getAttribute("haslo");
        response.getWriter().println("Sesja: " + imieZSessji + " " + haslo);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String imie = request.getParameter("imie");
        String password = request.getParameter("pass");
        HttpSession httpSession = request.getSession();
        if (imie == null || password == null) {
            response.getWriter().println("Bład logowania");
        } else {
            httpSession.setAttribute("imie", imie);
            httpSession.setAttribute("haslo", password);
            response.getWriter().println("Zostałeś zalogowany " + imie);

        }
    }
}
