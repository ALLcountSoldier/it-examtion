package org.example.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;
@Data
public class Fruits {
    //水果名字
    private String name;
    //水果价格
    private int price;
    //水果数量
    private int num;
    //折扣
    private double disCount = 1;
    //折扣类型
    private int discountType;
    //当前水果总价
    private double sum;
    public double getSum() {
        //金额使用BigDecimal
        BigDecimal p1 = new BigDecimal(Double.toString(price*num));
        BigDecimal p2 = new BigDecimal(Double.toString(disCount));
        sum = p1.multiply(p2).doubleValue();
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruits fruits = (Fruits) o;
        return price == fruits.price &&
                num == fruits.num &&
                Double.compare(fruits.disCount, disCount) == 0 &&
                Double.compare(fruits.sum, sum) == 0 &&
                Objects.equals(name, fruits.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, num, disCount, sum);
    }
}