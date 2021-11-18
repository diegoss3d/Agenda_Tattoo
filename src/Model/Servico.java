package Model;

public class Servico {
    
    private int id;
    private String descricao;
    private float valor;
    
    
    // MÉTODO CONSTRUTOR
    public Servico(int id, String descricao, float valor){
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public Servico(String descricao, float valor){
        this.descricao = descricao;
        this.valor = valor;
    }
    
    
    // MÉTODOS GETTERS E SETTERS    
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public float getValor(){
        return valor;
    }
    public void setValor(float valor){
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public String toString(){
        return getDescricao();
    }
    
    
}
