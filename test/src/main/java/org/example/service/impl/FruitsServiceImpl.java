package org.example.service.impl;

import org.example.domain.Fruits;
import org.example.service.FruitsService;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@SuppressWarnings("All")
@Service
public class FruitsServiceImpl implements FruitsService {

    public double test(int apple,int strawberry,int mango,int discountType) {
        if (apple < 0 || strawberry < 0 || mango < 0) {
            throw new RuntimeException("请输入正确的数量！");
        }
        //初始化总金额
        double total = 0.0;
        //苹果
        Fruits appleFruits = new Fruits();
        appleFruits.setName("苹果");
        appleFruits.setPrice(8);
        appleFruits.setNum(apple);

        //草莓
        Fruits strawFruits = new Fruits();
        strawFruits.setName("草莓");
        strawFruits.setPrice(13);
        strawFruits.setNum(strawberry);

        //芒果
        Fruits mangoFruits = new Fruits();
        mangoFruits.setName("芒果");
        mangoFruits.setPrice(20);
        mangoFruits.setNum(mango);

        //首次消费金额（正常价格）
        double firstTotal = appleFruits.getSum() + strawFruits.getSum() + mangoFruits.getSum();
        //满减金额
        double tempCount = 0;
        //选择活动类型
        switch (discountType) {
            case 1:
                //无活动
                break;
            case 2:
                //这里表示草莓八折的活动
                strawFruits.setDisCount(0.8);
                break;
            case 3:
                //这里表示全场满100-10活动
                tempCount = (int) (firstTotal / 100) * 10;
                break;
        }
        //计算部分折扣后的商品价格
        firstTotal = appleFruits.getSum() + strawFruits.getSum() + mangoFruits.getSum();
        //进行精度问题
        BigDecimal b1 = new BigDecimal(Double.toString(firstTotal));
        BigDecimal b2 = new BigDecimal(Double.toString(tempCount));
        return b1.subtract(b2).doubleValue();

    }
}