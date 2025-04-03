package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> pessoasList;

    public OrdenacaoPessoas() {
        this.pessoasList = new ArrayList<>();
    }

    public void  adicionarPessoas(String nome, int idade, double altura) {
        pessoasList.add(new Pessoa(nome, idade, altura));
    }

   public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoasList);
       Collections.sort(pessoasPorIdade);
       return pessoasPorIdade;
   }

   public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> pessoaPorAltura = new ArrayList<>(pessoasList);
        Collections.sort(pessoaPorAltura, new ComparatorPorAltura());
        return pessoaPorAltura;
   }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();
    ordenacaoPessoas.adicionarPessoas("Maria", 20, 1.56);
    ordenacaoPessoas.adicionarPessoas("João", 30, 1.80);
    ordenacaoPessoas.adicionarPessoas("José", 25, 1.80);
    ordenacaoPessoas.adicionarPessoas("Claudia", 17, 1.56);

        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }
}
