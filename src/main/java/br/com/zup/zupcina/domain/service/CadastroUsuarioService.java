package br.com.zup.zupcina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.zupcina.domain.model.Usuario;
import br.com.zup.zupcina.domain.repository.UsuarioRepository;

/*Esta Classe será responsável pelas regras de negócios CRUD de nossa aplicação
 *Ao anotarmos ela com @Service estamos dizendo que ela é uma classe de Serviço.
 *O Spring irá instanciar um objeto desta classe e esse obejto estará diponível 
 *para ser injetado em qualquer outro componente do Spring, como por exemplo: na
 *classe UsuarioController*/
@Service
public class CadastroUsuarioService {

	/*A anotação @Autowired indica para a aplicação que usaremos uma
	instância do repositório aqui. De forma resumida ela é uma anotação para
	injeção de classes/dependências gerenciada pelo Spring.*/
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//método para salvar o usuário
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
