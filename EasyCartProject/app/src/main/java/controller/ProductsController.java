package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Products;
import util.ConnectionFactory;

public class ProductsController {
    
    public void save(Products products){
    
        String sql = "INSERT INTO products (id, "
                + "name, "
                + "price) "             
                + "VALUES (?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, products.getId());
            statement.setString(2, products.getName());
            statement.setFloat(3, products.getPrice());           
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar produto! ");
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void removeById(String id) {
        
        //Criação da query SQL.
        String sql = "DELETE FROM products WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            
            //Criação da conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            statement.setString(1, id);
            
            //Executando a query;
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o produto! " + ex.getMessage());
        } finally {
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
    
    public List<Products> getAll() {
        
        //Criação da query SQL.
        String sql = "SELECT * FROM products";
        
        //Declaracao da conexão e do statement.
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Variavel que armazena os valores retornados da query
        ResultSet resultSet = null;

        //Lista de tarefas que será devolvida quando a chamada do metodo acontecer
        List<Products> products = new ArrayList<>();
        
        try {
            
            //Criação da conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparação a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            //statement.setString(1, id);
            
            //Atribuindo o valor retornado da execução da query ao resultSet.
            resultSet = statement.executeQuery();
            
            /*Estrutura usada para sempre que tiver um proximo resultSet, 
            executar o bloco de comandos*/
            while (resultSet.next()) {
                
                //Instancia da nova tarefa.
                Products product = new Products();

                //Atribuindo os valores a nova tarefa.
                product.setId(resultSet.getString("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getFloat("price"));

                //Adicionando a nova tarefa a lista de tarefas.
                products.add(product);
  
            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao pegar todas as tarefas do projeto! " + ex.getMessage());
        } finally{
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement, resultSet);                    
        }
        
        return products;

    }
    
}
