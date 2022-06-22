package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Item;
import model.Products;

public class ProductsTableModel extends AbstractTableModel{
    
    String[] columns = {"Quantidade", "Nome", "Preço unit.", "Preço Total", "Excluir"};
    List<Products> products = new ArrayList();
    //List<Item> items = new ArrayList();
    
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        
        return columns[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                
                return "2";
            
            case 1:
                
                return products.get(rowIndex).getName();
                
            case 2:
                
                return products.get(rowIndex).getPrice();
                
            case 3:

                return products.get(rowIndex).getPrice()*2;
            
            case 4:

                return "EXCLUIR";
                
                
            default:
                return "Dados não encontrados";
        }
        
        
    }

    public String[] getColumns() {
        return columns;
    }

//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
    
    public void set(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
