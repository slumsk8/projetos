package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author TiagoAragao
 */
@Entity
@Table (name = "professor")
@NamedQueries({@NamedQuery(name = "Professor.findAll",query = "SELECT p FROM Professor p")
,@NamedQuery(name = "Professor.findName",query = "SELECT p.nomeprofessor, p.matriculaprofessor FROM Professor p WHERE p.idprofessor = :idprofessor")        
})

public class Professor implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idprofessor")
    private Long idprofessor;
    
    @Column(length = 80)
    private String nomeprofessor;
    
    @Column(length = 80)
    private String nomesocial;
    
    @Column(length = 8, unique = true)
    private String matriculaprofessor;
    
    @Column(length = 8)
    private String senha;
    
    @Column
    private boolean coordenador;

    public Long getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(Long idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getNomeprofessor() {
        return nomeprofessor;
    }

    public void setNomeprofessor(String nomeprofessor) {
        this.nomeprofessor = nomeprofessor;
    }

    public String getNomesocial() {
        return nomesocial;
    }

    public void setNomesocial(String nomesocial) {
        this.nomesocial = nomesocial;
    }

    public String getMatriculaprofessor() {
        return matriculaprofessor;
    }

    public void setMatriculaprofessor(String matriculaprofessor) {
        this.matriculaprofessor = matriculaprofessor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }
    
    

}