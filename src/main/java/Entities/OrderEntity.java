package Entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "shoppingCart")
public class OrderEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = AddressEntity.class)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @Column(name = "delivery")
    private String delivery;
    @Column(name = "payment")
    private String payment;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> products = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private PromotionValue promotion;
    @OneToMany(mappedBy = "orderCategory")
    private List<CategoryEntity> categories = new ArrayList<>();
    private Double totalOrder;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, Date createdAt) {
        this.id = id;
        this.createdAt = createdAt;
    }

    public OrderEntity(Integer id, List<ProductEntity> products, String delivery, String payment, Date createdAt) {
        this.id = id;
        this.products = products;
        this.delivery = delivery;
        this.payment = payment;
        this.createdAt = createdAt;
    }

    public OrderEntity(Integer id, UserEntity user, AddressEntity address) {
        this.id = id;
        this.user = user;
        this.address = address;
    }

    public OrderEntity(Integer id, UserEntity user, AddressEntity address, String delivery, String payment, Date createdAt, List<ProductEntity> products) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.delivery = delivery;
        this.payment=payment;
        this.createdAt = createdAt;
        this.products = products;
    }

    public OrderEntity(Integer id, UserEntity user, AddressEntity address, String delivery, String payment, Date createdAt, PromotionValue promotion) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.delivery = delivery;
        this.payment = payment;
        this.createdAt = createdAt;
        this.promotion = promotion;
    }

    public OrderEntity(Integer id, UserEntity user, AddressEntity address, String delivery, Date createdAt) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.delivery = delivery;
        this.createdAt = createdAt;
    }

    public OrderEntity(Integer id, UserEntity user, AddressEntity address, String delivery) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.delivery = delivery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String payment) {
        this.delivery = payment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Double getTotalOrder() {
        if (products.isEmpty()) {
            return null;
        }
        Double value = 0.0;
        for (ProductEntity product : products) {
            totalOrder += product.getPrice() * product.getQuantity();
//            value = value+ product.getValueProduct();
        }
        return totalOrder;
    }

    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public PromotionValue getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionValue promotion) {
        this.promotion = promotion;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity order = (OrderEntity) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "  User=" + user +
                ", Address=" + address +
                ", Delivery='" + delivery + '\'' +
                ", Payment=" + payment +
                ", createdAt=" + createdAt +
                ", promotion=" + promotion +
                '}';
    }
}
