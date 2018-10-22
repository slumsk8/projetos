package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Aluno;
import conecta.AlunoConecta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AlunoBean implements Serializable{
    private Aluno aluno = new Aluno();
    private AlunoConecta con = new AlunoConecta();
    private List<Aluno> alunos = new ArrayList<>();

   @PostConstruct
   public void init(){
       AlunoConecta con = new AlunoConecta();
       alunos = con.listar();
       aluno = new Aluno();
   }
    
   public String salvar(){ 
        if(aluno.getIdaluno() == null || aluno.getIdaluno() == 0){
            aluno.getNomealuno();
            aluno.getNomesocial();
            aluno.getMataluno();
            aluno.getSenha();
            con.salvar(aluno);
        }
        if (aluno.getIdaluno()!= null || aluno.getIdaluno()> 0){
            con.alterar(aluno);
            alunos = con.listar();
        }
       return "/cadaluno.xhtml?faces-redirect=true";
    }
    
    public String editar(Aluno a){    
       this.aluno = a;
       return "/altaluno.xhtml?faces-redirect=true";
       //"altprofessor.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        aluno = new Aluno();
        return "/cadaluno.xhtml?faces-redirect=true";
    }
        
    public String excluir(Aluno aluno){
        con.remover(aluno);
        alunos = con.listar();
       return "/cadaluno.xhtml?faces-redirect=true";
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AlunoConecta getCon() {
        return con;
    }

    public void setCon(AlunoConecta con) {
        this.con = con;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
