//package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositoriosImpl.DAO.disciplina;
//
//import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.app.dominio.excessoes.RepositorioDisciplinaIndisponivelException;
//import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Disciplina;
//import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.DisciplinaDAO;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class DisciplinaRepositoryImpl implements DisciplinaRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    public Optional<List<Disciplina>> getDisciplinas() {
//        String sql = "SELECT * FROM DISCIPLINA";
//        Query query = em.createNativeQuery(sql, DisciplinaDAO.class);
//        List<DisciplinaDAO> disciplinasDAO = query.getResultList();
//        List<Disciplina>  disciplinas = disciplinasDAO.stream().map(DisciplinaDAO::toDomain).collect(Collectors.toList());
//
//         return Optional.ofNullable(Optional.of(disciplinas).orElseThrow(RepositorioDisciplinaIndisponivelException::new));
//
//    }
//
//}
//
