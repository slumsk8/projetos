package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Disciplina;
import dao.GenericDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DisciplinaBean implements Serializable{
    private Disciplina disciplina = new Disciplina();
    private GenericDao<Disciplina> dao = new GenericDao<Disciplina>();
    private List<Disciplina> disciplinas = new ArrayList();
    
    @PostConstruct
    public void init(){
        disciplinas = dao.listar(disciplina);
        disciplina = new Disciplina();
    }
    
    
    //MÉTODOS PARA MANIPULAÇÃO NO BANCO DE DADOS
    //Esse método salvar serve para salvar as alterações também
    public String salvar(){
        if(disciplina.getIddisciplina() == null || disciplina.getIddisciplina() == 0){
            dao.salvar(disciplina);
            disciplina = new Disciplina();
        }else if(disciplina.getIddisciplina() != null || disciplina.getIddisciplina() > 0){
            dao.alterar(disciplina);
            disciplina = new Disciplina();
        }
            disciplinas = dao.listar(disciplina);
            return "caddisciplina.xhtml?faces-redirect=true";
        }
    
    /*public String alterar(){
            disciplinas = dao.listar(disciplina);
            return "caddisciplina.xhtml?faces-redirect=true";
        }*/
    
    //Importa os dados do banco para o formulário através da tabela onde as informações estão listadas
    public void prepararAlterar(Disciplina d){
        this.disciplina = d;
    }
    
    public String remover(Disciplina d){
        dao.deletar(d);
        disciplinas = dao.listar(disciplina);
        return "cadsiciplina.xhtml?faces-redirect=true";
    }
    
    public void listar(){
        disciplinas = dao.listar(disciplina);
    }
    
    //Método que inicia um novo objeto em determinados procedimentos
    public String novo(){
        disciplina = new Disciplina();
        return "caddisciplina.xhtml?faces-redirect=true";
    }
   
    
    //GETTERS E SETTERS    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
