package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.api;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.DisciplinaDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.disciplina.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/disciplina")
@RestController
@CrossOrigin
public class DisciplinaController {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @GetMapping
    List<DisciplinaDAO> listarDisciplinas(){
        return disciplinaRepository.findAll();
    }

}
