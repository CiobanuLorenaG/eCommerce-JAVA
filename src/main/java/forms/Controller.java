package forms;

import Entities.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@SessionScoped
@ManagedBean
public class Controller {
    private OrderEntity order;
    private List<OrderEntity> orders = new ArrayList<>();
    private List<ProductEntity> products = new ArrayList<>();
    private ProductEntity product;
    private DataModel<CategoryEntity> categoriesDataModel;
    EntityManager entityManager;

    public Controller() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        initOrders();
        initProducts();
    }

    private void initOrders() {
        this.orders = this.entityManager.createQuery("select o from OrderEntity o", OrderEntity.class).getResultList();
        this.order = this.orders.get(0);
    }

    private void initProducts() {
        this.products = entityManager.createQuery("select p from ProductEntity p", ProductEntity.class).getResultList();
    }


    public void back(ActionEvent event) {
        Integer indexOrders = this.orders.indexOf(this.order);
        if (indexOrders > 0) {
            this.order = this.orders.get(indexOrders - 1);
        } else
            this.order = this.orders.get(0);
    }

    public void next(ActionEvent event) {
        int index = this.orders.indexOf(this.order);
        if ((index + 1) < this.orders.size()) {
            this.order = this.orders.get(index + 1);
        } else
            this.order = this.orders.get(this.orders.size() - 1);
    }

    public void addCategory(ActionEvent event) {
        CategoryEntity newCategory = new CategoryEntity(null, null, this.products.get(0));
        newCategory.setOrderCategory(this.order);
        this.order.getCategories().add(newCategory);
    }

    public void deleteCategory(ActionEvent event) {
        CategoryEntity category = this.categoriesDataModel.getRowData();
        this.order.getCategories().remove(category);
    }

    public void addOrder(ActionEvent event) {
        this.order = new OrderEntity(100, new Date());
        this.orders.add(order);
    }

    public void saveOrder(ActionEvent event) {
        if (!entityManager.getTransaction().isActive())
            entityManager.getTransaction().begin();
        entityManager.merge(this.order);
        entityManager.getTransaction().commit();
    }

    public void abandonOrder(ActionEvent event) {
        this.order = this.orders.get(0);
        initOrders();
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

    public DataModel<CategoryEntity> getCategoriesDataModel() {
        this.categoriesDataModel = new ListDataModel<>(order.getCategories());
        return categoriesDataModel;
    }

    public void setCategoriesDataModel(DataModel<CategoryEntity> categoriesDataModel) {
        this.categoriesDataModel = categoriesDataModel;
    }

    public Integer getId() {
        return this.categoriesDataModel.getRowData().getProduct().getId();
    }

    public void setId(Integer id) {
        Integer index = this.products.indexOf(new ProductEntity(id, null, (String) null, null));
        ProductEntity product = this.products.get(index);
        this.categoriesDataModel.getRowData().setProduct(product);
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
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


}
