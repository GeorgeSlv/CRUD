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
 * Servlet implementation class AlterarCadServlet
 */
@WebServlet("/alterarCad")
public class AlterarCadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cadastros cadUni = new Cadastros();
		String paramId = request.getParameter("id");
		
		cadUni.setId(Integer.valueOf(paramId));
		cadUni.setNome(request.getParameter("name"));
		cadUni.setCpf_cnpj(request.getParameter("cpf_cnpj"));
		cadUni.setEndereco(request.getParameter("endereco"));
		cadUni.setPlaca(request.getParameter("placa"));
		cadUni.setRenavam(request.getParameter("renavam"));
		
		CadastroPropVeiculoDao banco = new CadastroPropVeiculoDao();
		banco.atualizaCad(cadUni);
		System.out.println("Alterar dados de cadastro.");
		
		response.sendRedirect("listarProprietario");
	}

}
