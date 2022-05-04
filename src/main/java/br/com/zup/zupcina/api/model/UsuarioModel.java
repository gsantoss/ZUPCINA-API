package br.com.zup.zupcina.api.model;

import java.time.OffsetDateTime;

/*Essa classe é um modelo de representação de nosso recurso, por meio do Padrão de projetos TDO
 * nós usaremos essa classe para a tranferência de dados. Ela representará nossa classe Usuário*/
public class UsuarioModel {

	private Long id;
	private String nomeUsuario;
	private String Email;
	private String cpf;
	private OffsetDateTime dataNascimento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nomeUsuario;
	}
	public void setNome(String nome) {
		this.nomeUsuario = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public OffsetDateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(OffsetDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
