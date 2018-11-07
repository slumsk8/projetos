package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Aluno;
import dao.GenericDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AlunoBean {
    private Aluno aluno = new Aluno();
    private GenericDao<Aluno> dao = new GenericDao<Aluno>();
    private List<Aluno> alunos = new ArrayList();

    @PostConstruct
    public void init(){
        alunos = dao.listar(aluno);
        aluno = new Aluno();
    }
    
    
    //MÉTODOS PARA MANIPULAÇÃO NO BANCO DE DADOS
    //Esse método salvar serve para salvar as alterações também
    public String salvar(){
            if(aluno.getIdaluno() == null || aluno.getIdaluno() == 0){
            dao.salvar(aluno);
            novo();
        }else if(aluno.getIdaluno()!= null || aluno.getIdaluno() > 0){
            dao.alterar(aluno);
            novo();
        }
            alunos = dao.listar(aluno);
            return "cadaluno.xhtml?faces-redirect=true";
       }            
    
    /*public String alterar(){
            dao.alterar(aluno);
            aluno = new Aluno();
            alunos = dao.listar(aluno);
            return "cadaluno.xhtml?faces-redirect=true";
    }*/
    
    //Importa os dados do banco para o formulário através da tabela onde as informações estão listadas
    public void prepararAlterar(Aluno a){
        this.aluno = a;
    }
    
    public String remover(Aluno a){
        dao.deletar(a);
        alunos = dao.listar(aluno);
        return "cadaluno.xhtml?faces-redirect=true";
    }
    
    public void listar(){
        alunos = dao.listar(aluno);
    }
    
    //Método que inicia um novo objeto em determinados procedimentos
    public String novo(){
        aluno = new Aluno();
        return "cadaluno.xhtml?faces-redirect=true";
    }
   
    
    //GETTERS E SETTERS    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
   
       
   
   
   
   
}
