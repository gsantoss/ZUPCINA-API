package br.com.zup.zupcina.api.model;

import java.time.OffsetDateTime;

public class AplicacaoVacinaModel {

	private Long id;
	
	private String nome;
	
	private OffsetDateTime dataAplicacao;
	
	private UsuarioResumoModel usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UsuarioResumoModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResumoModel usuario) {
		this.usuario = usuario;
	}
	
}
