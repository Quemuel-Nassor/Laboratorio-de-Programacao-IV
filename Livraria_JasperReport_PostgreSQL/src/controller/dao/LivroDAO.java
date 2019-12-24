/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class LivroDAO {

    private Connection con;
    private PreparedStatement cmd;

    public int inserir(Livro livro) {
        try {
            String sql = "";
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

    public int atualizar(Livro livro) {
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

    public int deletar(Livro livro) {
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

    public List<Livro> listar() {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
            ResultSet rs = cmd.executeQuery();
            List<Livro> lista = new ArrayList();

            //TODO
            return lista;
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        } finally {
            Conexao.Desconectar(con);
        }
    }

    public List<Livro> pesquisarPorNome(String nome) {
        try {
            String sql = "";
            con = Conexao.Conectar();
            cmd = con.prepareStatement(sql);
            cmd.setString(1, "%" + nome + "%");
            ResultSet rs = cmd.executeQuery();
            List<Livro> lista = new ArrayList();

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
