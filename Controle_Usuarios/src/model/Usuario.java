package model;

/**
 *
 * @author quemu
 */
public class Usuario {
    
    private int id;
    private String login;
    private String senha;
    private String resposta;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(int id, String login, String senha, String resposta, boolean estado) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.resposta = resposta;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }    
    
}
