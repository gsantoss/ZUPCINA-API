package br.com.zup.zupcina.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.zupcina.api.model.AplicacaoVacinaInput;
import br.com.zup.zupcina.api.model.AplicacaoVacinaModel;
import br.com.zup.zupcina.domain.model.AplicacaoVacina;
import br.com.zup.zupcina.domain.repository.AplicacaoVacinaRepository;
import br.com.zup.zupcina.domain.service.CadastroAplicacaoVacinaService;

@RestController
@RequestMapping("/aplicacaovacinas")
public class AplicacaoVacinaController {

	@Autowired
	private AplicacaoVacinaRepository aplicacaoVacinaRepository; 
	
	@Autowired
	private CadastroAplicacaoVacinaService cadastroAplicacaoVacinaService;
	
	/*Para a anotação @Autowired funcionar devidamente precisaremos  transformar o modelMapper
	 *em uma instância gerenciada pelo container do Spring. Fazemos isso através da criação de uma
	 *classe que neste projeto receberá o nome ModelMapper Config (dentro do pacote core)*/
	@Autowired
	private ModelMapper modelMapper;
	
	/*A anotação @GetMapping mapeia a solicitação HTTP, através dela podemos ver as requisições
	 * do métodos http GET e POST, PUT e DELETE. No método listar abaixo nossa aplicação identificará
	 * que a requisição usou o GET para retornar uma lista de usuários (O método então retornará um JSON
	 * uma represnetação da lista de usuário, uma REPRESENTAÇÃO de um RECURSO é um código que desceve o estado
	 * atual do recurso )*/
	@GetMapping
	public List<AplicacaoVacinaModel> listar() {
		
		//retorna todos os registros de usuários contigo na base de dados
		return toColletcionModel(aplicacaoVacinaRepository.findAll());
		
	}
	
	/*A anotação @PostMapping indica que sempre que houver uma resquisição
	 * advinda do método POST o método abaixo será executado. Já a anotação
	 * @RequestBody associa o parâmetro do método ao corpo da solicitação HTTP,
	 * ou seja, com o @RequestBody estamos dizendo ao Spring transformar o
	 * corpo do recurso passado na requisição em um objeto Usuário.
	 * A anotação @ResponseStatus(HttpStatus.CREATED) indica que que o método
	 * abaixo informará uma mensagem de Status CREATED (Código 201 para informar que
	 * o obejto foi criado com sucesso). O @Valid ativa a validação de dados
	 * gerenciado pelo BeanValidation*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AplicacaoVacinaModel adcionar(@Valid @RequestBody AplicacaoVacinaInput aplicacaoVacinaInput) {
		AplicacaoVacina aplicacaoVacina = toEntityAplicacaoVacina(aplicacaoVacinaInput);
		return toModel(cadastroAplicacaoVacinaService.salvar(aplicacaoVacina));
	}
	
	
	//Método que tranforma um Usuario em um UsuarioModel
	private AplicacaoVacinaModel toModel(AplicacaoVacina aplicacaoVacina) {
		return modelMapper.map(aplicacaoVacina, AplicacaoVacinaModel.class);
	}
	
	//Método que tranforma uma lista Usuarios em uma lista de UsuariosModel
	private List<AplicacaoVacinaModel> toColletcionModel(List<AplicacaoVacina> aplicacaoVacinas) {
		return aplicacaoVacinas.stream()
				.map(aplicacaoVacina -> toModel(aplicacaoVacina))
				.collect(Collectors.toList());
	}
	
	
	//Método que transforma uma AplicacaoVacinaInput em uma entidade do tipo AplicacaoVacina 
	private AplicacaoVacina toEntityAplicacaoVacina(AplicacaoVacinaInput aplicacaoVacinaInput) {
		return modelMapper.map(aplicacaoVacinaInput, AplicacaoVacina.class);
	}
}
