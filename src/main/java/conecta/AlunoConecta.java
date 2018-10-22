package conecta;

import br.edu.cairu.app.web.integra.cairu.projetos.database.dbclass.Aluno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AlunoConecta {
    private Session sessao;
    private Transaction trans;
    
    public void salvar(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.persist(a);
        trans.commit();
        sessao.close();
    }

     public List<Aluno> listar(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Aluno> aluno = sessao.getNamedQuery("Aluno.findAll").list();
        sessao.close();
        return aluno;
    }
     
    public void alterar(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(a);
        trans.commit();
        sessao.close();
    }
   public void remover(Aluno a){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(a);
        trans.commit();
        sessao.close();
   }
    
}
