package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Curso;
import dao.GenericDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable{
    private Curso curso = new Curso();
    private GenericDao<Curso> dao = new GenericDao<Curso>();
    private List<Curso> cursos = new ArrayList();
    
    @PostConstruct
    public void init(){
        cursos = dao.listar(curso);
        curso = new Curso();
    }
    
    
    //MÉTODOS PARA MANIPULAÇÃO NO BANCO DE DADOS
    //Esse método salvar serve para salvar as alterações também
    public String salvar(){
        if(curso.getIdcurso() == null || curso.getIdcurso() == 0){
            dao.salvar(curso);
            curso = new Curso();
        }else if(curso.getIdcurso() != null || curso.getIdcurso() > 0){
            dao.alterar(curso);
            curso = new Curso();
        }
            cursos = dao.listar(curso);
            return "cadcurso.xhtml?faces-redirect=true";
        }
    
    /*public String alterar(){
            cursos = dao.listar(curso);
            return "cadcurso.xhtml?faces-redirect=true";
        }*/
    
    //Importa os dados do banco para o formulário através da tabela onde as informações estão listadas
    public void prepararAlterar(Curso c){
        this.curso = c;
    }
    
    public String remover(Curso c){
        dao.deletar(c);
        cursos = dao.listar(curso);
        return "cadcurso.xhtml?faces-redirect=true";
    }
    
    public void listar(){
        cursos = dao.listar(curso);
    }
    
    //Método que inicia um novo objeto em determinados procedimentos
    public String novo(){
        curso = new Curso();
        return "cadcurso.xhtml?faces-redirect=true";
    }
   
    
    //GETTERS E SETTERS    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
}
