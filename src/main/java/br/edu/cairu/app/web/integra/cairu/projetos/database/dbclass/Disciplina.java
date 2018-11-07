package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table (name = "disciplina")
@NamedQueries(@NamedQuery(name = "Disciplina.findAll",query = "SELECT d FROM Disciplina d"))

public class Disciplina implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "iddisciplina")
    private Long iddisciplina;
    
    @Column(unique = true, length = 80)
    private String nomedisciplina;

    public Long getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Long iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getNomedisciplina() {
        return nomedisciplina;
    }

    public void setNomedisciplina(String nomedisciplina) {
        this.nomedisciplina = nomedisciplina;
    }
    
    
    
}
