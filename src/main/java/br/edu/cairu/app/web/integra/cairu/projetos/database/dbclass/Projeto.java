package br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "projeto")
@NamedQueries(@NamedQuery(name = "Projeto.findAll",query = "SELECT proj FROM Projeto proj"))

public class Projeto implements Serializable{
    @Id
    private Integer idprojeto;
    private String nomeprojeto;
    private String descprojeto;
    private String ano;
    private String validacao_prof;
    private String validacao_coord;
    private Integer periodo;
    private Integer iddisciplina;
    private Integer idequipe;
    private Integer idcurso;
    private Integer idprof;
    private Integer idcoordenador;

    public void Projeto(){
        
    }
    
    public Integer getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(Integer idprojeto) {
        this.idprojeto = idprojeto;
    }

    public String getNomeprojeto() {
        return nomeprojeto;
    }

    public void setNomeprojeto(String nomeprojeto) {
        this.nomeprojeto = nomeprojeto;
    }

    public String getDescprojeto() {
        return descprojeto;
    }

    public void setDescprojeto(String descprojeto) {
        this.descprojeto = descprojeto;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValidacao_prof() {
        return validacao_prof;
    }

    public void setValidacao_prof(String validacao_prof) {
        this.validacao_prof = validacao_prof;
    }

    public String getValidacao_coord() {
        return validacao_coord;
    }

    public void setValidacao_coord(String validacao_coord) {
        this.validacao_coord = validacao_coord;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public Integer getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public Integer getIdprof() {
        return idprof;
    }

    public void setIdprof(Integer idprof) {
        this.idprof = idprof;
    }

    public Integer getIdcoordenador() {
        return idcoordenador;
    }

    public void setIdcoordenador(Integer idcoordenador) {
        this.idcoordenador = idcoordenador;
    }
    
    
}
