
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteDAO {
    
    private Connection con; //realizar uma conexão com o SGBD
    private PreparedStatement cmd; //enviar instruções SQL para o SGBD

    public ClienteDAO() {
        this.con = Conexao.conectar();
    }
    
    public int inserir(Cliente cli){
        try {
            String SQL = "INSERT INTO tb_cliente (id,nome,telefone,email,estado) VALUES (?,?,?,?,?)";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, cli.getNome());
            cmd.setString(2, cli.getTelefone());
            cmd.setString(3, cli.getEmail());
            cmd.setBoolean(4, cli.isEstado());
            
            //executa os comandos no banco de dados
            if(cmd.executeUpdate() > 0){
                //descobrir o ID que foi gerado
                ResultSet rs = cmd.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1); //retornar o ID
                }else{
                    return -1; //ID não foi gerado
                }
            }else{
                return -1;
            }
            
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public int atualizar(Cliente cli){
        try {
            String SQL = "UPDATE tb_cliente SET id = ?,nome = ?,telefone = ?,email = ?,estado = ? WHERE id = ?";
            cmd.setInt(1, cli.getId());
            cmd.setString(2, cli.getNome());
            cmd.setString(3, cli.getTelefone());
            cmd.setString(4, cli.getEmail());
            cmd.setBoolean(5, cli.isEstado());
            cmd.setInt(6, cli.getId());
            
            return (cmd.executeUpdate() > 0) ? cli.getId() : -1;
          
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public int remover(Cliente cli){
        try {
            String SQL = "DELETE FROM tb_cliente WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, cli.getId());
            
            return (cmd.executeUpdate() > 0) ? cli.getId() : -1;
            
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Cliente> listar(){
        try{
            String SQL = "SELECT * FROM tb_cliente ORDER BY id";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Cliente (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean(5)                            
                   )
                );
            }
            return lista;
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Cliente> pesquisarPorNome(String nome){
        try{
            String SQL = "SELECT * FROM tb_cliente WHERE nome ILIKE ? ORDER BY nome";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //concatena o nome informado à instrução SQL
            cmd.setString(1,"%"+nome+"%");
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Cliente (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean(5) 
                   )
                );
            }
            return lista;
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Cliente> pesquisarPorID(int ID){
        try{
            String SQL = "SELECT * FROM tb_Cliente WHERE id=?";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //concatena o ID informado à instrução SQL
            cmd.setInt(1,ID);
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Cliente> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Cliente (
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getBoolean(5)
                   )
                );
            }
            return lista;
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            Conexao.desconectar(con);
        }
    }
}
