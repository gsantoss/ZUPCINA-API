package br.com.zup.zupcina.api.model;

import javax.validation.constraints.NotNull;

/*Classe criada para referenciar o usuarioIdInput dentro da Classe
 * AplicacaoVacinaInput*/
public class UsuarioIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
