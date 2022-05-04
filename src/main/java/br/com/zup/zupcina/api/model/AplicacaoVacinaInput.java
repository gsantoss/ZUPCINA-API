package br.com.zup.zupcina.api.model;

import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Classe usada para a aentrada de dados na API
public class AplicacaoVacinaInput {

	@NotBlank
	private String nome;
	
	@NotNull
	private OffsetDateTime dataAplicacao;
	
	//Com esse @valid nossa aplicação irá casacatear a validação
	@Valid
	@NotNull
	private UsuarioIdInput usuario;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public OffsetDateTime getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(OffsetDateTime dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public UsuarioIdInput getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioIdInput usuario) {
		this.usuario = usuario;
	}
}
