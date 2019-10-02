
package controller;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Categoria;
//import model.Produto;

/*
    DAO = Data Access Object
    Objeto de acesso a dados utilizado para concentrar todas 
    as operações relativas a uma tabela do SGBD
*/

public class CategoriaDAO {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    
    public CategoriaDAO(){
        this.emf = Persistence.createEntityManagerFactory("ControlePU");
        this.em = emf.createEntityManager();
    }
    
    public int salvar(Categoria p){
        try {
            Categoria obj;
            if(p.getId() == null){
                obj = p;
            }else{
                obj = em.find(Categoria.class, p.getId());
                obj.setNome(p.getNome());
            }
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return (int)p.getId();
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public List<Categoria> listar(){
        try{
            Query q = em.createQuery("SELECT c FROM Categoria c ORDER BY c.nome");
            return q.getResultList();
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public Categoria pesquisarPorId(int id){
        try{
            return em.find(Categoria.class, new Long(id));
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            em.close();
            emf.close();
        }
    }
    
//    public List<Categoria> pesquisarPorNome(String nome){
//        try{
//            String SQL = "SELECT * FROM tb_categoria WHERE nome ILIKE ? ORDER BY nome";
//            
//            //Analisar sintaticamente a instrução SQL
//            cmd = con.prepareStatement(SQL);
//            cmd.setString(1,"%"+nome+"%");
//            
//            //executar a instrução
//            ResultSet rs = cmd.executeQuery();
//            
//            List<Categoria> lista = new ArrayList<>();
//            while(rs.next()){
//                lista.add(
//                    new Categoria (
//                        rs.getInt("id"),
//                        rs.getString("nome")
//                   )
//                );
//            }
//            return null;
//        }catch(Exception e){
//            System.out.println("ERRO: " + e.getMessage());
//            return null;
//        }finally{
//            Conexao.desconectar(con);
//        }
//        
//    }
}
