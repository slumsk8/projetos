package beans;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Curso;
import conecta.CursoConecta;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable{
    private Curso curso;
    private List<Curso> cursos;

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
    
    @PostConstruct
    public void init(){
        CursoConecta con = new CursoConecta();
        cursos = con.listar();
        curso = new Curso();
    }
    
    public String salvar(){
        CursoConecta con = new CursoConecta();
        curso.getNomecurso();
        con.salvar(curso);
        curso = new Curso();
        return "index";
    }
}
