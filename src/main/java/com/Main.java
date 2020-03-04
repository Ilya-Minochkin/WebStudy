package com;



import java.sql.*;
import java.util.Base64;

import bs.Crypto;
import dao.DAO;



//@SpringBootApplication
public class Main {

    public static void main(String[] args) {
  //      SpringApplication.run(Main.class, args);
        Array array;
        String text = "QWERTY";
        byte[] buff;
        String result;
        Crypto crypto = new Crypto();
        try {
            buff = crypto.encryptData(text);
            System.out.println("ENCRYPTED: " + new String(Base64.getEncoder().encode(buff)));
            result = crypto.decryptData(buff);
            System.out.println("RESULT: " + result);
            array = DAO.getFullInfo().getArray("ID");
            while (DAO.getFullInfo().next()){
                System.out.println(array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
