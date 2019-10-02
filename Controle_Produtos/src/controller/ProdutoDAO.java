
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;

public class ProdutoDAO {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ProdutoDAO() {
        this.emf = Persistence.createEntityManagerFactory("ControlePU");
        this.em = emf.createEntityManager();
    }
    
    public int salvar(Produto p){
        try {
            Produto obj;
            if(p.getId() == null){
                obj = p;
            }else{
                obj = em.find(Produto.class, p.getId());
                obj.setNome(p.getNome());
                obj.setValorunitario(p.getValorunitario());
                obj.setId_categoria(p.getId_categoria());
            }
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return p.getId().intValue();
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public int remover(int id){
        try {
            Produto obj = em.find(Produto.class, new Long(id));
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            return obj.getId().intValue();
        } catch(Exception e){
            System.out.println("ERRO: "+ e.getMessage());
            return -1;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public List<Produto> listar(){
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
    
    public List<Produto> pesquisarPorNome(String nome){
        try{
            Query q = em.createQuery("SELECT p FROM Produto p WHERE p.nome LIKE :nome ORDER BY p.nome ");
            q.setParameter("nome", "%"+nome+"%");
            return q.getResultList();
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            em.close();
            emf.close();
        }
    }
    
    public List<Produto> pesquisarPorID(int ID){
       try{
            Query q = em.createQuery("SELECT p FROM Produto p WHERE p.id=:id ORDER BY p.nome ");
            q.setParameter("id",ID);
            return q.getResultList();
        }catch(Exception e){
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            em.close();
            emf.close();
        }
    }
}
