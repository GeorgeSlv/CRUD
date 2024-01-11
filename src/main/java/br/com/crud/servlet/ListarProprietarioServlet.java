package br.com.crud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.bean.CadastroPropVeiculoDao;
import br.com.crud.bean.Cadastros;

@WebServlet("/listarProprietario")
public class ListarProprietarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CadastroPropVeiculoDao banco = new CadastroPropVeiculoDao();

		List<Cadastros> cad = banco.buscarTodosCadastros();
//		System.out.println(cad);
		
		request.setAttribute("cadastros", cad);
		RequestDispatcher rd = request.getRequestDispatcher("/ListaProprietario.jsp");
		rd.forward(request, response);
		
	}

}
