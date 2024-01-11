package br.com.crud.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.bean.CadastroPropVeiculoDao;
import br.com.crud.bean.Cadastros;

/**
 * Servlet implementation class MostraCadServlet
 */
@WebServlet("/mostraCad")
public class MostraCadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		CadastroPropVeiculoDao banco = new CadastroPropVeiculoDao();
		
		Cadastros cad = banco.buscarCadastroPeloId(id);
//		System.out.println(cad);
		
		request.setAttribute("cadastros", cad);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraCad.jsp");
		rd.forward(request, response);
		
	}

}
