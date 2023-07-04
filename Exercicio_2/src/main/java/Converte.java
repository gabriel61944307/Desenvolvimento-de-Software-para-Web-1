import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Converte", urlPatterns = {"/converte"})
public class Converte extends HttpServlet {
    protected void processRequest(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int min = -100;
            try {
                String minValue = request.getParameter("val_min");
                min = Integer.parseInt(minValue);
            }catch(Exception ex){}
            
            int max = 100;
            try{
                String maxValue = request.getParameter("val_max");
                max = Integer.parseInt(maxValue);
            }catch(Exception ex){}

            int inc = 5;
            try {
                String incValue = request.getParameter("val_inc");
                inc = Integer.parseInt(incValue);
            }catch(Exception ex){}
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("\t<head>");
            out.println("\t\t<meta http-equiv=\"Content-Type\"content=\"text/html; charset=UTF-8\">");
            out.println("\t\t<title>Calculadora</title>");
            out.println("\t\t<link rel=\"stylesheet\" type=\"text/css\"href=\"estilo.css\">");
            out.println("\t</head>");
            out.println("\t<body>");
            out.println("\t<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Celsius</th>");
            out.println("<th>Fahrenheit</th>");
            out.println("</tr>");
            for (int celsius = min; celsius <= max; celsius += inc) {
                double fahr = 1.8 * celsius + 32;
                out.println("<tr>");
                out.println("<td>" + celsius + "</td>");
                out.println("<td>" + fahr + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("\t</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
