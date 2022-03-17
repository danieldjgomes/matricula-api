package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio;


import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.excessoes.EmailInvalidoException;

public class Email {

    String corpo;

    public Email(String corpoInserido) {
        if (isCorpoValido(corpoInserido)){
            this.corpo = corpoInserido;
        }
        else{
            throw new EmailInvalidoException();
        }

    }

    public String getCorpo() {
        return this.corpo;
    }

    boolean isCorpoValido(String corpoValido){
       return corpoValido.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
