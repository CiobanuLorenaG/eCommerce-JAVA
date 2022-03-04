package Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "public", catalog = "shoppingCart")
public class SupplierEntity {
    @Id
    private Integer id;
    @Column(name = "company")
    private String company;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> productsSupplier = new ArrayList<>();

    public SupplierEntity() {}

    public SupplierEntity(Integer id, String company, Date createdAt) {
        this.id = id;
        this.company = company;
        this.createdAt = createdAt;
    }

    public SupplierEntity(Integer id, String company) {
        this.id=id;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<ProductEntity> getProductsSupplier() {
        return productsSupplier;
    }

    public void setProductsSupplier(List<ProductEntity> productsSupplier) {
        this.productsSupplier = productsSupplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierEntity that = (SupplierEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SupplierEntity{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
