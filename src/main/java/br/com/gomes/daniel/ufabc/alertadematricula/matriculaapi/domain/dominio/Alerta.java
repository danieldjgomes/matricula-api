package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio;

public class Alerta {

    String idDisciplina;
    Email email;
    Status status;

    public Alerta() {
    }
    public Alerta(String idDisciplina, Email email) {
        this.idDisciplina = idDisciplina;
        this.email = email;
        this.status = Status.NOTIFICANDO;
    }
    public Email getEmail() {
        return email;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}