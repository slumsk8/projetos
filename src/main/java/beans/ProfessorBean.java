package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Professor;
import conecta.ProfessorConecta;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@SessionScoped
public class ProfessorBean{
    private Professor professor = new Professor();
    private ProfessorConecta con = new ProfessorConecta();
    private List<Professor> professores = new ArrayList<>();
    
    
   @PostConstruct
    public void init(){
        ProfessorConecta con = new ProfessorConecta();
        professores = con.listar();
        professor = new Professor();
    }
   public String salvar(){ 
        if(professor.getIdprofessor() == null || professor.getIdprofessor() == 0){
            professor.getNomeprofessor();
            professor.getNomesocial();
            professor.getMatriculaprofessor();
            professor.getSenha();
            professor.isCoordenador();
            con.salvar(professor);
        }
        if (professor.getIdprofessor() != null || professor.getIdprofessor() > 0){
            con.alterar(professor);
            professores = con.listar();
        }
       return "/cadprofessor.xhtml?faces-redirect=true";
    }
    
    public String editar(Professor p){    
       this.professor = p;
       return "/altprofessor.xhtml?faces-redirect=true";
       //"altprofessor.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        professor = new Professor();
        return "/cadprofessor.xhtml?faces-redirect=true";
    }
        
    public String excluir(Professor professor){
        con.remover(professor);
        professores = con.listar();
       return "/cadprofessor.xhtml?faces-redirect=true";
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ProfessorConecta getCon() {
        return con;
    }

    public void setCon(ProfessorConecta con) {
        this.con = con;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    
}
