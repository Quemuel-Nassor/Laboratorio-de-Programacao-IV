package model;

/**
 *
 * @author quemu
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private boolean estado;

    public Cliente() {
    }

    public Cliente(int id, String nome, String telefone, String email, boolean estado) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
