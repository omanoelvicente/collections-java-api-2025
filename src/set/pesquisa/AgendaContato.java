package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {
    private Set<Contato> contatoSet;

    public AgendaContato() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                System.out.println(c);
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public Set<Contato> pesquisaPorNome(String nome) {
        Set<Contato> contatoAchado = new HashSet<>();
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (nome.equalsIgnoreCase(c.getNome())) {
                    contatoAchado.add(c);
                    break;
                }
            }
        } else {
            System.out.println("A lista está vazia");
        }
        return contatoAchado;
    }

    public void atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoParaAtualizar = null;
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (nome.equalsIgnoreCase(c.getNome())) {
                    c.setNumeroTelefone(novoNumero);
                    contatoParaAtualizar = c;
                    break;
                }
            }
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {

        AgendaContato agendaContato = new AgendaContato();

        agendaContato.adicionarContato("Maria", 999220022);
        agendaContato.adicionarContato("José", 999020023);
        agendaContato.adicionarContato("Claudia", 98820622);

        agendaContato.exibirContatos();

        System.out.println("Contato encontrado: " + agendaContato.pesquisaPorNome("Maria"));

        System.out.println("\n");
        agendaContato.atualizarNumeroContato("Maria", 999220054);
        agendaContato.exibirContatos();

    }
}
