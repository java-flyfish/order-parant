package com.woollen.order.enums;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Info:
 * @ClassName: EnumOrderStatusType
 * @Author: weiyang
 * @Data: 2019/9/28 11:01 AM
 * @Version: V1.0
 **/
public enum  EnumOrderStatusType {
    //1:待付款，2:已付款，3:申请退款，4:退款审核中，5:退款完成，6:退款失败，9:订单过期

    PAY_UN(1, "待付款"),
    PAY_UP(2, "已付款"),
    APPLY_REFUND(3, "申请退款"),
    REFUND_ING(4, "退款审核中"),
    REFUND_SUCCESS(5, "退款成功"),
    REFUND_FAIL(6, "退款失败"),
    TIME_OUT(9, "订单过期");
    private int value;

    private String name;

    private EnumOrderStatusType(int value, String name){
        this.value = value;
        this.name = name;
    }



    /**
     * 根据值获取枚举
     * @param value 值
     * @return  枚举
     */
    public static EnumOrderStatusType getEnumByValue(int value) {
        for (EnumOrderStatusType type : values()) {
            if (type.value == value){
                return type;
            }
        }
        return null;
    }


    public static Map<Integer, String> toMap() {
        Map<Integer, String> enumDataMap = new HashMap<Integer, String>();
        for (EnumOrderStatusType type : values()) {
            enumDataMap.put(type.value, type.name);
        }
        return enumDataMap;
    }
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
