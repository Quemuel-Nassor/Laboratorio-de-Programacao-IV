package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Categoria;

public class CategoriaDAO {
    
    private final EntityManager em;
    
    public CategoriaDAO(){
        this.em = Persistence.createEntityManagerFactory("ControlePU")
                .createEntityManager();
    }
    
    public long salvar(Categoria cat){
        try {
            em.getTransaction().begin();
            em.merge(cat);  //inserir ou atualizar
            em.getTransaction().commit();
            return cat.getId();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            this.em.close();
        }
    }
    
    public Categoria get(long id){
        try {
            em.getTransaction().begin();
            Categoria cat = em.find(Categoria.class, id);
            em.getTransaction().commit();
            return cat;
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            this.em.close();
        }
    }
    
    public List<Categoria> listar(){
        try {
            return em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }finally{
            this.em.close();
        }
    }
    
    public long contar(){
        try {
             Query q = em.createQuery("SELECT COUNT(c) FROM Categoria c");
             return (long)q.getSingleResult();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return -1;
        }finally{
            this.em.close();
        }
    }    
    
}
