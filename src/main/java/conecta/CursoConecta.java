package conecta;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Curso;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CursoConecta {
    private Session sessao;
    private Transaction trans;
    
    public void salvar(Curso c){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.persist(c);
        trans.commit();
        sessao.close();
    }
    
   public List<Curso> listar(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Curso> curso = sessao.getNamedQuery("Curso.findAll").list();
        sessao.close();
        return curso;
    }
   
       public void alterar(Curso c){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(c);
        trans.commit();
        sessao.close();
    }
   public void remover(Curso c){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(c);
        trans.commit();
        sessao.close();
   }
    
}
