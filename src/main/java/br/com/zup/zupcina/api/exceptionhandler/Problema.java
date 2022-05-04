package br.com.zup.zupcina.api.exceptionhandler;

import java.time.LocalDateTime;

/*Esta classe tem relação direta com a classe ApiExceptionhandler e ela foi
 * criada para representar a resposta a uma exceção.*/
public class Problema {

	//para informar o código do status (500, 400, etc..)
	private Integer status;
	//para informar a data e hora que foi gerado a resposta com o erro
	private LocalDateTime dataHora;
	
	//para informar o título do problema/erro
	private String titulo;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
