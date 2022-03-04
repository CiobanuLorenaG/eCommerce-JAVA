package forms;

import Entities.*;

import java.util.*;

import javax.faces.bean.*;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SessionScoped
@ManagedBean
public class ControllerOrders {
    private OrderEntity order;
    private AddressEntity address;
    private UserEntity user;
    private PromotionValue promotion;
    private List<AddressEntity> addresses = new ArrayList<>();
    private List<UserEntity> users = new ArrayList<>();
    private List<PromotionValue> promotions = new ArrayList<>();
    private List<OrderEntity> orders = new ArrayList<>();
    EntityManager entityManager;

    public ControllerOrders() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        initOrders();
        initAddresses();
        initUsers();
        initPromotions();
    }

    private void initOrders() {
//        List<OrderEntity> orderEntityList = entityManager.createQuery("select o from OrderEntity o", OrderEntity.class).getResultList();
//        orders.addAll(orderEntityList);
//        this.orders.sort(Comparator.comparing(OrderEntity::getId));
//        this.order = orders.get(0);

        this.orders = entityManager.createQuery("select o from OrderEntity o", OrderEntity.class).getResultList();
        if (!orders.isEmpty()) {
            this.order = this.orders.get(0);
        }
    }

    private void initAddresses() {
        this.addresses = entityManager.createQuery("select a from AddressEntity a", AddressEntity.class).getResultList();
        if (!addresses.isEmpty()) {
            this.address = this.addresses.get(0);
        }
    }

    private void initUsers() {
        List<UserEntity> userEntityList = entityManager.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
        users.addAll(userEntityList);
        this.users.sort(Comparator.comparing(UserEntity::getId));
        this.user = users.get(0);
    }

    private void initPromotions() {
        this.promotions = entityManager.createQuery("select p from PromotionValue p", PromotionValue.class).getResultList();
        if (!promotions.isEmpty()) {
            this.promotion = this.promotions.get(0);
        }
    }

    public void previousOrder(ActionEvent event) {
        Integer indexOrders = this.orders.indexOf(this.order);
        if (indexOrders > 0) {
            this.order = this.orders.get(indexOrders - 1);
        } else {
            this.order = this.orders.get(0);
        }
    }

    public void previousAddress(ActionEvent event) {
        Integer indexAddress = this.addresses.indexOf(this.address);
        if (indexAddress > 0) {
            this.address = this.addresses.get(indexAddress - 1);
        } else {
            this.address = this.addresses.get(0);
        }
    }

    public void previousUser(ActionEvent event) {
        Integer indexUser = this.users.indexOf(this.user);
        if (indexUser > 0) {
            this.user = this.users.get(indexUser - 1);
        } else {
            this.user = this.users.get(0);
        }
    }

    public void previousPromotion(ActionEvent event) {
        Integer indexPromotion = this.promotions.indexOf(this.promotion);
        if (indexPromotion > 0) {
            this.promotion = this.promotions.get(indexPromotion - 1);
        } else {
            this.promotion = this.promotions.get(0);
        }
    }

    public void nextOrder(ActionEvent event) {
        Integer indexOrders = this.orders.indexOf(this.order);
        if ((indexOrders + 1) < this.orders.size()) {
            this.order = this.orders.get(indexOrders + 1);
        } else {
            this.order = this.orders.get(this.orders.size() - 1);
        }
    }

    public void nextAddress(ActionEvent event) {
        Integer indexAddress = this.addresses.indexOf(this.address);
        if ((indexAddress + 1) < this.addresses.size()) {
            this.address = this.addresses.get(indexAddress + 1);
        } else {
            this.address = this.addresses.get(this.addresses.size() - 1);
        }
    }

    public void nextUser(ActionEvent event) {
        Integer indexUser = this.users.indexOf(this.user);
        if ((indexUser + 1) < this.users.size()) {
            this.user = this.users.get(indexUser + 1);
        } else {
            this.user = this.users.get(this.users.size() - 1);
        }
    }

    public void nextPromotion(ActionEvent event) {
        Integer indexPromotion = this.promotions.indexOf(this.promotion);
        if ((indexPromotion + 1) < this.promotions.size()) {
            this.promotion = this.promotions.get(indexPromotion + 1);
        } else {
            this.promotion = this.promotions.get(this.promotions.size() - 1);
        }
    }

    // CRUD
    public void addOrder(ActionEvent event) {
        this.order = new OrderEntity();
        this.order.setId(111);
        this.order.setCreatedAt(new Date());
        this.order.setDelivery("Local");
        this.order.setPayment("Transfer Bank");
        this.orders.add(order);
    }

    public void addAddress(ActionEvent event) {
        this.address = new AddressEntity();
        this.address.setId(11);
        this.address.setCountry("Romania");
        this.address.setCounty("Iasi");
        this.address.setCity("Iasi");
        this.address.setStreet("Stefan Petru II");
        this.address.setNumber(111);
        this.address.setCreatedAt(new Date());
        this.addresses.add(address);
    }

    public void addPromotion(ActionEvent event) {
        this.promotion = new PromotionValue();
        this.promotion.setId(234);
        this.promotion.setDiscount(10.0);
        this.promotion.setLimitValue(1.0);
        this.promotions.add(promotion);
    }

    public void addUser(ActionEvent event) {
        this.user = new UserEntity();
        this.user.setId(200);
        this.user.setCreatedAt(new Date());
        this.user.setFirstName("Dragos");
        this.user.setLastName("Pantiru");
        this.user.setUsername("DragosP");
        this.user.setNickname("Dragos");
        this.user.setPassword("hudhbsfsh");
        this.user.setEmail("dragos.pantiru@gmail.com");
        this.users.add(user);
    }


    public void saveOrder(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.order);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void saveAddress(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.address);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void saveUser(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.user);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void savePromotion(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.promotion);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }


    public void deleteOrder(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.order)) {
            entityManager.remove(this.order);
            entityManager.getTransaction().commit();
            this.orders.remove(this.order);
            this.order = this.orders.get(0);
        }
    }

    public void deleteAddress(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.address)) {
            entityManager.remove(this.address);
            entityManager.getTransaction().commit();
            this.addresses.remove(this.address);
            this.address = this.addresses.get(0);
        }
    }

    public void deleteUser(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.user)) {
            entityManager.remove(this.user);
            entityManager.getTransaction().commit();
            this.users.remove(this.user);
            this.user = this.users.get(0);
        }
    }

    public void deletePromotion(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.promotion)) {
            entityManager.remove(this.promotion);
            entityManager.getTransaction().commit();
            this.promotions.remove(this.promotion);
            this.promotion = this.promotions.get(0);
        }
    }

    public void abandonOrder(ActionEvent event) {
        entityManager.clear();
        initOrders();
    }

    public void abandonAddress(ActionEvent event) {
        entityManager.clear();
        initAddresses();
    }

    public void abandonUser(ActionEvent event) {
        entityManager.clear();
        initUsers();
    }

    public void abandonPromotion(ActionEvent event) {
        entityManager.clear();
        initPromotions();
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(Integer id) {
        Integer index = this.orders.indexOf(new OrderEntity(id, null, null, null, null, null, (PromotionValue) null));
        this.order = this.orders.get(index);
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(Integer id) {
        Integer index = this.addresses.indexOf(new AddressEntity(id, null, null, null, null, null));
        this.address = this.addresses.get(index);
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(Integer id) {
        Integer index = this.users.indexOf(new UserEntity(id, null, null, null, null, null));
        this.user = this.users.get(index);
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer id) {
        Integer index = this.promotions.indexOf(new PromotionValue(id, null));
        this.promotion = promotion;
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public List<PromotionValue> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionValue> promotions) {
        this.promotions = promotions;
    }
}
