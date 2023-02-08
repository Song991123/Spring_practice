package org.example;

import java.util.Objects;

public class Cook {
    private final String name;
    private final int price;

    public Cook(String name, int price) {
        this.name  = name;  // 요리 이름
        this.price = price; // 요리 가격
    }

    public Cook(MenuItem menuItem) {
        this.name  = menuItem.getName();
        this.price = menuItem.getPrice();
    }

    // 객체들끼리 비교 시 equals() and hashcode() 필요

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
