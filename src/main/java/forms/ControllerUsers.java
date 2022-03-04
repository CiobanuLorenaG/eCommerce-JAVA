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
public class ControllerUsers {
    private UserEntity user;
    private List<UserEntity> users = new ArrayList<>();
    EntityManager entityManager;

    public ControllerUsers() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        entityManager = entityManagerFactory.createEntityManager();
        init();
    }

    private void init() {
//        List<UserEntity> userEntityList=entityManager.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
//        users.addAll(userEntityList);
//        this.users.sort(Comparator.comparing(UserEntity::getId));
//        this.user=users.get(0);

        this.users = entityManager.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
        if (!users.isEmpty()) {
            this.user = this.users.get(0);
        }
    }

    public void previousUser(ActionEvent event) {
        Integer index = this.users.indexOf(this.user);
        if (index > 0) {
            this.user = this.users.get(index - 1);
        } else {
            this.user = this.users.get(0);
        }
    }

    public void nextUser(ActionEvent event) {
        Integer index = this.users.indexOf(this.user);
        if (index < this.users.size() - 1) {
            this.user = this.users.get(index + 1);
        } else {
            this.user = this.users.get(this.users.size() - 1);
        }
    }

    // CRUD
    public void addUser(ActionEvent event) {
        this.user = new UserEntity();
        this.user.setId(21);
        this.user.setCreatedAt(new Date());
        this.user.setFirstName("Agneza");
        this.user.setLastName("Andries");
        this.user.setUsername("AgnezaA");
        this.user.setNickname("Agnez");
        this.user.setEmail("agneza.andries@gmail.com");
        this.user.setPassword("sjhjhdgsg");
        this.users.add(user);
    }

    public void saveUser(ActionEvent event) {
        if (this.entityManager.contains(this.user)) {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.user);
            this.entityManager.getTransaction().commit();
        } else {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(this.user);
            this.entityManager.getTransaction().commit();
        }
    }

    public void deleteUser(ActionEvent event) {
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
        if(entityManager.contains(this.user)){
            entityManager.remove(this.user);
            entityManager.getTransaction().commit();
            this.users.remove(this.user);
            this.user=this.users.get(0);
        }
    }

    public void abandonUser(ActionEvent event) {
//        if (this.entityManager.contains(this.user)) {
//            this.entityManager.refresh(this.user);
//        }else{
//            this.users.remove(this.user);
//            if (!this.users.isEmpty())
//                this.user = this.users.get(0);
//            else
//                this.user = null;
//        }

        entityManager.clear();
        init();
    }

    public Integer getId() {
        return this.user.getId();
    }

    public void setId(Integer id) {
        Integer index = this.users.indexOf(new UserEntity(id, null, null, null, null, null, null));
        this.user = this.users.get(index);
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
