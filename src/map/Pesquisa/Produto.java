package map.Pesquisa;

public class Produto {
    private String nome;
    private Integer quantidade;
    private double preco;

    public Produto(String nome, Integer quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", quantidade=" + quantidade +
               ", preco=" + preco +
               '}';
    }
}
