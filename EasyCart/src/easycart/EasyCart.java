package easycart;
import java.util.Scanner;

public class EasyCart {
    
    public static void main(String[] args) {
               
        String codBarras;
        Boolean repetir = true;
        Scanner sc = new Scanner(System.in);
        
        Produto vetor[]  = new Produto[4];

        float valorTotal = 0.00f;

        Produto p1 = new Produto("004954", "Fone Redragon Hero  ", 469.00f);
        Produto p2 = new Produto("004435", "Fone Redragon ZeusX ", 599.00f);
        Produto p3 = new Produto("003169", "Fone Redragon Lamia2 ", 499.00f);
        Produto p4 = new Produto("001366", "Fone Redragon Minos ", 449.00f);
        
        vetor[0] = p1;
        vetor[1] = p2;
        vetor[2] = p3;
        vetor[3] = p4;
        
        System.out.println("--------------------------------------------");
        System.out.println("--------------SISTEMA EASYCART--------------");
        System.out.println("--------------------------------------------");
        System.out.println("CASO DESEJA SAIR DIGITE ('SAIR')");
        
        
        while(repetir){
                        
            System.out.print("COD DE BARRAS: ");
            codBarras = sc.nextLine();

            for (int i = 0; i < 4; i++) {

                if(vetor[i].getId().equals(codBarras)){
                    
                    float valorParcial = 0;
                    System.out.print(vetor[i].getDescricao() + " " + vetor[i].getValor() + " Quantidade: ");
                    int quantidade = sc.nextInt();
                    valorParcial += vetor[i].getValor() * quantidade;
                    System.out.println("valor parcial: " + valorParcial);
                    valorTotal += vetor[i].getValor() * quantidade;
                    System.out.println("--------------------------------------------");
                    sc.nextLine();
                    
                }
                if(codBarras.equals("SAIR") || codBarras.equals("sair")){
                                        
                    repetir = false;
                    break;
                    
                }
                
            }

        }
        
        System.out.println("O valor total de suas compras é: " + valorTotal);
       
        sc.close();
        
        
       
        
     
                
        
    }
}
