package org.example;


import com.google.gson.Gson;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = Map.of(
                "name", "Bohdan",
                "lastName", "Uhryniuk"
        );
        String gson = new Gson().toJson(map);
        System.out.println(gson);
    }
}