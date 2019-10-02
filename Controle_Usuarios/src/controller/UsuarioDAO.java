
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {
    
    private Connection con; //realizar uma conexão com o SGBD
    private PreparedStatement cmd; //enviar instruções SQL para o SGBD

    public UsuarioDAO() {
        this.con = Conexao.conectar();
    }
    
    public int inserir(Usuario u){
        try {
            String SQL = "INSERT INTO tb_usuario (id,login,senha,resposta,estado) VALUES (?,?,MD5(?),?,?)";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, u.getLogin());
            cmd.setString(2, u.getSenha());
            cmd.setString(3, u.getResposta());
            cmd.setBoolean(4, u.isEstado());
            
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
    
    public int atualizar(Usuario u){
        try {
            String SQL = "UPDATE tb_usuario SET id = ?,login = ?,senha = MD5(?),resposta = ?,estado = ? WHERE id = ?";
            cmd.setInt(1, u.getId());
            cmd.setString(2, u.getLogin());
            cmd.setString(3, u.getSenha());
            cmd.setString(4, u.getResposta());
            cmd.setBoolean(5, u.isEstado());
            cmd.setInt(6, u.getId());
            
            return (cmd.executeUpdate() > 0) ? u.getId() : -1;
          
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public int remover(Usuario u){
        try {
            String SQL = "DELETE FROM tb_usuario WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, u.getId());
            
            return (cmd.executeUpdate() > 0) ? u.getId() : -1;
            
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    public List<Usuario> listar(){
        try{
            String SQL = "SELECT * FROM tb_usuario ORDER BY id";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Usuario> lista = new ArrayList<>();
            while(rs.next()){
                System.out.println(rs.toString());
                lista.add(
                    new Usuario (
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("resposta"),
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
    
    public List<Usuario> pesquisarPorNome(String login){
        try{
            String SQL = "SELECT * FROM tb_usuario WHERE login ILIKE ? ORDER BY login";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //concatena o nome informado à instrução SQL
            cmd.setString(1,"%"+login+"%");
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Usuario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Usuario (
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("resposta"),
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
    
    public List<Usuario> pesquisarPorID(int ID){
        try{
            String SQL = "SELECT * FROM tb_usuario WHERE id=?";
            
            //Analisar sintaticamente a instrução SQL
            cmd = con.prepareStatement(SQL);
            
            //concatena o ID informado à instrução SQL
            cmd.setInt(1,ID);
            
            //executar a instrução
            ResultSet rs = cmd.executeQuery();
            
            List<Usuario> lista = new ArrayList<>();
            while(rs.next()){
                lista.add(
                    new Usuario (
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("resposta"),
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
