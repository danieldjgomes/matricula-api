package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.app.repositorios.servicos.sql;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Disciplina;

import java.util.List;
import java.util.Map;

public interface GeradorDeQuery extends SQLService {

    public String geraAtualizacaoVaga(List<String> atualizados, Map<String, Disciplina> vagas);

    public String geraAtualizacaoVaga(List<Disciplina> atualizados);

}
