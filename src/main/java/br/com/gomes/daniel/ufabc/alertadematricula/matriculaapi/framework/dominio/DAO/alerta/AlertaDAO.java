package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "ALERTA")
public class AlertaDAO {

    @Id
    private String id;
    @Column
    private String disciplinaID;
    @Column
    private String email;
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    @Column
    private Date criacao;
    @Column
    private Date encerramento;

    public AlertaDAO(String disciplinaID, String email) {

        this.id = UUID.randomUUID().toString();
        this.disciplinaID = disciplinaID;
        this.email = email;
        this.status = Status.NOTIFICANDO;
        this.criacao = new Date();
    }
}
