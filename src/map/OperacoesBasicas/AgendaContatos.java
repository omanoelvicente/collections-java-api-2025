package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer numero) {
        agendaContatoMap.put(nome, numero);
    }

    public void removerContato(String nome) {
        if (!agendaContatoMap.isEmpty()) {
            agendaContatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatoMap.isEmpty()) {
            numeroPorNome = agendaContatoMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Maria", 999004000);
        agendaContatos.adicionarContato("Joana", 988005650);
        agendaContatos.adicionarContato("Paulo", 977009098);
        agendaContatos.adicionarContato("Camila", 99008987);

        agendaContatos.exibirContatos();
        agendaContatos.removerContato("Camila");
        agendaContatos.exibirContatos();

        System.out.println("Número: " + agendaContatos.pesquisarPorNome("Joana"));
    }
}
