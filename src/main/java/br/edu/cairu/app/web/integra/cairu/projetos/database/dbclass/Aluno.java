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
@Table(name = "aluno")
@NamedQueries({@NamedQuery(name = "Aluno.findAll",query = "SELECT a FROM Aluno a")
,@NamedQuery(name = "Aluno.findByMat",query = "SELECT a FROM Aluno a WHERE a.mataluno = :mataluno")
,@NamedQuery(name = "Aluno.findBySenha",query = "SELECT a FROM Aluno a WHERE a.senha = :senha")})

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idaluno")
    private Long idaluno;
    
    @Column (unique = true, length = 8)
    private String mataluno;
    
    @Column (unique = true, length = 80)
    private String nomealuno;
    
    @Column (unique = true, length = 80)
    private String nomesocial;
    
    @Column (length = 8)
    private String senha;

    public Long getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Long idaluno) {
        this.idaluno = idaluno;
    }

    public String getMataluno() {
        return mataluno;
    }

    public void setMataluno(String mataluno) {
        this.mataluno = mataluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
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
    
    
    
 
}
