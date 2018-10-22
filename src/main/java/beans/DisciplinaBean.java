package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Disciplina;
import conecta.DisciplinaConecta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class DisciplinaBean implements Serializable{
    private Disciplina disciplina;
    private List<Disciplina> disciplinas;

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
    
    @PostConstruct
    public void init(){
        DisciplinaConecta con = new DisciplinaConecta();
        disciplinas = con.listar();
        disciplina = new Disciplina();
    }
    
    public String salvar(){
        DisciplinaConecta con = new DisciplinaConecta();
        disciplina.getNomedisciplina();
        con.salvar(disciplina);
        disciplina = new Disciplina();
        return "index";
    }
    
}
