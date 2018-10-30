package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class GenericDao<Entidade>{
        //Abrindo sessão no hibernate para manipular o banco de dados
        private Session sessao;  
        private Transaction trans;
        private Class<Entidade> entidade;
    

    public void salvar(Entidade e ){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.persist(e);
        trans.commit();
        sessao.close();
    }

    public void alterar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.update(e);
        trans.commit();
        sessao.close();
    }

    public void deletar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        sessao.delete(e);
        trans.commit();
        sessao.close();
    }

    public List<Entidade> listar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> mostrar = sessao.getNamedQuery("" + e.getClass().getSimpleName() + ".findAll").list();
        sessao.close();
        return mostrar;
    }


    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }

    public Class<Entidade> getEntidade() {
        return entidade;
    }

    public void setEntidade(Class<Entidade> entidade) {
        this.entidade = entidade;
    }
}
