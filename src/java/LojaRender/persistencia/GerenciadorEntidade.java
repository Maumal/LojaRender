
package LojaRender.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GerenciadorEntidade {
    private static EntityManager gerenciarEntidade=null;
    public static EntityManager getGerenciador(){
        if((gerenciarEntidade==null)||(!gerenciarEntidade.isOpen())){
        gerenciarEntidade=Persistence.createEntityManagerFactory("lojaPU").createEntityManager();            
        }
        return gerenciarEntidade;
    }    
}
