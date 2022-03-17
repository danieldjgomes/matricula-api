package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.app.dominio.excessoes;

public class ChamadaIndisponivelException extends InfraestruturaException {

    public ChamadaIndisponivelException(String mensagemDeErro) {
        super(mensagemDeErro);
    }

}
