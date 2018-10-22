package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import java.util.Objects;
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
,@NamedQuery(name = "Professor.findByMat",query = "SELECT p FROM Professor p WHERE p.matriculaprofessor = :matriculaprofessor")
,@NamedQuery(name = "Professor.findBySenha",query = "SELECT p FROM Professor p WHERE p.matriculaprofessor = :senha")})

public class Professor implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idprofessor;
    private String nomeprofessor;
    private String matriculaprofessor;
    private String nomesocial;
    private String senha;
    private boolean coordenador;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idprofessor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.idprofessor, other.idprofessor)) {
            return false;
        }
        return true;
    }
    
    
    
    //Construtor
    public void Professor(){
        
    }
    
    //Getters, Setters, hash e equals

    public Integer getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(Integer idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getNomeprofessor() {
        return nomeprofessor;
    }

    public void setNomeprofessor(String nomeprofessor) {
        this.nomeprofessor = nomeprofessor;
    }

    public String getMatriculaprofessor() {
        return matriculaprofessor;
    }

    public void setMatriculaprofessor(String matriculaprofessor) {
        this.matriculaprofessor = matriculaprofessor;
    }

    public String getNomesocial() {
        return nomesocial;
    }

    public void setNomesocial(String nomesocial) {
        this.nomesocial = nomesocial;
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
