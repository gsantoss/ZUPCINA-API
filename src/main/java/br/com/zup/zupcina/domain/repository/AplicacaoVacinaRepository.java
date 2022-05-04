package br.com.zup.zupcina.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.zupcina.domain.model.AplicacaoVacina;

@Repository
public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long>{

}
