package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> conjuntoPalavras;

    public ConjuntoPalavrasUnicas() {
        this.conjuntoPalavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        conjuntoPalavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if(!conjuntoPalavras.isEmpty()) {
            if (conjuntoPalavras.contains(palavra)) {
                conjuntoPalavras.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto");
            }
        }else {
            System.out.println("O conjunto está vazio");
        }
    }

    public boolean verificaPalavra(String palavra) {
            return conjuntoPalavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!conjuntoPalavras.isEmpty()) {
            System.out.println(conjuntoPalavras.toString());
        }else {
            System.out.println("O conjunto está vazio");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavrasUnicas = new ConjuntoPalavrasUnicas();

//        palavrasUnicas.adicionarPalavra("Clima");
//        palavrasUnicas.adicionarPalavra("Padrão");
//        palavrasUnicas.adicionarPalavra("Singular");
//        palavrasUnicas.adicionarPalavra("Padrão");
//
//        palavrasUnicas.exibirPalavrasUnicas();
        palavrasUnicas.removerPalavra("Clima");
        palavrasUnicas.exibirPalavrasUnicas();

//        palavrasUnicas.removerPalavra("Olá");
        palavrasUnicas.exibirPalavrasUnicas();
    }
}
