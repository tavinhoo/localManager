package com.example.gasManager.model.enums;

public enum CustomerGender {

    MALE(1),
    FEMALE(2);

    private int code;

    private CustomerGender(int i) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CustomerGender valueOf(int code) throws IllegalAccessException {
        for(CustomerGender value : CustomerGender.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalAccessException("Invalid Gender code.");
    }

}
