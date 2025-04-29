package set.pesquisa;

import java.util.Objects;

public class Contato {
    private String nome;
    private int numeroTelefone;

    public Contato(String nome, int numeroTelefone) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return getNumeroTelefone() == contato.getNumeroTelefone();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNumeroTelefone());
    }

    @Override
    public String toString() {
        return
               "Nome='" + nome + '\'' +
               "| Telefone=" + numeroTelefone;
    }
}
