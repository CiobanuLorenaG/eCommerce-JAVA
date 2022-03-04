package Entities;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "shoppingCart")
public class UserEntity {
    @Id
//    @GeneratedValue(generator = "users_ids")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> ordersUser = new ArrayList<>();
    @ManyToMany(mappedBy = "favoriteUsers", cascade = CascadeType.ALL)
    private List<ProductEntity> favorites = new ArrayList<>();
    @ManyToMany(mappedBy = "shoppingCartUsers",cascade = CascadeType.ALL)
    private List<ProductEntity> shoppingCart = new ArrayList<>();

    public UserEntity(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserEntity(Integer id, String firstName, String lastName, String nickname, String username, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.username = username;
        this.email = email;
    }

    public UserEntity(Integer id, String firstName, String lastName, String nickname, String username, String email, String password, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public UserEntity(Integer id, String firstName, String lastName, String nickname, String username, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public List<OrderEntity> getOrdersUser() {
        return ordersUser;
    }

    public void setOrdersUser(List<OrderEntity> ordersUser) {
        this.ordersUser = ordersUser;
    }

    public List<ProductEntity> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<ProductEntity> favorites) {
        this.favorites = favorites;
    }

    public void addFavorite(ProductEntity product) {
        favorites.add(product);
    }

    public List<ProductEntity> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ProductEntity> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToShoppingCart(ProductEntity product) {
        shoppingCart.add(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
                " FirstName='" + firstName + '\'' +
                ",LastName='" + lastName + '\'' +
                ", Email='" + email ;
    }
}
