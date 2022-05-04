package br.com.zup.zupcina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.zupcina.domain.exception.NegocioException;
import br.com.zup.zupcina.domain.model.AplicacaoVacina;
import br.com.zup.zupcina.domain.model.Usuario;
import br.com.zup.zupcina.domain.repository.AplicacaoVacinaRepository;
import br.com.zup.zupcina.domain.repository.UsuarioRepository;


@Service
public class CadastroAplicacaoVacinaService {

	@Autowired
	private AplicacaoVacinaRepository aplicacaoVacinaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//método para salvar uma aplicacaoVacina
	public AplicacaoVacina salvar(AplicacaoVacina aplicacaoVacina) {
		
		/*variável criada para receber um usuario da classe UsuarioRepositoy que busca por ID, se o
		 usuario não for encontrado então a aplicação lança uma mensagem de execeção*/
		Usuario usuario = usuarioRepository.findById(aplicacaoVacina.getUsuario().getId())
				.orElseThrow(() -> new NegocioException("Usuario não foi encontrado! - COD 400"));
		
		aplicacaoVacina.setUsuario(usuario);
		
		return aplicacaoVacinaRepository.save(aplicacaoVacina);
	}

}
