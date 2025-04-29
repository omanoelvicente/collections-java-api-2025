package set.Ordenacao;

import java.util.*;

public class Produto implements Comparable<Produto> {
    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, long codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
               "nome='" + nome + '\'' +
               ", codigo=" + codigo +
               ", preco=" + preco +
               ", quantidade=" + quantidade +
               '}';
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return getCodigo() == produto.getCodigo();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodigo());
    }

    public static class CadastroProduto {
        private Set<Produto> produtoSet;

        public CadastroProduto() {
            this.produtoSet = new HashSet<>();
        }

        public void adicionarProduto(String nome, long codigo, double preco, int quantidade) {
            produtoSet.add(new Produto(nome, codigo, preco, quantidade));
        }

        public Set<Produto> exibirProdutoPorNome() {
            Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
            if (!produtoSet.isEmpty()) {
                return produtoPorNome;
            } else {
                throw new RuntimeException("Nenhum produto cadastrado!");
            }
        }

        public Set<Produto> exibirProdutoPorPreco() {
            Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
            if (!produtoSet.isEmpty()) {
                produtoPorPreco.addAll(produtoSet);
                return produtoPorPreco;
            }else {
                throw new RuntimeException("Nenhum produto cadastrado!");
            }
        }

        public static void main(String[] args) {
            CadastroProduto cadastro = new CadastroProduto();

            cadastro.adicionarProduto("Smartphone", 010230, 1500.0, 1);
            cadastro.adicionarProduto("Laptop", 010231, 2600.0, 4);
            cadastro.adicionarProduto("Mouse", 010232, 100.0, 2);

            System.out.println(cadastro.exibirProdutoPorNome());
            System.out.println(cadastro.exibirProdutoPorPreco());
        }
    }
}
class ComparatorPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}