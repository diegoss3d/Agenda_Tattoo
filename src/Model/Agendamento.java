package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agendamento {
    
    private int id;
    private Cliente cliente;
    private int cliente_id;
    private Servico servico;
    private int servico_id;
    private float valor;
    private String data;
    private String observacao;
    
    
    
    // MÉTODO CONSTRUTOR
    
    public Agendamento(Cliente cliente, Servico servico, float valor, String data) {
        //this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }
    

    public Agendamento(int id, Cliente cliente, String descricao, float valor, String data, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
        
    }

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String observacao) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
        this.observacao = observacao;
    }

    public Agendamento(int id, String cliente, String servico, float valor, String data, String observacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    // MÉTODOS GETTERS E SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    
    
    /*public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }*/

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getServico_id() {
        return servico_id;
    }

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }
    
    
    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public String getHoraFormatada(){
        return new SimpleDateFormat("HH:mm").format(data);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    
}
