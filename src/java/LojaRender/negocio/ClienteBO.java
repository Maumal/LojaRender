/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LojaRender.negocio;

import LojaRender.entidade.Cliente;
import LojaRender.persistencia.ClienteDAO;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 *
 * @author Maurício
 */
public class ClienteBO {
    public void validar (Cliente cliente){
        ClienteDAO clienteDAO= new ClienteDAO();
        try {
            CPFValidator cpfValidator = new CPFValidator(true);
            cpfValidator.assertValid(cliente.getCpf());
        } catch (InvalidStateException e) {
            throw new RuntimeException("CPF Inválido!");
        }
        Cliente exixteCliente=clienteDAO.pesquisarCpf(cliente.getCpf());
        if (exixteCliente!=null && !exixteCliente.equals(cliente)) {
            throw new RuntimeException("Cpf Já Cadastrado!");
            
        }
        clienteDAO.persistir(cliente);
    }
    
}
