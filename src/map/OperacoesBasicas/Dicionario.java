package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }else {
            System.out.println("O dicionário está vazio");
        }
    }

    public void exibirPalavras() {
        if (!dicionarioMap.isEmpty()) {
            System.out.println(dicionarioMap);
        }else {
            System.out.println("O dicionário está vazio");
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        String palavraParaBusca = null;
        if (!dicionarioMap.isEmpty()) {
            palavraParaBusca = dicionarioMap.get(palavra);
        }else {
            throw new RuntimeException("O dicionário está vazio");
        }
        if (palavraParaBusca == null) {
            System.out.println("Nenhuma palavra encontrada!");
        }
        return palavraParaBusca;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Paradoxo", "Contradicao ou oposicao");
        dicionario.adicionarPalavra("Genérico", "Relativo ao gênero, conceito que abarca em si multiplicidade de coisas");
        dicionario.adicionarPalavra("Mexer", "Misturar ou movimentar o interior");
        dicionario.adicionarPalavra("Caos", "Confusão geral dos elementos da matária");

        dicionario.exibirPalavras();
        System.out.println("Significado: " + dicionario.pesquisarPorPalavra("Caos"));

        dicionario.removerPalavra("Genérico");
        dicionario.exibirPalavras();
    }
}
