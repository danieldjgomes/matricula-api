package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.AlertaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AlertaRepository extends JpaRepository<AlertaDAO, String> {

    @Modifying
    @Transactional
    @Query(value = "Update alerta set status = 'ENCERRADO', encerramento = CURRENT_TIMESTAMP where id = :id", nativeQuery = true)
    void desativarAlerta(String id);

    @Query(value = "select d.* from alerta a " +
            "join disciplina d " +
            "on a.disciplinaID = d.identificadorUFABC " +
            "where a.id = :id", nativeQuery = true)
    Object[][] buscarAlerta(String id);

}
