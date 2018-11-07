package dao;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;


public class GenericDao<Entidade>{
        //Abrindo sessão no hibernate para manipular o banco de dados
        private Session sessao;  
        private Class<Entidade> entidade;
    

    public void salvar(Entidade e ){
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.persist(e);
        sessao.getTransaction().commit();
    }

    public void alterar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.update(e);
        sessao.getTransaction().commit();
    }

    public void deletar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.delete(e);
        sessao.getTransaction().commit();
    }

    public List<Entidade> listar(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> mostrar = sessao.getNamedQuery("" + e.getClass().getSimpleName() + ".findAll").list();
        return mostrar;
    }
    
    public List<Entidade> listarPorNome(Entidade e){
        sessao = HibernateUtil.getSessionFactory().openSession();
        List<Entidade> listarnomes = sessao.getNamedQuery("" + e.getClass().getSimpleName() + ".findName").list();
        return listarnomes;
    }
    
    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Class<Entidade> getEntidade() {
        return entidade;
    }

    public void setEntidade(Class<Entidade> entidade) {
        this.entidade = entidade;
    }
}
