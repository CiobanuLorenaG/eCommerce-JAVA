import Entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityManager.getTransaction().begin();

        UserEntity user = new UserEntity(1, "Larisa", "Munteanu", "Aisa", "larisaM", "larisa.munteanu@gmail.com", "sgysgy", new Date());
        UserEntity user2 = new UserEntity(2, "Fabian", "Apetri", "Fabi", "fabianA", "fabian.apetri@gmail.com", "dsddfe", new Date());
        UserEntity user3 = new UserEntity(3, "Elisabeth", "Rusu", "Eli", "elisabethR", "elisabeth.rusu@gamil.com", "jdhyuw22", new Date());
        UserEntity user4 = new UserEntity(4, "Alina", "Bejenaru", "Ali", "alinaB", "alina.bejenaru12@gamil.com", "726hhh", new Date());
        UserEntity user5 = new UserEntity(5, "Elena", "Pricop", "Elena", "elenaP", "elena.pricop299@gamil.com", "etgbd22", new Date());
        UserEntity user6 = new UserEntity(6, "Sabina", "Padurariu", "Sabina", "sabinaP", "sabina.padurariu@gamil.com", "hbhbww8", new Date());
        UserEntity user7 = new UserEntity(7, "Bogdan", "Ioneasa", "Ioneasa", "bogdanI", "ioneasa.bogdan@gamil.com", "hwbjs99", new Date());
        UserEntity user8 = new UserEntity(8, "Dorin", "Carp", "Dutu", "dorinC", "dorin.carp99@gamil.com", "jdhhhuuu99", new Date());
        UserEntity user9 = new UserEntity(9, "Paul", "Zaharia", "Paul", "paulZ", "paul.zaharia@gamil.com", "juyy11", new Date());

        AddressEntity address = new AddressEntity(1, "Romania", "Bacau", "Bacau", "Strada Teiului 4", 11, new Date());
        AddressEntity address2 = new AddressEntity(2, "Romania", "Slatina", "Slatina", "Strada Fantanele", 22, new Date());
        AddressEntity address3 = new AddressEntity(3, "Romania", "Caras-severin", "Bocsa", "Strada 9 Mai", 33, new Date());
        AddressEntity address4 = new AddressEntity(4, "Romania", "Prahova", "Prahova", "Strada Republicii 291", 44, new Date());
        address.setUser(user);
        address.setUser(user2);
        address.setUser(user3);
        address2.setUser(user4);
        address2.setUser(user5);
        address3.setUser(user6);
        address3.setUser(user7);
        address4.setUser(user8);
        address4.setUser(user9);

        SupplierEntity supplier = new SupplierEntity(1, "AliExpress", new Date());
        SupplierEntity supplier2 = new SupplierEntity(2, "Spocket", new Date());
        SupplierEntity supplier3 = new SupplierEntity(3, "Alibaba", new Date());

        CategoryEntity category = new CategoryEntity("Console gaming", "Console Hardware", new Date());
        CategoryEntity category2 = new CategoryEntity("Playstation", "Accesorii playstation", new Date());
        CategoryEntity category3 = new CategoryEntity("XBOX", "Jocuri Consola & PC", new Date());
        CategoryEntity category4 = new CategoryEntity("Carti", "Carti pentru copii", new Date());
        CategoryEntity category5 = new CategoryEntity("Birotica", "Filme", new Date());
        CategoryEntity category6 = new CategoryEntity("Camping", "Corturi, saci de dormit, busole", new Date());
        CategoryEntity category7 = new CategoryEntity("Ciclism", "Lumini bicicleta, Antifurt bicicleta, Oglinzi bicicleta, Scaun copii bicicleta", new Date());
        CategoryEntity category8 = new CategoryEntity("Sport & Activitati in aer liber", "Skateboard", new Date());
        CategoryEntity category9 = new CategoryEntity("Accesorii aparate foto", "Stabilizatoare de imagine, Genti/Rucsacuri/Huse, Baterii, acumulatori si incarcatoare", new Date());
        CategoryEntity category10 = new CategoryEntity("Aparate foto", "Aparate foto instant", new Date());
        CategoryEntity category11 = new CategoryEntity("Drone", "Drone, Accesorii drone", new Date());

        ProductEntity product = new ProductEntity(1, "Consola Microsoft Xbox Series S", "Xbox Series S, cea mai mica si mai eleganta consola Xbox", 1, 1749.00);
        ProductEntity product2 = new ProductEntity(2, "Consola Nintendo Switch", "Gri + Joc Just Dance 2022", 1, 1649.99);

        product.setCategory(category);
        product.setSupplier(supplier);
        product.setCreatedAt(new Date());

        product2.setCategory(category);
        product2.setSupplier(supplier);
        product2.setCreatedAt(new Date());

        category.setProduct(product);
        category.setProduct(product2);

        ProductEntity product3 = new ProductEntity(3, "Statie de incarcare duala Venom", "VS2732 PS4, neagra", 1, 69.90);
        ProductEntity product4 = new ProductEntity(4, "Suport CD-uri Venom", "S3053 pentru PS3 / PS4 / Xbox One / Blu-ray, 12 spatii depozitare, Negru", 1, 94.88);

        product3.setCategory(category2);
        product3.setSupplier(supplier);
        product3.setCreatedAt(new Date());

        product4.setCategory(category2);
        product4.setSupplier(supplier2);
        product4.setCreatedAt(new Date());

        category2.setProduct(product3);
        category2.setProduct(product4);

        ProductEntity product5 = new ProductEntity(5, "Joc FIFA 22 ", "Tehnologie de joc HyperMotion", 1, 219.99);
        ProductEntity product6 = new ProductEntity(6, "Joc Minecraft Starter Collection", "Este necesar abonament Playstation Plus si internet pentru jocul online", 1, 119.99);

        product5.setCategory(category3);
        product5.setSupplier(supplier2);
        product5.setCreatedAt(new Date());

        product6.setCategory(category3);
        product6.setSupplier(supplier2);
        product6.setCreatedAt(new Date());

        category3.setProduct(product5);
        category3.setProduct(product6);

        ProductEntity product7 = new ProductEntity(7, "Un baiat numit Craciun, Matt Haig", "Destinat copiilor peste 8 ani", 1, 26.25);
        ProductEntity product8 = new ProductEntity(8, "Pinocchio", "Citeste si asculta -are 6 butoane care relateaza diferite parti ale povestii", 1, 26.99);
        ProductEntity product9 = new ProductEntity(9, "Bobita, Buburuza si baloanele de sapun, Bartos Erika", "Cititorii vor afla despre problemele cu care multi copii se confrunta la gradinita", 1, 21.99);

        product7.setCategory(category4);
        product7.setSupplier(supplier3);
        product7.setCreatedAt(new Date());

        product8.setCategory(category4);
        product8.setSupplier(supplier3);
        product8.setCreatedAt(new Date());

        product9.setCategory(category4);
        product9.setSupplier(supplier3);
        product9.setCreatedAt(new Date());

        category4.setProduct(product7);
        category4.setProduct(product8);
        category4.setProduct(product9);

        ProductEntity product10 = new ProductEntity(10, "Hotel Transilvania", "Colectie de 3 filme pe DVD / Hotel Transylvania 1, 2, 3 Movie DVD Collection", 1, 49.98);
        ProductEntity product11 = new ProductEntity(11, "Cernobil (Cernobyl) 2019", "Spune povestea dramatica a accidentului nuclear din 1986", 1, 55.92);
        ProductEntity product12 = new ProductEntity(12, "HARRY POTTER AND THE PHILOSOPHER 2001", "Bestsellerului omonim de J.K. Rowling, Harry Potter (Daniel Radcliffe)", 1, 24.90);

        product10.setCategory(category5);
        product10.setSupplier(supplier3);
        product10.setCreatedAt(new Date());

        product11.setCategory(category5);
        product11.setSupplier(supplier3);
        product11.setCreatedAt(new Date());

        product12.setCategory(category5);
        product12.setSupplier(supplier3);
        product12.setCreatedAt(new Date());

        category5.setProduct(product10);
        category5.setProduct(product11);
        category5.setProduct(product12);

        ProductEntity product13 = new ProductEntity(13, "Cort geodezic", "Cort geodezic pentru glamping Ekodome 5, 20 mp, tip igloo, cu izolatie, realizat pe structura metalica", 1, 21500.00);
        product13.setCreatedAt(new Date());
        product13.setCategory(category6);
        product13.setSupplier(supplier2);

        category6.setProduct(product13);

        ProductEntity product14 = new ProductEntity(14, "Scaun bicicleta pentru transport copii", "Scaun bicicleta pentru transport copii Dynamic G4, greutate maxima transport 22 kg", 1, 199.99);
        product14.setCreatedAt(new Date());
        product14.setCategory(category7);
        product14.setSupplier(supplier);

        category7.setProduct(product14);

        ProductEntity product15 = new ProductEntity(15, "Penny Board Action One ", "Cu roti luminoase 22'', ABEC-7, PU, Aluminium truck, 90 KG Cool Bro", 1, 89.99);
        product15.setCreatedAt(new Date());
        product15.setCategory(category8);
        product15.setSupplier(supplier3);

        category8.setProduct(product15);

        ProductEntity product16 = new ProductEntity(16, "Obiectiv Nikon", "50mm F1.8G AF-S", 1, 999.99);
        product16.setCreatedAt(new Date());
        product16.setCategory(category9);
        product16.setSupplier(supplier);

        category9.setProduct(product16);

        ProductEntity product17 = new ProductEntity(17, "Aparat foto instant Polaroid ", "Polaroid Now, I-Type, Alb + Pouch Rosu", 1, 419.99);
        product17.setCreatedAt(new Date());
        product17.setCategory(category10);
        product17.setSupplier(supplier3);

        category10.setProduct(product17);

        ProductEntity product18 = new ProductEntity(18, "Drona CSJ S167 GPS 4K 5G", "Brate pliabile, wifi, buton de intoarcere la punctul de plecare, camera 1080P HD cu transmisie live pe telefon, capacitate baterie 7.4V 1300 mAh, autonomie zbor ~ 20 de minute", 1, 639.05);
        product18.setCreatedAt(new Date());
        product18.setCategory(category11);
        product18.setSupplier(supplier);

        category11.setProduct(product18);

        // Favorites

        product.addFavoriteUser(user);
        product2.addShoppingCartUser(user2);
        product4.addFavoriteUser(user5);
        product8.addShoppingCartUser(user6);
        user.addFavorite(product5);
        user2.addFavorite(product8);
        user5.addFavorite(product10);

        DeliveryMethods deliveryLocal = DeliveryMethods.Local;
        DeliveryMethods deliveryEasyBox = DeliveryMethods.EasyBox;
        DeliveryMethods deliveryOvernight = DeliveryMethods.Overnight;
        DeliveryMethods deliveryInternational = DeliveryMethods.International;

        PaymentOptions option1 = PaymentOptions.Cash;
        PaymentOptions option2 = PaymentOptions.Checks;
        PaymentOptions option3 = PaymentOptions.CreditCards;
        PaymentOptions option4 = PaymentOptions.DebitCards;
        PaymentOptions option5 = PaymentOptions.ElectronicBankTransfers;
        PaymentOptions option6 = PaymentOptions.MobilePayments;

        List<ProductEntity> productsList1 = new ArrayList<>();
        productsList1.add(product);
        productsList1.add(product2);
        productsList1.add(product3);
        productsList1.add(product4);


        List<ProductEntity> productsList2 = new ArrayList<>();
        productsList2.add(product5);
        productsList2.add(product6);
        productsList2.add(product7);
        productsList2.add(product8);

        List<ProductEntity> productsList3 = new ArrayList<>();
        productsList3.add(product9);
        productsList3.add(product10);
        productsList3.add(product11);
        productsList3.add(product12);

        List<ProductEntity> productsList4 = new ArrayList<>();
        productsList4.add(product13);
        productsList4.add(product14);
        productsList4.add(product15);

        List<ProductEntity> productsList5 = new ArrayList<>();
        productsList5.add(product16);
        productsList5.add(product17);
        productsList5.add(product18);

        OrderEntity order = new OrderEntity(1, user, address, deliveryLocal.name(), option1.name(), new Date(), productsList1);
        OrderEntity order2 = new OrderEntity(2, user2, address2, deliveryEasyBox.name(), option2.name(), new Date(), productsList2);
        OrderEntity order3 = new OrderEntity(3, user3, address3, deliveryOvernight.name(), option3.name(), new Date(), productsList3);
        OrderEntity order4 = new OrderEntity(4, user4, address4, deliveryLocal.name(), option4.name(), new Date(), productsList4);
        OrderEntity order5 = new OrderEntity(5, user5, address, deliveryEasyBox.name(), option5.name(), new Date(), productsList5);

        OrderEntity order6 = new OrderEntity(6, user6, address, deliveryLocal.name(), option6.name(), new Date(), productsList1);
        OrderEntity order7 = new OrderEntity(7, user7, address2, deliveryEasyBox.name(), option1.name(), new Date(), productsList2);
        OrderEntity order8 = new OrderEntity(8, user8, address3, deliveryOvernight.name(), option2.name(), new Date(), productsList3);
        OrderEntity order9 = new OrderEntity(9, user9, address4, deliveryEasyBox.name(), option3.name(), new Date(), productsList4);
        OrderEntity order10 = new OrderEntity(10, user, address, deliveryInternational.name(), option4.name(), new Date(), productsList5);

        product.setOrder(order);
        product2.setOrder(order);
        product3.setOrder(order);
        product4.setOrder(order);

        product5.setOrder(order2);
        product6.setOrder(order2);
        product7.setOrder(order2);
        product8.setOrder(order2);

        product9.setOrder(order3);
        product10.setOrder(order3);
        product11.setOrder(order3);
        product12.setOrder(order3);

        product13.setOrder(order4);
        product14.setOrder(order4);
        product15.setOrder(order4);

        product16.setOrder(order5);
        product17.setOrder(order5);
        product18.setOrder(order5);


        category.setOrderCategory(order);
        category2.setOrderCategory(order2);
        category3.setOrderCategory(order3);
        category4.setOrderCategory(order4);
        category5.setOrderCategory(order5);
        category6.setOrderCategory(order6);
        category7.setOrderCategory(order7);
        category8.setOrderCategory(order8);
        category9.setOrderCategory(order9);
        category10.setOrderCategory(order10);
        category11.setOrderCategory(order10);

        order.setTotalOrder(1.0);
        order2.setTotalOrder(1.0);
        order3.setTotalOrder(1.0);
        order4.setTotalOrder(1.0);
        order5.setTotalOrder(1.0);
        order6.setTotalOrder(1.0);
        order7.setTotalOrder(1.0);
        order8.setTotalOrder(1.0);
        order9.setTotalOrder(1.0);
        order10.setTotalOrder(1.0);

        PromotionValue promotion = new PromotionValue();
        promotion.setId(1);
        promotion.setProduct(product);
        promotion.setProduct(product3);
        promotion.setProduct(product5);
        promotion.setProduct(product7);
        promotion.setProduct(product9);
        promotion.setProduct(product11);
        promotion.setProduct(product13);
        promotion.setProduct(product15);
        promotion.setProduct(product17);
        promotion.setDiscount(5.0);
        promotion.setLimitValue(1.0);

        PromotionValue promotion2 = new PromotionValue();
        promotion2.setId(2);
        promotion2.setProduct(product2);
        promotion2.setProduct(product4);
        promotion2.setProduct(product6);
        promotion2.setProduct(product8);
        promotion2.setProduct(product10);
        promotion2.setProduct(product12);
        promotion2.setProduct(product14);
        promotion2.setProduct(product16);
        promotion2.setProduct(product18);
        promotion2.setDiscount(10.0);
        promotion2.setLimitValue(2.0);

        order.setPromotion(promotion);
        order2.setPromotion(promotion2);
        order3.setPromotion(promotion);
        order4.setPromotion(promotion2);
        order5.setPromotion(promotion);
        order6.setPromotion(promotion2);
        order7.setPromotion(promotion);
        order8.setPromotion(promotion2);
        order9.setPromotion(promotion);
        order10.setPromotion(promotion2);

        ReviewEntity review = new ReviewEntity(1, user, product, "Excelent", "Merita banii. Daca ai asta si gamepass ai cam tot ce iti trebuie.", new Date());
        ReviewEntity review2 = new ReviewEntity(2, user4, product5, "Excelent", "Un joc excelent, livrat super rapid și fără probleme", new Date());
        ReviewEntity review3 = new ReviewEntity(3, user8, product11, "Recomand", "Un serial foarte bun.", new Date());

        entityManager.persist(user);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        entityManager.persist(user6);
        entityManager.persist(user7);
        entityManager.persist(user8);
        entityManager.persist(user9);
        entityManager.persist(address);
        entityManager.persist(address2);
        entityManager.persist(address3);
        entityManager.persist(address4);
        entityManager.persist(category);
        entityManager.persist(category2);
        entityManager.persist(category3);
        entityManager.persist(category4);
        entityManager.persist(category5);
        entityManager.persist(category6);
        entityManager.persist(category7);
        entityManager.persist(category8);
        entityManager.persist(category9);
        entityManager.persist(category10);
        entityManager.persist(category11);
        entityManager.persist(product);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        entityManager.persist(product5);
        entityManager.persist(product6);
        entityManager.persist(product7);
        entityManager.persist(product8);
        entityManager.persist(product9);
        entityManager.persist(product10);
        entityManager.persist(product11);
        entityManager.persist(product12);
        entityManager.persist(product13);
        entityManager.persist(product14);
        entityManager.persist(product15);
        entityManager.persist(product16);
        entityManager.persist(product17);
        entityManager.persist(product18);
        entityManager.persist(supplier);
        entityManager.persist(supplier2);
        entityManager.persist(supplier3);
        entityManager.persist(order);
        entityManager.persist(order2);
        entityManager.persist(order3);
        entityManager.persist(order4);
        entityManager.persist(order5);
        entityManager.persist(order6);
        entityManager.persist(order7);
        entityManager.persist(order8);
        entityManager.persist(order9);
        entityManager.persist(order10);
        entityManager.persist(review);
        entityManager.persist(review2);
        entityManager.persist(review3);
        entityManager.persist(promotion);
        entityManager.persist(promotion2);

        SupplierEntity supplierEntity1 = new SupplierEntity(4, "Cargus", new Date());
        SupplierEntity supplierEntity2 = new SupplierEntity(5, "FanCourier", new Date());

        List<ProductEntity> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        supplierEntity1.setProductsSupplier(products);
        entityManager.persist(supplierEntity1);
        entityManager.persist(supplierEntity2);

        List<ProductEntity> productEntity = entityManager.createQuery("select p from ProductEntity p where p.id=1", ProductEntity.class).getResultList();
        for (ProductEntity p : products) {
            System.out.println(p);
        }
        System.out.println("======" + productEntity);

        List<OrderEntity> orders = entityManager.createQuery("select o from OrderEntity o", OrderEntity.class).getResultList();
        orders.add(order);
        orders.add(order2);
        orders.add(order3);

        System.out.println(order.getTotalOrder());
        System.out.println(order2.getTotalOrder());
        System.out.println(order2.getTotalOrder());
        System.out.println(order3.getTotalOrder());
        System.out.println(order4.getTotalOrder());
        System.out.println(order5.getTotalOrder());
        System.out.println(order6.getTotalOrder());
        System.out.println(order7.getTotalOrder());
        System.out.println(order8.getTotalOrder());
        System.out.println(order9.getTotalOrder());
        System.out.println(order10.getTotalOrder());
//        for (OrderEntity o : orders) {
//            System.out.println(o.getTotalOrder());
//        }

        entityManager.getTransaction().commit();


    }
}
