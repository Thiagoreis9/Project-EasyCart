package easycart;
import java.util.ArrayList;

public class Carrinho {
    
    private ArrayList<Item> compras;

    public Carrinho() {
        this.compras = new ArrayList<Item>();
    }

    public void adicionarItem(Item item){
        this.compras.add(item);
    }
    
    public void removerItem(Item item){
        this.compras.remove(item);
    }
    
    public void imprimirCompra(){
        
        float valorTotal = 0;
        
        for(Item itemCompra: compras){

            Produto p = itemCompra.getProduto();
            int qtd = itemCompra.getQuantidade();
            
            System.out.print(p.getDescricao());
            System.out.print(" R$" + p.getValor());
            System.out.print(" " + qtd);
            System.out.println("und " + p.getValor() * qtd + "R$");
            
            valorTotal += p.getValor() * qtd;
            
            System.out.println("--------------------------------------------");
            
        }
            
            System.out.println("VALOR TOTAL: R$" + valorTotal);
    }
}