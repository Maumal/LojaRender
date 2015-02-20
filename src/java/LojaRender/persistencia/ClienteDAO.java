package LojaRender.persistencia;

import LojaRender.entidade.Cliente;
import javax.persistence.EntityManager;

public class ClienteDAO {
    public void persistir(Cliente cliente){
        EntityManager persistir=GerenciadorEntidade.getGerenciador();
        persistir.getTransaction().begin();
        persistir.persist(cliente);
        persistir.getTransaction().commit();    
    }   
    
    public Cliente pesquisarCpf(String cpf){
    EntityManager ent = GerenciadorEntidade.getGerenciador();
    Cliente cliente = ent.find(Cliente.class, cpf);
    return cliente; 
}
    
}
