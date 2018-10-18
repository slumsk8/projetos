package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProfessorBean {
    private int idProf;
    private String nomeProfessor;
    private String nomeSocial;
    private String matProfessor;
    private String senha;

    private boolean coord;
    
      public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getMatProfessor() {
        return matProfessor;
    }

    public void setMatProfessor(String matProfessor) {
        this.matProfessor = matProfessor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getCoord() {
        return coord;
    }

    public void setCoord(boolean coord) {
        this.coord = coord;
    }
    
    public void salvar(){
    }
}
