package list.OperacoesBasicas;

import javax.management.RuntimeMBeanException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();

        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemsParaRemover.add(i);
                }
                itemList.removeAll(itemsParaRemover);
            }
        }else {
            System.out.println("A lista está vazia");
        }

    }

    public double calcularValorTotal() {
        double totalCompra = 0.0;
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                totalCompra += (i.getQuantidade() * i.getPreco());
            }
            return totalCompra;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirItens() {
        if(!itemList.isEmpty()) {
            System.out.println(itemList);
        } else {
            System.out.println("A lista está vazia");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();


//        carrinhoDeCompras.exibirItens();
//        carrinhoDeCompras.adicionarItem("TV",100, 1 );
//        carrinhoDeCompras.adicionarItem("Smart phone", 1500, 2);
//        carrinhoDeCompras.exibirItens();
//        System.out.println(carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("TV");
        carrinhoDeCompras.exibirItens();
        System.out.println("Valor total da compra: " + carrinhoDeCompras.calcularValorTotal());
    }
}
