package Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "promotions", schema = "public", catalog = "shoppingCart")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Promotion {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    protected ProductEntity product;


    public abstract Double getValueDiscount(Double quantity);

    public Promotion() {
    }

    public Promotion(Integer id, ProductEntity product) {
        this.id=id;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return Objects.equals(id, promotion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
