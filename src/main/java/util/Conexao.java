package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {
    private static final String UNIT_NAME = "PROJETOINTEGRADOR";
    
    private EntityManagerFactory fabrica = null;
    private EntityManager gerenciador = null;
    
    public EntityManager getGerenciador(){
        if (fabrica == null){
            fabrica = Persistence.createEntityManagerFactory(UNIT_NAME);    
        }
        if (gerenciador == null){
            gerenciador = fabrica.createEntityManager();
        }
        return gerenciador;
    }
}
