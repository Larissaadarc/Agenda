package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



	@WebServlet("/PaginaPrincipal")

public class ListTaskServelet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		public ListTaskServelet() {
			super();
	        // TODO Auto-generated constructor stub
	    }
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/principal.jsp");
			dispatcher.forward(request, response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {            
            
            CadTaskServelet des = new CadTaskServelet();
            
            des.doGet(request, response);
	    }
		

	}
