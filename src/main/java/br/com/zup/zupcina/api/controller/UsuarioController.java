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

import br.com.zup.zupcina.api.model.UsuarioModel;
import br.com.zup.zupcina.domain.model.Usuario;
import br.com.zup.zupcina.domain.repository.UsuarioRepository;
import br.com.zup.zupcina.domain.service.CadastroUsuarioService;


/*Ao fazer a leitura do código, quando o Spring identificar a anotação @RestController ele entenderá 
 * esta classe em um controlador e que ela irá receber requisições http e devolver respotas. Ou seja,
 * ele fara a comunicação com a parte frontal da nossa aplicação.
 * O @RestController trás consigo por padrão a anotação @ResponseBody, que permite que 
 * as respostas as requisições feitas, sejam uma serializado em  formato JSON, XML, ou outro formato*/
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	/*A anotação @Autowired indica para a aplicação que  usaremos uma instâcia
	 * do repositório aqui. Neste caso uma instância de UsuarioRepository.
	 * De forma resumida ela é uma anotação para injeção de classes/dependências
	 * gerenciada pelo Spring.
	 * */
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	/*Para a anotação @Autowired funcionar devidamente precisaremos  transformar o modelMapper
	 *em uma instância gerenciada pelo container do Spring. Fazemos isso através da criação de uma
	 *classe que neste projeto receberá o nome ModelMapper Config (dentro do pacote core)*/
	@Autowired
	private ModelMapper modelMapper;
	
	/*A anotação @GetMapping mapeia a solicitação HTTP, através dela podemos ver as requisições
	 * do métodos http (GET e POST, PUT e DELETE). No método listar abaixo nossa aplicação identificará
	 * que a requisição usou o GET para retornar uma lista de usuários (O método então retornará um JSON
	 * uma represnetação da lista de usuário, uma REPRESENTAÇÃO de um RECURSO é um código que desceve o estado
	 * atual do recurso )*/
	@GetMapping
	public List<UsuarioModel> listar() {
		
		//retorna todos os registros de usuários contidos na base de dados
		return toColletcionModel(usuarioRepository.findAll());
		
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
	public UsuarioModel adcionar(@Valid @RequestBody Usuario usuario) {
		return toModel(cadastroUsuarioService.salvar(usuario));
	}
	
	
	//Método que tranforma um Usuario em um UsuarioModel
	private UsuarioModel toModel(Usuario usuario) {
		return modelMapper.map(usuario, UsuarioModel.class);
	}
	
	//Método que tranforma uma lista Usuarios em uma lista de UsuariosModel
		private List<UsuarioModel> toColletcionModel(List<Usuario> usuarios) {
			return usuarios.stream()
					.map(usuario -> toModel(usuario))
					.collect(Collectors.toList());
		}
}
