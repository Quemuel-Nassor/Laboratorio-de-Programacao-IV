
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/*modelo de dados utilizado para realizar o mapeamento
entre SGBD e a aplicação.

Tabela tb_categoria <==> Classe Categoria
*/
@Entity
@Table(name="tb_categoria")
public class Categoria implements Serializable{
    
    @Id
    @SequenceGenerator(name="tb_categoria_id_seq",
            sequenceName = "tb_categoria_id_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "tb_categoria_id_seq")
    
    @Column(name="id")
    //Mapeamento dos CAMPOS da tabela em ATRIBUTOS da classe
    private Long id;
    
    @Column(name="nome",length = 40)
    private String nome;

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
