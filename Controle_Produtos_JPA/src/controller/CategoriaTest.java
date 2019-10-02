package controller;

import model.Categoria;

public class CategoriaTest {

    public static void main(String[] args) {
        
        //INSERIR
        new CategoriaDAO().salvar(new Categoria(null,"Livros"));
        new CategoriaDAO().salvar(new Categoria(null,"Esportes"));
        
        //ATUALIZAR
        Categoria cat = new CategoriaDAO().get(1); // pesquisar
        System.out.println(cat);
        cat.setNome("Eletrônicos");
        new CategoriaDAO().salvar(cat);
        
        cat = new CategoriaDAO().get(1); // pesquisar
        System.out.println(cat);
        
        // LISTAR TODAS as Categorias
        for(Categoria c : new CategoriaDAO().listar()){
            System.out.println(c);
        }
        
        System.out.println("TOTAL = " + new CategoriaDAO().contar() );
        
    }
    
}
