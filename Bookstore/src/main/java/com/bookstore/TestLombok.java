package com.bookstore;

import lombok.Getter;
import lombok.Setter;

public class TestLombok {
    @Getter
    @Setter
    private String message;

    public static void main(String[] args) {
        TestLombok test = new TestLombok();
        test.setMessage("Hello, Lombok!");
        System.out.println(test.getMessage());
    }
}
