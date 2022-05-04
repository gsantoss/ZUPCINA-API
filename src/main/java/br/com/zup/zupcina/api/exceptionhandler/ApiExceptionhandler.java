package br.com.zup.zupcina.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*A anotação @ControllerAdvice é componente do Spring e indica aqui
 * que a classe ApiExceptionhandler fará o tratamento de Exceções de todos
 * os controladores, ou seja, se alguma classe controladora lançar alguma exeção,
 * a aplicação apontará para os métodos contidos nesta classe para que eles
 * tratem devidamente a exceção lançada e retornar um reposta mais adequada
 * ao consumidor da API. A classe herda vários métodos bases de tratamento de exceções da classe
 * ResponseEntityExceptionHandler*/
@ControllerAdvice
public class ApiExceptionhandler extends ResponseEntityExceptionHandler{

	/*Sobrescrevemos o método abaixo no intuito de apresentar uma reposta mais adequada ao consumidor da API
	 * quando este estiver de frente com alguma exceção lançada*/
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		var problema =  new Problema();
		
		//Aqui nossa aplicação pega o código do status (400,500, etc...)
		problema.setStatus(status.value());
		
		//Aqui nossa aplicação lança a mensagem de titulo do problema
		problema.setTitulo("Um ou mais campos estão inválidos, preencha os campos "
				+ "corretamente e tente novamente.");
		
		//Aqui nossa aplicação lança a data e hora que a exeção foi executada
		problema.setDataHora(LocalDateTime.now());
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}
