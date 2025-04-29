package set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunoSet.isEmpty()) {
            for (Aluno a : alunoSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                }
            }
            alunoSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("Aluno ");
        }
        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada");
        }
    }

    public void exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if (!alunoSet.isEmpty()) {
            System.out.println(alunosPorNome);
        }else {
            System.out.println("A lista está vazia");
        }
    }

    public void exibirAlunosPorNota() {
        Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorNota());
        if (!alunoSet.isEmpty()) {
            alunoPorNota.addAll(alunoSet);
            System.out.println(alunoPorNota);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public void exibirAlunos() {
        if (!alunoSet.isEmpty()) {
            System.out.println(alunoSet);
        }else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        gerenciador.adicionarAluno("Maria", 1L, 8.0);
        gerenciador.adicionarAluno("Joao", 2L, 7.5);
        gerenciador.adicionarAluno("Carlos", 3L, 8.5);
        gerenciador.adicionarAluno("Roberta", 4L, 6.0);

        gerenciador.exibirAlunos();
        gerenciador.exibirAlunosPorNome();
        gerenciador.removerAluno(3L);
        gerenciador.exibirAlunos();
        gerenciador.exibirAlunosPorNota();
    }
}
