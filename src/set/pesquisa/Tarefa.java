package set.pesquisa;

public class Tarefa {
    private String descricao;
    private boolean tarefaConcluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.tarefaConcluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTarefaConcluida(boolean tarefaConcluida) {
        this.tarefaConcluida = tarefaConcluida;
    }

    public boolean isTarefaConcluida() {
        return tarefaConcluida;
    }

    @Override
    public String toString() {
        return
               "Descricao: " + descricao  +
               " Tarefa Concluída: " +  tarefaConcluida
               ;
    }
}
