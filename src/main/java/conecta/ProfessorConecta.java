package conecta;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Professor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ProfessorConecta {
    private Session sessao;
    private Transaction trans;
    
    public void salvar(Professor p){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.persist(p);
        trans.commit();
        sessao.close();
    }
    
   public List<Professor> listar(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Professor> prof = sessao.getNamedQuery("Professor.findAll").list();
        sessao.close();
        return prof;
    }
   
   public void alterar(Professor p){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(p);
        trans.commit();
        sessao.close();
    }
   public void remover(Professor p){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(p);
        trans.commit();
        sessao.close();
   }
   
}
