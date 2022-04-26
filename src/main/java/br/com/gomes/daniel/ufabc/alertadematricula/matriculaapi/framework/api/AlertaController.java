package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.api;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Alerta;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Periodo;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.AlertaDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.DisciplinaDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.alerta.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/alerta")
@RestController
@CrossOrigin
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @PostMapping
    public void criar(@RequestBody Alerta alerta) {
        AlertaDAO alertaDAO = new AlertaDAO(alerta.getIdDisciplina(), alerta.getEmail().getCorpo());
        alertaRepository.save(alertaDAO);
    }

    @PostMapping("/{id}")
    void desativar(@PathVariable String id) {
        alertaRepository.desativarAlerta(id);
    }

    @GetMapping ("/{id}")
    ResponseEntity<DisciplinaDAO> buscarDisciplinaPorAlerta(@PathVariable String id) {
        Object[][] objetoMapeado = alertaRepository.buscarAlerta(id);
        if( objetoMapeado.length == 0){
            return ResponseEntity.notFound().build();
        }
        Object[] dadosDisciplina = objetoMapeado[0];
        DisciplinaDAO disciplina = new DisciplinaDAO(
                (Integer) (dadosDisciplina[0]),
                (String) dadosDisciplina[1],
                Periodo.valueOf((String) dadosDisciplina[2]),
                (Integer) dadosDisciplina[3],
                (Integer) dadosDisciplina[4],
                (Integer) dadosDisciplina[5],
                (Integer) dadosDisciplina[6],
                (String) dadosDisciplina[7],
                (String) dadosDisciplina[8]
);
        return ResponseEntity.ok(disciplina);
    }


}
