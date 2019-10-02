
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

   
    private static final String SERVIDOR_URL = "127.0.0.1";
    private static final String SERVIDOR_PORTA = "5432";
    private static final String SERVIDOR_USUARIO = "postgres";
    private static final String SERVIDOR_SENHA = "password";
    private static final String SERVIDOR_BANCO = "bd_cadastroclientes";
    
    public static Connection conectar(){
        try{
            return DriverManager.getConnection(
            "jdbc:postgresql://" + SERVIDOR_URL + ":" + SERVIDOR_PORTA + 
                    "/" + SERVIDOR_BANCO, SERVIDOR_USUARIO, SERVIDOR_SENHA);
        }catch (Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return null;
        }
    }
    
    public static void desconectar(Connection con){
        try {
            con.close();
        }catch (Exception e){
            
        }
    }
    
    public static void main(String[] args) {
        //teste de conexão com o banco
        Connection con = conectar();
        if(con != null){
            System.out.println("Conexão realizada com sucesso");
        }
    }
}
