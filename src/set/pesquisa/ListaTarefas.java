package set.pesquisa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    Set<Tarefa> listaDeTarefas;

    public ListaTarefas() {
        this.listaDeTarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        listaDeTarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover= null;
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa t : listaDeTarefas) {
               if (t.getDescricao().equalsIgnoreCase(descricao)) {
                   tarefaParaRemover = t;
               }
            }
            listaDeTarefas.remove(tarefaParaRemover);
        }else {
            System.out.println("A lista de tarefas está vazia");
        }
        if (tarefaParaRemover == null) {
            System.out.println("Nenhuma tarefa encontrada!");
        }
    }

    public void exibirTarefas() {
        if (!listaDeTarefas.isEmpty()) {
            System.out.println(listaDeTarefas);
        }else {
            System.out.println("A lista de tarefas está vazia");
        }
    }

    public int contarTarefas() {

          return listaDeTarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!listaDeTarefas.isEmpty()) {
            for (Tarefa t : listaDeTarefas) {
                if (t.isTarefaConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }else {System.out.println("A lista de tarefas está vazia");}
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendemtes = new HashSet<>();
        if(!listaDeTarefas.isEmpty()) {
            for (Tarefa t : listaDeTarefas) {
                if (!t.isTarefaConcluida()) {
                    tarefasPendemtes.add(t);
                }
            }
        }else {System.out.println("A lista de tarefas está vazia");}
        return tarefasPendemtes;
    }
    public void marcarTarefaConcluida(String descricao) {
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa t : listaDeTarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setTarefaConcluida(true);
                }
            }
        }else {
            System.out.println("A lista de tarefas está vazia");
        }
    }
    public void marcarTarefaPendente(String descricao) {
        Tarefa marcarComoPendente = null;
        if (!listaDeTarefas.isEmpty()) {
            for (Tarefa t : listaDeTarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    marcarComoPendente = t;
                }
            }
            if ((marcarComoPendente != null) && marcarComoPendente.isTarefaConcluida()) {
                marcarComoPendente.setTarefaConcluida(false);
            }else {
                System.out.println("Tarefa não encontrada");
            }
        }else {
            System.out.println("A lista de tarefas está vazia");
        }
    }

    public void limparListaTarefas() {
        if (!listaDeTarefas.isEmpty()) {
            listaDeTarefas.removeAll(listaDeTarefas);
        }else {
            System.out.println("A lista de tarefas está vazia");
        }
    }


    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Enviar relatório");
        listaTarefas.adicionarTarefa("Marcar reunião");
        listaTarefas.adicionarTarefa("Reservar sala");
        listaTarefas.adicionarTarefa("Comprar suprimentos");
        listaTarefas.adicionarTarefa("Enviar email");

        listaTarefas.exibirTarefas();
        listaTarefas.removerTarefa("Reservar sala");

        listaTarefas.exibirTarefas();

        System.out.println("Número de tarefas: " + listaTarefas.contarTarefas());

        listaTarefas.marcarTarefaConcluida("Enviar relatório");
        listaTarefas.marcarTarefaConcluida("Enviar email");

        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());
        listaTarefas.marcarTarefaPendente("Enviar email");
        System.out.println("\n");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.println(listaTarefas.obterTarefasPendentes());

//        listaTarefas.limparListaTarefas();
//        listaTarefas.exibirTarefas();
        listaTarefas.marcarTarefaPendente("Reservar auditório");
    }
}
