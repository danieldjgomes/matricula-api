package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO;

import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Email;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ALUNO")
public class AlunoDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "situacao")
    private Integer situacao;

    @Column(name = "criacao")
    private Date criacao;

    @Column(name = "atualizacao")
    private Date atualizacao;

    @Column(name = "ultimoAcesso")
    private Date ultimoAcesso;

    @Enumerated(EnumType.STRING)
    @Column
    private Autenticador autenticador;

}
