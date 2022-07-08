package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.AlunoDAO;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO.Autenticador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class OAuth2SucessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private AlunoOAuth2Service alunoOAuth2Service;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        UsuarioOAuth2 usuario = (UsuarioOAuth2) authentication.getPrincipal();

        AlunoDAO aluno = alunoOAuth2Service.buscarAlunoPorEmail(usuario.getEmail());

        if (aluno != null) {
            if (dadosDeIdentificacaoDiferem(usuario, aluno)) {
                alunoOAuth2Service.atualizarAlunoExistente(usuario.getName(), usuario.getEmail(), Autenticador.FACEBOOK);
            }
        } else {
            alunoOAuth2Service.registrarNovoAluno(usuario.getName(), usuario.getEmail(), Autenticador.FACEBOOK);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

    private boolean dadosDeIdentificacaoDiferem(UsuarioOAuth2 usuario, AlunoDAO aluno) {
        return !aluno.getNome().equals(usuario.getName()) || !aluno.getEmail().equals(usuario.getEmail());
    }
}
