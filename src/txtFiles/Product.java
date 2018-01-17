package txtFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

////////////////////////////////////////////////////////////////////////////////////
// BUILD PRODUCT MODEL USED TO BE POPULATED THE DATA RETRIEVED FROM THE TXT FILE. //
////////////////////////////////////////////////////////////////////////////////////
public class Product {

    //////////////////////////////////////////////
    //////////// FIELDS (ATTRIBUTES) /////////////
    //////////////////////////////////////////////
    private BigDecimal quantity;

    private String productName;

    private BigDecimal price;

    private List<Product> groceryList = new ArrayList<>();

    //////////////////////////////////////////////////////////////////
    // METHOD USED TO EXECUTE THE PROCESS OF READING THE FILE, ///////
    // INSTANTIATING THE PRODUCT CLASS, AND RETURNING A LIST OF //////
    // PRODUCTS. /////////////////////////////////////////////////////
    public List<Product> execute(String filePath) throws IOException {

        FileReader fr = new FileReader(filePath);

        BufferedReader br = new BufferedReader(fr);

        List<String> textData;

        List<List<String>> twoDimensionList;

        int lines = FileHandler.readLines(filePath);

        textData = FileHandler.openFile(lines, filePath);

        twoDimensionList = FileHandler.createTwoDimensionList(textData);

        return productFactory(twoDimensionList);

    }////////////////////////// -> EXECUTE.

    //////////////////////////////////////////////
    /////////// INITIALIZER METHODS //////////////
    //////////////////////////////////////////////
    public Product() {

    }

    public Product(BigDecimal quantity, String productName, BigDecimal price) {

        this.quantity = quantity;

        this.productName = productName;

        this.price = price;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////// METHOD USED TO GENERATE PRODUCT LISTS. ////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public List<Product> productFactory(List<List<String>> twoDimensionList) throws IOException {

        List<Product> testList = new ArrayList<>();

        for (List<String> oneDimensionList : twoDimensionList) {

            testList.add(productGenerator(oneDimensionList));

            groceryList.add(productGenerator(oneDimensionList));
        }


        return testList;
    }////////////////////////// -> PRODUCT FACTORY.

    ///////////////////////////////////////////////////////////
    // GENERATE AN INSTANCE OF THE PRODUCT CLASS WITH THE /////
    // VALUES RETRIEVED FROM THE LIST PROPERTY. ///////////////
    ///////////////////////////////////////////////////////////
    private Product productGenerator(List<String> properties) {

        int lastItem = (properties.size() - 1);

        int secondToLast = (properties.size() - 2);

        List<String> productNameList = new ArrayList<>();

        // ASSIGN QUANTITY VALUE.
        quantity = new BigDecimal(properties.get(0));

        // ASSIGN PRICE VALUE.
        price = new BigDecimal(properties.get(lastItem));

        ////////////////////////////////////////
        for (String property : properties) {

            ///////////////////////////////////////////////////////////////////////////////////////////////
            if ((properties.indexOf(property) != 0) && properties.indexOf(property) != lastItem && properties.indexOf(property) != secondToLast) {

                productNameList.add(property);
            }
        }

        // ASSIGN PRODUCT-NAME;
        productName = String.join(" ", productNameList);

        groceryList.add(new Product(quantity, productName, price));

        return new Product(quantity, productName, price);
    }////////////////////////// -> PRODUCT GENERATOR.

    public void displayShoppingList() {

        for (Product product : groceryList) {
            System.out.println("|| " + product.getQuantity() + " " + " " + product.getProductName() + " " + product.getPrice());
            System.out.println("============================================");

        }
    }

    //////////////////////////////////////////////
    ////////////////// SETTERS ///////////////////
    //////////////////////////////////////////////
    public void setQuantity(BigDecimal quantity) {

        this.quantity = quantity;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    //////////////////////////////////////////////
    ////////////////// GETTERS  //////////////////
    //////////////////////////////////////////////
    public BigDecimal getQuantity() {

        return this.quantity;
    }

    public String getProductName() {

        return this.productName;
    }

    public BigDecimal getPrice() {

        return this.price;
    }

    ////////////////////////////////////////
    ///// WHERE THE PROGRAM SHOULD RUN /////
    ////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/andersoncardoso/Desktop/test.txt";

        Product prod = new Product();

        for (Product x : prod.execute(fileName)) {
            System.out.println(x.getProductName());
        }

    }/////////////////////////// -> MAIN METHOD.

}////////////////////////// -> PRODUCT CLASS.
