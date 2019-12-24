package controller.dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Editora;


public class EditoraDAO {
    
    private Connection con;
    private PreparedStatement cmd;
    
    public int inserir(Editora edit) {
        try {
            String sql = ")";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //TODO
            
            return -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public int atualizar(Editora edit) {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
            
            //TODO
            
           
            return -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }

    }

    public int deletar(Editora edit) {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
           
            //TODO
            
            return -1;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Editora> listar() {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Editora> lista = new ArrayList();
            
             //TODO
            
            return lista;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Editora> pesquisarPorNome(String nome) {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            ResultSet rs = cmd.executeQuery();
            List<Editora>  lista = new ArrayList();
            
            //TODO
            
            return lista;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }    
    
}
