package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemPalavrasMap.isEmpty()) {
            contagemPalavrasMap.remove(palavra);

        }else {
            System.out.println("Nenhuma palavra encontrada!");
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(contagemPalavrasMap);
    }

    public String encotrarPalavraMaisFrequente() {
        String palavraFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraFrequente = entry.getKey();
            }
        }
        return palavraFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Java", 2);
        contagemPalavras.adicionarPalavra("Ruby", 1);
        contagemPalavras.adicionarPalavra("Kotlin", 6);
        contagemPalavras.adicionarPalavra("Phyton", 8);
        contagemPalavras.adicionarPalavra("JavaScript", 5);

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("Ruby");
        contagemPalavras.exibirContagemPalavras();

        System.out.println("Palavra frequente: " + contagemPalavras.encotrarPalavraMaisFrequente());
    }
}
