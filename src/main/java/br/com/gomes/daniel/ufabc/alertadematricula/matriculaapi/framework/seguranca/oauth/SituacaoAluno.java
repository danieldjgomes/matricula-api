package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.seguranca.oauth;

public enum SituacaoAluno {

    ATIVO(1);

    private final Integer codigo;

    SituacaoAluno(Integer i) {
        this.codigo = i;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
