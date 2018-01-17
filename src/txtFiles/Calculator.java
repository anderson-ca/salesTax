package txtFiles;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Calculator {

    //////////////////////////////////////////////
    //////////// FIELDS (ATTRIBUTES) /////////////
    //////////////////////////////////////////////
    private BigDecimal quantity;

    private String description;

    private BigDecimal cost;

    private List<Product> products = new ArrayList<>();

    //////////////////////////////////////////////
    /////////// INITIALIZER METHODS //////////////
    //////////////////////////////////////////////
    public Calculator(Product product) {

        this.quantity = product.getQuantity();

        this.description = product.getProductName();

        this.cost = product.getPrice();

        products.add(product);
    }

    /* HELPER METHODS USED TO ASSIST IN THE LOGICAL OPERATION OF THE CALCULATE PRICE METHOD. */
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    // METHOD RETURNS A BOOLEAN VALUE BASED ON THE NECESSARY CHARACTERISTICS OF AN ELEMENT, ///
    // INSIDE THE PRODUCT-PROPERTIES LIST, TO INDICATE THAT THE ELEMENT IS IMPORTED OR NOT. ///
    private boolean isImported(Product product) throws IOException {

        boolean importedItem = false;

        List<String> testList = Arrays.asList(product.getProductName().split(" "));

        for (String test : testList) {

            if (test.equalsIgnoreCase("imported")) {

                importedItem = true;
            }
        }

        return importedItem;
    }////////////////////////// -> IS-IMPORTED.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // METHOD PERFORMS A SIMILAR OPERATION TO THE IS-IMPORTED METHOD. HOWEVER, THIS METHOD //
    // CHECKS IF THE ELEMENT QUALIFIES AS A SALES TAX EXEMPT ITEM. //////////////////////////
    private boolean isSalesTaxExempt(Product product) {

        boolean taxExempt = false;

        List<String> testList = Arrays.asList(product.getProductName().split(" "));

        for (String test : testList) {

            if (test.equalsIgnoreCase("chocolate") || test.equalsIgnoreCase("book") || test.equalsIgnoreCase("headache") || test.equalsIgnoreCase("chocolates")) {

                taxExempt = true;
            }
        }

        return taxExempt;
    }////////////////////////// -> IS-SALES-TAX-EXEMPT.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    private BigDecimal calculateSalesTax(BigDecimal number) {

        BigDecimal tenPercent = BigDecimal.valueOf(10);

        BigDecimal oneHundred = BigDecimal.valueOf(100);

        BigDecimal result = BigDecimal.valueOf(0);

        result = result.add(tenPercent.multiply(number).divide(oneHundred));

        return result;
    }

    //////////////////////////////////////////////
    //////////// DISPLAY TOTAL COST //////////////
    //////////////////////////////////////////////
    public void getTotalCost(List<Product> shoppingCart) throws IOException {

//        BigDecimal salesTax = BigDecimal.valueOf(10);

        BigDecimal importTax = BigDecimal.valueOf(5);

        BigDecimal grossPrice = BigDecimal.valueOf(0);

        BigDecimal total = BigDecimal.valueOf(0);

        for (Product prod : shoppingCart) {

            grossPrice = grossPrice.add(prod.getQuantity().multiply(prod.getPrice()));

            if (isSalesTaxExempt(prod) && !isImported(prod)) {

                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + grossPrice);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()));

            } else if (!isSalesTaxExempt(prod) && !isImported(prod)) {

                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + grossPrice);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()));
            }

        }
        System.out.println("=====================================");
        System.out.println("Sales Tax: ");
        System.out.println("Total: " + total);
    }


    //////////////////////////////////////////////
    ////////////////// GETTERS  //////////////////
    //////////////////////////////////////////////
    public BigDecimal getQuantity() {

        return quantity;
    }

    public String getDescription() {

        return description;
    }

    public BigDecimal getCost() {

        return cost;
    }

    //////////////////////////////////////////////
    ////////////////// SETTERS ///////////////////
    //////////////////////////////////////////////
    public void setQuantity(BigDecimal quantity) {

        this.quantity = quantity;
    }


    public void setDescription(String description) {

        this.description = description;
    }


    public void setCost(BigDecimal cost) {

        this.cost = cost;
    }/////////////////////////// -> SETTERS AND GETTERS.

    ////////////////////////////////////////
    ///// WHERE THE PROGRAM SHOULD RUN /////
    ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/andersoncardoso/Desktop/test.txt";

        Product item = new Product();

        Calculator calculator = new Calculator(item);

        try {

            calculator.getTotalCost(item.execute(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
