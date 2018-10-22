package conecta;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Disciplina;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;



public class DisciplinaConecta {
    private Session sessao;
    private Transaction trans;
    
    public void salvar(Disciplina d){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.persist(d);
        trans.commit();
        sessao.close();
    }
    
   public List<Disciplina> listar(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Disciplina> disc = sessao.getNamedQuery("Disciplina.findAll").list();
        sessao.close();
        return disc;
    }
   
       public void alterar(Disciplina d){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(d);
        trans.commit();
        sessao.close();
    }
   public void remover(Disciplina d){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(d);
        trans.commit();
        sessao.close();
   }
}
