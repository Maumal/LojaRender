
package LojaRender.controle;

import LojaRender.entidade.Cliente;
import LojaRender.negocio.ClienteBO;
import LojaRender.persistencia.ClienteDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author Maurício
 */
@ManagedBean(name = "cadastroClienteControle")
@SessionScoped

public class cadastroClienteControle implements Serializable{
    private Cliente cliente;
    public String iniciarTela(){
        this.cliente =new Cliente();
        return "cadastroCliente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void salvar(){
        FacesContext faceContext = FacesContext.getCurrentInstance();
      //  faceContext.addMessage(null, new FacesMessage("Controle"));  
        try {
            ClienteBO clienteBO=new ClienteBO();
            clienteBO.validar(this.cliente);
            faceContext.addMessage(null, new FacesMessage("Cliente Cadastrado com Sucesso!"));
            this.cliente=new Cliente();         
        } catch (Exception e) {
            FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),e.getMessage());
            faceContext.addMessage(null, facesMessage);
        }
        
        
        
    }
    
    
public void EspacoBranco(FacesContext contexto, UIComponent componente, Object valor){
        String valString = (String) valor;
        if(valString.trim().equals("")){
            ((UIInput) componente).setValid(false);
            
            String mensagem = componente.getAttributes().get("label") + ":Favor preencher campo corretamente";
            
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
            
            contexto.addMessage(componente.getClientId(contexto), facesMessage);
            
            
          }
    }

public List getlistaClientes(){
    ClienteDAO clienteDAO=new ClienteDAO();
    return clienteDAO.buscarCliente();
}  
}
