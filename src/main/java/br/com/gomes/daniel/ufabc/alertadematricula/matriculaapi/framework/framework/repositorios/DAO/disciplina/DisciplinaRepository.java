package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.disciplina;


import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.DisciplinaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaDAO,String> {

}
