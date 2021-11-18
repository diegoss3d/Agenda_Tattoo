/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author DIEGO
 */
public class Main {
    
    public static void main(String[] args) {        
        String nome = "Diego";
        
        System.out.println(nome);        
        Servico barba = new Servico(1, "barba", 30);
        
        
        Cliente cliente = new Cliente(1234, "Paulo", "Rua da Paz, 250", "05891225");
        System.out.println(cliente.getNome());
        
        Usuario user = new Usuario(1234, "Caio", "picapau");
        System.out.println(user.getNome());
        
        
        Agendamento agendamento = new Agendamento(cliente, barba, 30, "24/09/2021 09:30");
        System.out.println(agendamento.getCliente());
        
        Servico servico = new Servico("corte simples", 15f);
        System.out.println(servico.getDescricao());
        
    }
    
}
