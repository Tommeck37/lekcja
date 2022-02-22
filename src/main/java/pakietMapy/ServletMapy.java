package pakietMapy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/ServletMapy")
public class ServletMapy extends HttpServlet {
    private HashMap<Integer, String> mapaProduktów;

    public void init() {
        System.out.println("Tworzymy pustą mapę");
        mapaProduktów = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("operacja");
        PrintWriter printWriter = response.getWriter();

        if (param == null) {
            wyświetlMapę(request, response);
        } else if (param.equals("dodaj")) {
        dodajDoMapy(request, response);
        }else if (param.equals("usuń")){
            usuńZMapy(request, response);
        }else {
            printWriter.println("Nie ma operacji: " + param);
        }
    }

    private void wyświetlMapę(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println(mapaProduktów);
    }

    private void dodajDoMapy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        Integer numerProduktu = Integer.parseInt(request.getParameter("id"));
        String nazwaProduktu = request.getParameter("nazwa");
        if(nazwaProduktu == null || numerProduktu == null){
            printWriter.println("brak pozostałych parametrów");
        }else {
            mapaProduktów.put(numerProduktu,nazwaProduktu);
            printWriter.println(mapaProduktów);
        }
    }    private void usuńZMapy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        Integer numberProduktu = Integer.parseInt(request.getParameter("id"));
        if(numberProduktu == null){
            printWriter.println("brak  paremtru id");
        }else {
            mapaProduktów.remove(numberProduktu);
        }
        printWriter.println(mapaProduktów);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nazwa = request.getParameter("nazwa");
        PrintWriter printWriter = response.getWriter();
        if(id == null|| nazwa ==null){
            printWriter.println("brak paraterów formularza");
        }else {
            Integer idProduktu = Integer.parseInt(id);
            mapaProduktów.put(idProduktu,nazwa);
            printWriter.println(mapaProduktów);
        }
    }
}
