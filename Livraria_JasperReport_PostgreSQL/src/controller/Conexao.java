package controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private static final String DATABASE = "livraria";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost/" + DATABASE;
    private static final String USR = "postgres";
    private static final String PWD = "password";

    public static Connection Conectar() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USR, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    public static void Desconectar(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public static void createDatabase() {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/", USR, PWD);

            //Criação do Banco de Dados
            Statement cmd = con.createStatement();
            cmd.executeUpdate("DROP DATABASE IF EXISTS livraria;");
            cmd.executeUpdate("CREATE DATABASE livraria;");
            System.out.println("Database criado com sucesso.");
            con.close();

            //Criação das Tabelas
            String SQL = new Conexao().loadSQLFile("livraria_postgres.sql");

            con = DriverManager.getConnection(URL, USR, PWD);
            cmd = con.createStatement();
            cmd.executeUpdate(SQL);
            System.out.println("Tabelas criadas com sucesso.");
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public String loadSQLFile(String file) {
        try {
            URL myURL = getClass().getProtectionDomain().getCodeSource().getLocation();
            java.net.URI myURI = null;
            myURI = myURL.toURI();
            String PATH = Paths.get(myURI).toFile().toString() + "\\controller\\" + file;

            //Load SQL File
            byte[] encoded = Files.readAllBytes(Paths.get(PATH));
            return new String(encoded, "UTF-8");
        } catch (URISyntaxException | IOException e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        createDatabase();
    }
}
