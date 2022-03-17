package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.app.dominio.excessoes;

public class RepositorioDisciplinaIndisponivelException extends RepositorioIndisponivelException {

    public RepositorioDisciplinaIndisponivelException() {
        super(new RepositorioDisciplinaIndisponivelException());
    }
}
