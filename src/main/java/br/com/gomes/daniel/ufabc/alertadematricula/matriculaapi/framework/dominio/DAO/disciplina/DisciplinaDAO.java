package br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.framework.dominio.DAO;


import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Disciplina;
import br.com.gomes.daniel.ufabc.alertadematricula.matriculaapi.domain.dominio.Periodo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "DISCIPLINA")
public class DisciplinaDAO {

    @Id
    private String identificadorUFABC;

    @Column(name = "nomedisciplina")
    private String nomeDisciplina;

    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    @Column(name = "vagasdisponibilizadas")
    private int vagasDisponibilizadas;

    @Column(name = "vagasingressantes")
    private int vagasIngressantes;

    @Column(name = "vagasdisponiveis")
    private int vagasDisponiveis;

    private int creditos;

    private String codigo;

    private String campus;


    public Disciplina toDomain() {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(this.nomeDisciplina);
        disciplina.setPeriodo(periodo);
        disciplina.setVagasDisponibilizadas(this.vagasDisponibilizadas);
        disciplina.setVagasIngressantes(this.vagasIngressantes);
        disciplina.setVagasDisponiveis(this.vagasDisponiveis);
        disciplina.setCreditos(this.creditos);
        disciplina.setCodigo(this.codigo);
        disciplina.setCampus(this.campus);
        disciplina.setIdentificadorUFABC(this.identificadorUFABC);
        return disciplina;
    }
}