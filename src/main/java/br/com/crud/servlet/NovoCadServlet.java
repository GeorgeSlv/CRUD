package br.com.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.bean.CadastroPropVeiculoDao;
import br.com.crud.bean.Cadastros;

/**
 * Servlet implementation class NovoCadServlet
 */
@WebServlet("/novoCad")
public class NovoCadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//query de inserção de dados
		CadastroPropVeiculoDao banco = new CadastroPropVeiculoDao();
		Cadastros cad = new Cadastros();
		
		cad.setNome(request.getParameter("name"));
		cad.setCpf_cnpj(request.getParameter("cpf_cnpj"));
		cad.setEndereco(request.getParameter("endereco"));
		cad.setPlaca(request.getParameter("placa"));
		cad.setRenavam(request.getParameter("renavam"));
		
		System.out.println(cad);
		
		banco.addCad(cad);
		System.out.println("Novo cadastro realizado com sucesso !");
		
		response.sendRedirect("listarProprietario");
	}

}
