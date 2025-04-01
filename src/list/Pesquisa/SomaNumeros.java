package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listnumero;

    public SomaNumeros() {
        this.listnumero = new ArrayList<>();
    }

    public void adicionaNumero(int numero) {
        listnumero.add(numero);
    }

    public int calcularSoma() {
        int soma = 0;
        for (int numero : listnumero) {
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero() {
        int maior = Integer.MIN_VALUE;
        if (!listnumero.isEmpty()) {
            for (int numero : listnumero) {
                if (maior < numero) {
                    maior = numero;
                }
            }
        }else {
            throw new RuntimeException("A lista está vazia");
        }

        return maior;
    }

    public int encontrarMenorNumero() {
        int menor = Integer.MAX_VALUE;
        if (!listnumero.isEmpty()) {
            for (int numero : listnumero) {
                if (numero <= menor) {
                    menor = numero;
                }
            }
        } else {
            throw new RuntimeException("A lista está vazia");
        }

        return menor;
    }

    public void exibirNumeros() {
        if (!listnumero.isEmpty()) {
            System.out.println(listnumero.toString());
        }
    }


    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionaNumero(1);
        somaNumeros.adicionaNumero(7);
        somaNumeros.adicionaNumero(3);
        somaNumeros.adicionaNumero(6);
        somaNumeros.adicionaNumero(0);
        somaNumeros.adicionaNumero(12);
        somaNumeros.adicionaNumero(-4);

        somaNumeros.exibirNumeros();
        System.out.println("A soma dos numeros é: " + somaNumeros.calcularSoma());
        System.out.println("O número maior é: " + somaNumeros.encontrarMaiorNumero());

        System.out.println("O menor número é: " + somaNumeros.encontrarMenorNumero());
    }
}
