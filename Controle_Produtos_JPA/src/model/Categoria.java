package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_categoria")
@SequenceGenerator(
    name="tb_categoria_id_seq",
    sequenceName = "tb_categoria_id_seq",
    initialValue = 1,
    allocationSize = 1
        
)
public class Categoria implements Serializable{
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "tb_categoria_id_seq"
    )
    @Column(name="id")
    private Long id;
    
    @Column(name="nome", length = 60)
    private String nome;

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
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
        return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
    }
    
}
