package LojaRender.persistencia;

import LojaRender.entidade.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    public List buscarCliente(){
        EntityManager buscar= GerenciadorEntidade.getGerenciador();
        Query query=buscar.createNamedQuery("Cliente.findAll");
        return query.getResultList();
    }
}
