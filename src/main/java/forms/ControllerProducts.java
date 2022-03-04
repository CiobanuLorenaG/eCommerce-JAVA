package forms;

import Entities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class ControllerProducts {
    private ProductEntity product;
    private List<ProductEntity> products = new ArrayList<>();
    private CategoryEntity category;
    private List<CategoryEntity> categories = new ArrayList<>();
    EntityManager entityManager;

    public ControllerProducts() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        initProducts();
        initCategories();
    }

    private void initProducts() {
        this.products = entityManager.createQuery("Select p from ProductEntity p", ProductEntity.class).getResultList();
        if (!products.isEmpty()) {
            this.product = this.products.get(0);
        }
    }

    private void initCategories() {
        this.categories = entityManager.createQuery("select c from CategoryEntity c", CategoryEntity.class).getResultList();
        if (!categories.isEmpty()) {
            this.category = this.categories.get(0);
        }
    }

    public void previousProduct(ActionEvent event) {
        Integer index = this.products.indexOf(this.product);
        if ((index + 1) < this.products.size()) {
            this.product = this.products.get(index + 1);
        } else {
            this.product = this.products.get(this.products.size() - 1);
        }
    }

    public void previousCategory(ActionEvent event) {
        Integer index = this.categories.indexOf(this.category);
        if ((index + 1) < this.categories.size()) {
            this.category = this.categories.get(index + 1);
        } else {
            this.category = this.categories.get(this.categories.size() - 1);
        }
    }

    public void nextProduct(ActionEvent event) {
        Integer index = this.products.indexOf(this.product);
        if (index < this.products.size() - 1) {
            this.product = this.products.get(index + 1);
        } else {
            this.product = this.products.get(this.products.size() - 1);
        }
    }

    public void nextCategory(ActionEvent event) {
        Integer index = this.categories.indexOf(this.category);
        if (index < this.categories.size() - 1) {
            this.category = this.categories.get(index + 1);
        } else {
            this.category = this.categories.get(this.categories.size() - 1);
        }
    }


    // CRUD

    public void addProduct(ActionEvent event) {
        this.product = new ProductEntity();
        this.product.setId(191);
        this.product.setCreatedAt(new Date());
        this.product.setName("Casti Wireless cu Microfon Pulse 3D");
        this.product.setDescription("Pentru PlayStation 5");
        this.product.setPrice(499.0);
    }

    public void addCategory(ActionEvent event) {
        this.category = new CategoryEntity("Gaming", "Casti gaming");
//        this.category.setId(222);
        this.product.setCreatedAt(new Date());
        this.category.setName("Gaming");
        this.category.setDescription("Casti gaming");
        this.categories.add(category);
    }

    public void saveProduct(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.product);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void saveCategory(ActionEvent event) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.category);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            exception.getSuppressed();
        }
    }

    public void deleteProduct(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.product)) {
            entityManager.remove(this.product);
            entityManager.getTransaction().commit();
            this.products.remove(this.product);
            this.product = this.products.get(0);
        }
    }

    public void deleteCategory(ActionEvent event) {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        if (entityManager.contains(this.category)) {
            entityManager.remove(this.category);
            entityManager.getTransaction().commit();
            this.category = this.categories.get(0);
        }
    }

    public void abandonProduct(ActionEvent event) {
        entityManager.clear();
        initProducts();
    }

    public void abandonCategory(ActionEvent event) {
        entityManager.clear();
        initCategories();
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(Integer id) {
        Integer index = this.products.indexOf(new ProductEntity(id, null, (String) null, null));
        this.product = this.products.get(index);
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(Integer id) {
        Integer index = this.categories.indexOf(new CategoryEntity(id, null, (ProductEntity) null));
        this.category = this.categories.get(index);
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
