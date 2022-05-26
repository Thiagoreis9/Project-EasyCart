package easycart;

public class Funcionario extends Usuario{
    
    private String login;
    private String senha;

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Funcionario() {
        
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void cadastrarProduto(){
        
    }
    
    public void modificarProduto(){
        
    }
    
    public void excluirProduto(){
        
    }
    
    public void logar(){
        
    }
}
