package br.com.zup.zupcina.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Para a anotação @Autowired funcionar devidamente na propriedade modelMapper 
 *  das classes UsuarioController e AplicacaoVacinaController, precisaremos  
 *  transformar o modelMapper em uma instância gerenciada pelo container 
 *  do Spring. Fazemos isso através da criação dessa classe*/

/*A Anotação @Configuration é um componete Spring com objetivo de definicção, ou seja de
 * configuração de Beans.
 */
@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
