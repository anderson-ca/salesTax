package textFiles;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.math.BigDecimal;

class Calculator {

    private String[] exemptItems = {"book", "chocolate", "headache"};

    private String item;

    private int quantity;

    private BigDecimal cost;

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    public Calculator(String item, int quantity, BigDecimal cost) {

        this.item = item;

        this.quantity = quantity;

        this.cost = cost;
    }




}
