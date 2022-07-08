package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.AlunoDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.Autenticador;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.framework.repositorios.DAO.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AlunoOAuth2ServiceImpl implements AlunoOAuth2Service {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void registrarNovoAluno(String nome, String email, Autenticador autenticador) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setNome(nome);
        alunoDAO.setEmail(email);
        alunoDAO.setSituacao(SituacaoAluno.ATIVO.getCodigo());
        alunoDAO.setAutenticador(autenticador);
        alunoDAO.setCriacao(new Date());
        alunoDAO.setUltimoAcesso(new Date());
        alunoRepository.save(alunoDAO);
    }

    @Override
    public void atualizarAlunoExistente(String nome, String email, Autenticador autenticador) {
        AlunoDAO alunoDAO = alunoRepository.findByEmail(email);
        alunoDAO.setNome(nome);
        alunoDAO.setEmail(email);
        alunoDAO.setAutenticador(autenticador);
        alunoDAO.setAtualizacao(new Date());
        alunoDAO.setUltimoAcesso(new Date());
        alunoRepository.save(alunoDAO);
    }

    @Override
    public AlunoDAO buscarAlunoPorEmail(String email) {
        return alunoRepository.findByEmail(email);
    }
}

