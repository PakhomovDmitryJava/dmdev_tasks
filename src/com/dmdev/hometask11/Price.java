package com.dmdev.hometask11;

import java.util.Objects;

public class Price {
    private int id;
    private int price;

    public Price() {
    }

    public Price(int id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return id == price1.id && price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
