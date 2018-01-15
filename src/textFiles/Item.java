package textFiles;

// Import libraries.

import com.sun.istack.internal.Nullable;


import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections.*;
import java.io.FileInputStream.*;

// Build Item model.
public class Item {

    //////////////////////////////////////////////
    //////////// FIELDS (ATTRIBUTES) /////////////
    //////////////////////////////////////////////
//    private String path;
//
//    private int quantity;
//
//    private String productName;
//
//    private BigDecimal price;
////
////    @Nullable
////    private List<List<Item>> shoppingList;


    //////////////////////////////////////////////
    //////////// INITIALIZER METHOD //////////////
    //////////////////////////////////////////////
//    public Item(int quantity, String productName, BigDecimal price) {
//
//        this.quantity = quantity;
//
//        this.productName = productName;
//
//        this.price = price;
//    }
//
//    public Item() {
//
//    }


    //////////////////////////////////////////////
    ////////////////// GETTERS  //////////////////
    //////////////////////////////////////////////

//    public void getQuantity(int q) {
//
//        this.quantity = q;
//    }
//
//    public void getProduct(String p) {
//
//        this.productName = p;
//    }
//
//    public void getPrice(BigDecimal p) {
//
//        this.price = p;
//    }////////////////////////// -> GETTERS.

    /* METHODS USED TO OPEN AND PERFORM BASIC OPERATIONS. SUCH AS, READING LINES OF A
     TXT FILE OR THE FILE ITSELF. */
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// BASIC FILE OPERATION METHODS ////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    // AS THE NAME REVEALS. THIS METHOD READS ALL THE LINES OF A TXT FILE AND RETURNS //
    // A INT VARIABLE WHICH, REPRESENTS THE NUMBER OF LINES ON TXT FILE. ///////////////

    static int readLines(String path) throws IOException {

        String filePath = path;

        FileReader fr = new FileReader(filePath);

        BufferedReader br = new BufferedReader(fr);

        String someLine;

        int numberOfLines = 0;

        ////////////////////////////////////////////
        while ((someLine = br.readLine()) != null) {

            numberOfLines++;
        }

        br.close();

        return numberOfLines;
    }////////////////////////// -> READ LINES.

    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    // METHOD USED IN CONJUNCTION WITH THE READ-LINES METHOD ///
    // TO OPEN A TXT FILE. THIS METHOD RETURNS A STRING LIST. //
    public static List<String> openFile(int numberOfLines, String path) throws IOException {

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        numberOfLines = numberOfLines;

        String lines = String.valueOf(numberOfLines);

        List<String> textData = new ArrayList<>();

        textData.add(lines);

        /////////////////////////////////////////
        for (int i = 0; i < numberOfLines; i++) {

            textData.add(br.readLine());
        }

        textData.remove(0);

        br.close();

        return textData;
    }////////////////////////// -> OPEN FILE.

    /* METHODS USED TO OPERATE ON THE DATA STRUCTURE RETRIEVED BY THE CONJUNCTION OF THE
     BASIC FILE OPERATION METHODS. */
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    // METHOD USED TO ACCESS THE ELEMENTS OF A ONE DIMENSION LIST(A), AND BY PARSING ////
    // THROUGH THE ELEMENTS OF LIST(A) THIS METHOD SPLITS EACH ELEMENT INTO A LIST(B). //
    // THEREFORE, RETURN A TWO DIMENSION LIST (A)(B). ///////////////////////////////////
    public static List<List<String>> createTwoDimensionList(List<String> testList) throws IOException {

        List<String> items = null;

        List<List<String>> itemList = new ArrayList<>();

        //////////////////////////
        for (String part : testList) {

            items = Arrays.asList(part.split(" "));

            itemList.add(items);
        }

        return itemList;
    }////////////////////////// -> CREATE TWO DIMENSION LIST.

    /* HELPER METHODS USED TO ASSIST IN THE LOGICAL OPERATION OF THE ITEM-FACTORY METHOD. */
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    // METHOD RETURNS A BOOLEAN VALUE BASED ON THE NECESSARY CHARACTERISTICS OF AN ELEMENT, ///
    // INSIDE THE ITEM-PROPERTIES LIST, TO INDICATE THAT THE ELEMENT IS IMPORTED OR NOT. //////
//    private boolean isImported(List<String> itemProperties) throws IOException {
//
//        boolean importedItem = false;
//
//        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if (itemProperties.size() == 7 && (itemProperties.contains("imported")) && (!itemProperties.contains("headache"))) {
//
//            importedItem = true;
//        }
//
//        return importedItem;
//    }////////////////////////// -> IS IMPORTED.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // METHOD PERFORMS A SIMILAR OPERATION TO THE IS-IMPORTED METHOD. HOWEVER, THIS METHOD //
    // CHECKS IF THE ELEMENT QUALIFIES AS A SALES TAX EXEMPT ITEM. //////////////////////////
//    private boolean isSalesTaxExempt(List<String> itemProperties) throws IOException {
//
//        boolean isExempt;
//
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        isExempt = itemProperties.contains("chocolate") || itemProperties.contains("book") || itemProperties.contains("headache") || itemProperties.contains("chocolates");
//
//        return isExempt;
//    }////////////////////////// -> IS SALES TAX EXEMPT.
//
//    //////////////////////////////////////////////
//    //////////////////////////////////////////////
//    //////////////////////////////////////////////
//    private Item itemFactory(List<List<String>> twoDimensionList) throws IOException {
//
//        List<String> shoppingList = new ArrayList<>();
//
//        String propertyString = null;
//
//        int lastItem = 0;
//
//        for (List<String> oneDimensionList : twoDimensionList) {
//            lastItem = (oneDimensionList.size() - 1);
//
//            // ASSIGN QUANTITY VALUE.
//            quantity = Integer.getInteger(oneDimensionList.get(0));
//
//            // ASSIGN PRICE VALUE.
//            price = new BigDecimal(oneDimensionList.get(oneDimensionList.size() - 1));
//
//            ////////////////////////////////////////
//            for (String property : oneDimensionList) {
//
//                ///////////////////////////////////////////////////////////////////////////////////////////////
//                if ((oneDimensionList.indexOf(property) != 0) && (oneDimensionList.indexOf(property) != lastItem)) {
//
//                    shoppingList.add(property);
//
//                    // ASSIGN PRODUCT-NAME;
//                    productName = String.join(" ", shoppingList);
//                }
//            }
//
//        }
//
//        return new Item(quantity, productName, price);
//    }
//
//
//    //////////////////////////////////////////////
//    //////////////////////////////////////////////
//    //////////////////////////////////////////////
//    Item itemFactoryTest(String path) throws IOException {
//
//        int numberOfLines = readLines(path);
//
//        List<String> testList = openFile(numberOfLines, path);
//
//        List<List<String>> twoTestList = createTwoDimensionList(testList);
//
//       return itemFactory(twoTestList);
//    }////////////////////////// -> ITEMS FACTORY TEST.


}



