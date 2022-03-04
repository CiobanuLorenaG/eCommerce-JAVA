package Entities;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class PromotionValue extends Promotion {
    private Double limitValue;
    private Double discount;

    public PromotionValue(Integer idPromotion, Double discount) {
        this.id = idPromotion;
        this.discount = discount;
    }

    @Override
    public Double getValueDiscount(Double quantity) {
        if (quantity * this.product.getPrice() > this.limitValue) {
            return this.discount * product.getPrice() * quantity;
        }
        return 0.0;
    }

    public PromotionValue() {
    }

    public PromotionValue(Double limitValue, Double discount) {
        this.limitValue = limitValue;
        this.discount = discount;
    }

    public PromotionValue(Integer id, ProductEntity product, Double limitValue, Double discount) {
        super(id, product);
        this.limitValue = limitValue;
        this.discount = discount;
    }

    public Double getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(Double limitValue) {
        this.limitValue = limitValue;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PromotionValue that = (PromotionValue) o;
        return Objects.equals(limitValue, that.limitValue) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), limitValue, discount);
    }

    @Override
    public String toString() {
        return "limitValue=" + limitValue +
                ", discount=" + discount;
    }
}
