package fr.afpa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import afpa.fr.service.Service;

/**
 * Servlet implementation class FormulaireServlet
 */
//@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service ser = new Service();
		String login = request.getParameter("login");
		String mdp = request.getParameter("pass");
		String nom = request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String tel = request.getParameter("tel");
		String mail = request.getParameter("email");
		
		ser.ecrireFichier(login, mdp, nom, prenom, tel, mail);
		RequestDispatcher dispatcher;
			dispatcher = request.getRequestDispatcher("personneCree.jsp");
			dispatcher.forward(request, response);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
