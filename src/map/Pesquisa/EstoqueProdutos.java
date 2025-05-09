package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    public void adicionarProduto(Long codigo, String nome, int quantidade, double preco) {
        produtoMap.put(codigo, new Produto(nome,quantidade,preco));
    }

    public void exibirProdutos() {
        if (!produtoMap.isEmpty()) {
            System.out.println(produtoMap);
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if (!produtoMap.isEmpty()) {
            for (Produto p : produtoMap.values()) {
                valorTotal += p.getQuantidade() * p.getPreco();
            }
        }else {
            throw new RuntimeException("Nenhum produto cadastrado!");
        }
     return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        double maiorValor = Double.MIN_VALUE;
        Produto produtoMaisCaro = null;
        if (!produtoMap.isEmpty()) {
            for (Produto p : produtoMap.values()) {
                if (p.getPreco() > maiorValor) {
                    maiorValor = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        }else {
            System.out.println("Nenhum produto na lista");
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        double menorValor = Double.MAX_VALUE;
        Produto produtoMaisBarato = null;
        if (!produtoMap.isEmpty()) {
            for (Produto p : produtoMap.values()) {
                if (p.getPreco() < menorValor) {
                    menorValor = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }else {
            System.out.println("Nenhum produto na lista");
        }
        return produtoMaisBarato;
    }

   /* public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto maiorProdutoQuantidadeValorEstoque = null;
        double maiorProduto = Double.MIN_VALUE;
        if (!produtoMap.isEmpty()) {
            for (Produto p : produtoMap.values()) {
                double produtoEmEstoque = p.getQuantidade() * p.getPreco();
                if (produtoEmEstoque > maiorProduto) {
                    maiorProduto = produtoEmEstoque;
                    maiorProdutoQuantidadeValorEstoque = p;
                }
            }
        }else {
            throw new RuntimeException("Nenhum produto encontrado!");
        }
        return maiorProdutoQuantidadeValorEstoque;
    }*/

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto maiorProdutoQuantidadeValorEstoque = null;
        double maiorProduto = Double.MIN_VALUE;
        if (!produtoMap.isEmpty()) {
            for (Map.Entry<Long, Produto> entry : produtoMap.entrySet()) {
                double produtoEmEstoque = entry.getValue().getQuantidade() * entry.getValue().getPreco();
                if (produtoEmEstoque > maiorProduto) {
                    maiorProduto = produtoEmEstoque;
                    maiorProdutoQuantidadeValorEstoque = entry.getValue();
                }
            }
        }else {
            throw new RuntimeException("Nenhum produto encontrado!");
        }
        return maiorProdutoQuantidadeValorEstoque;
    }



    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        estoque.adicionarProduto(1L, "Smart Watch", 2, 140.0);
        estoque.adicionarProduto(2L, "Smart TV", 1, 850.0);
        estoque.adicionarProduto(3L, "Hard Disk", 3, 250.0);
        estoque.adicionarProduto(4L, "Tablet", 2, 650.0);
        estoque.adicionarProduto(5L, "Laptop", 1, 2400.0);

        estoque.exibirProdutos();
        System.out.println("Valor total dos produtos em estoque: " + estoque.calcularValorTotalEstoque());

        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());

        System.out.println("Maior produto em estoque: " + estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }
}
