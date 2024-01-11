package br.com.crud.bean;

public class Cadastros {
	private Integer id;
	private String nome;
	private String cpf_cnpj;
	private String endereco;
	private String placa;
	private String renavam;
	
	@Override
	   public String toString() {
	       return "{" +
	               "id ='" + id + '\'' +
	               ", nome ='" + nome + '\'' +
	               ", cpf_cnpj ='" + cpf_cnpj + '\'' +
	               ", endereco ='" + endereco + '\'' +
	               ", placa ='" + placa + '\'' +
	               ", renavam ='" + renavam + '\'' +
	               '}';
	    }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	
	
}
