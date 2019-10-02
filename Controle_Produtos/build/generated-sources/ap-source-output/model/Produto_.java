package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Categoria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-26T11:53:32")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Categoria> id_categoria;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Double> valorunitario;
    public static volatile SingularAttribute<Produto, Long> id;

}