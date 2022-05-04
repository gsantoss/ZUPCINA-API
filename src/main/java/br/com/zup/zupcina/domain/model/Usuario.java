package br.com.zup.zupcina.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Usuario {

	/*A anotação @Id cria a chave primária da entidade no banco e a anotação @GeneratedValue
	 * com o uso do da estratégia IDENTIFY usa a forma padrão que o SGDB usa para a geração de suas 
	 * chaves primárias. No caso do MySQL o padrão adotado é o AUTO INCREMENTO*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*A anotação @NotBlank indica que a propriedade ao qual faz refrência não seja vazia
	 * null, ou que contenha somente espaços em branco*/
	@NotBlank
	private String nome;
	
	/*A anotação @Email indica que o atributo associado a ela é uma propriedade do tipo e-mail*/
	@NotBlank
	@Email
	private String email;
	
	/*A anotação @CPF indica que o campo associado a esta anotação é um atributo do tipo CPF*/
	@NotBlank
	@CPF
	private String cpf;
	
	/*A anotação @NotNull informa que o atributo não pode conter um valor Nulo*/
	@NotNull
	private OffsetDateTime dataNascimento;
	
	public Usuario() {
				
	}

	public Usuario(Long id, String nome, String email, String cpf, OffsetDateTime dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//Métodos getters e setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
