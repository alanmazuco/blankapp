package br.eti.amazu.blankapp;
	
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	
@WebServlet(name = "HelloServlet", loadOnStartup = 2, urlPatterns = {"/oi", "/ola"})
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = -7603622514092516565L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
		try {
			response.setContentType("text/html");
		 
			// Escreverendo o conteudo da pagina.		
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Hello World!</h1>");
			out.println("</body>");
			out.println("</html>");
		
		}catch(Exception e) {
			//do not compliance
		}
	}
	
}
