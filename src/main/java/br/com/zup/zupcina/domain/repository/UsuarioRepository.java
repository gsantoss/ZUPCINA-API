package br.com.zup.zupcina.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.zupcina.domain.model.Usuario;

/*Infarce reponsável por fazer a transição com nosso repositório realizando as operações CRUD
 * Essa interface, para tanto, deve extender (herdar) uma outra interface: JpaRepository */

/*A anotação @Repository informa que a interface é um componete gerenciado e instaciado pelo próprio Spring 
 * ela indica que a interface é um repositório.
 * Em resumo o@Repository anota classes na camada de persistência, que atuará como um repositório de banco de dados;*/
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
