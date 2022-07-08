package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.AlunoDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.Autenticador;

public interface AlunoOAuth2Service  {

    void registrarNovoAluno(String nome, String email, Autenticador autenticador);

    void atualizarAlunoExistente(String nome, String email, Autenticador autenticador);

    AlunoDAO buscarAlunoPorEmail(String email);


}
