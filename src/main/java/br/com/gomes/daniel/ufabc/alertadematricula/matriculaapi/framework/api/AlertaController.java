package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.api;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Alerta;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.alerta.AlertaDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.alerta.AlertaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/alerta")
@RestController
@CrossOrigin
@Slf4j
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @PostMapping
    public void criar(@RequestBody Alerta alerta) {
        AlertaDAO alertaDAO = new AlertaDAO(alerta.getIdDisciplina(), alerta.getEmail().getCorpo());
        alertaRepository.save(alertaDAO);
        log.info("Alerta criado para " + alerta.getIdDisciplina());
    }

    @PostMapping("/{id}")
    void desativar(@PathVariable String id) {
        alertaRepository.desativarAlerta(id);
    }


}
