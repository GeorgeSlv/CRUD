package br.com.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.bean.CadastroPropVeiculoDao;

/**
 * Servlet implementation class RemoveCadServlet
 */
@WebServlet("/removeCad")
public class RemoveCadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		CadastroPropVeiculoDao banco = new CadastroPropVeiculoDao();
		banco.deletarCadPeloId(id);
		System.out.println("Dados excluidos");
		
		response.sendRedirect("listarProprietario");
	}

}
