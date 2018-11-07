package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Professor;
import dao.GenericDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ProfessorBean{
    private Professor professor = new Professor();
    private GenericDao<Professor> dao = new GenericDao<Professor>();
    private List<Professor> professores = new ArrayList<>();
    private List<Professor> busca = new ArrayList<>();
    
    
    @PostConstruct
    public void init(){
        professores = dao.listar(professor);
        professor = new Professor();
    }
    
    
    
    //MÉTODOS PARA MANIPULAÇÃO NO BANCO DE DADOS
    //Esse método salvar serve para salvar as alterações também
    public String salvar(){
        if(professor.getIdprofessor() == null || professor.getIdprofessor() == 0){
            dao.salvar(professor);
            novo();
        }else if(professor.getIdprofessor()!= null || professor.getIdprofessor() > 0){
            dao.alterar(professor);
            novo();
        }
            professores = dao.listar(professor);
            return "cadprofessor.xhtml?faces-redirect=true";
       }            
    
    /*public String alterar(){
            professores = dao.listar(professor);
            return "cadprofessor.xhtml?faces-redirect=true";
       }*/
    
    //Importa os dados do banco para o formulário através da tabela onde as informações estão listadas
    public void prepararAlterar(Professor p){
        this.professor = p;
    }
    
    public String remover(Professor p){
        dao.deletar(p);
        professores = dao.listar(professor);
        return "cadprofessor.xhtml?faces-redirect=true";
    }
    
    public void listar(){
       professores = dao.listar(professor);
    }
    
    //Método que inicia um novo objeto em determinados procedimentos
    public String novo(){
        professor = new Professor();
        return "cadprofessor.xhtml?faces-redirect=true";
    }
    
    public void buscarPorNome(){
        busca = dao.listarPorNome(professor);
    }

    
    
    //GETTERS E SETTERS
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Professor> getBusca() {
        return busca;
    }

    public void setBusca(List<Professor> busca) {
        this.busca = busca;
    }
}
