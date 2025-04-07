package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidado() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaREmover = null;
        for (Convidado c : convidadoSet) {
            if (c.getCodigoConvite() == codigoConvite) {
                convidadoParaREmover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaREmover);
    }

        public int contarConvidado() {
            return convidadoSet.size();
        }

        public void exibirConvidado() {
            System.out.println(convidadoSet);
        }

    public static void main(String[] args) {
        ConjuntoConvidado conjuntoConvidado = new ConjuntoConvidado();

        System.out.println("EXistem " + conjuntoConvidado.contarConvidado() + " convidado(s) dentro do set de convidados");

        conjuntoConvidado.adicionarConvidado("Carlos", 1234);
        conjuntoConvidado.adicionarConvidado("Claudia", 1235);
        conjuntoConvidado.adicionarConvidado("Maria", 1235);
        conjuntoConvidado.adicionarConvidado("José", 1236);

        conjuntoConvidado.exibirConvidado();

        System.out.println("EXistem " + conjuntoConvidado.contarConvidado() + " convidado(s) dentro do set de convidados");

        conjuntoConvidado.removerConvidadoPorCodigoConvite(1234);
        System.out.println("EXistem " + conjuntoConvidado.contarConvidado() + " convidado(s) dentro do set de convidados");
        conjuntoConvidado.exibirConvidado();
    }
}
