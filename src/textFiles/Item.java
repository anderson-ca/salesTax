package textFiles;

// Import libraries.

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections.*;

// Build Item model.
public class Item {

    //////////////////////////////////////////////
    //////////// FIELDS (ATTRIBUTES) /////////////
    //////////////////////////////////////////////
    private String path;

    private int quantity;

    private String productName;

    private BigDecimal price;

    private List<List<Item>> shoppingList;


    //////////////////////////////////////////////
    //////////// INITIALIZER METHOD //////////////
    //////////////////////////////////////////////
    public Item(String filePath) {

        this.path = filePath;
    }

    //////////////////////////////////////////////
    ////////////////// GETTERS  //////////////////
    //////////////////////////////////////////////
    public void getQuantity(int q) {

        this.quantity = q;
    }

    public void getProduct(String p) {

        this.productName = p;
    }

    public void getPrice(BigDecimal p) {

        this.price = p;
    }////////////////////////// -> GETTERS.

    /* METHODS USED TO OPEN AND PERFORM BASIC OPERATIONS. SUCH AS, READING LINES OF A
     TXT FILE OR THE FILE ITSELF. */
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// BASIC FILE OPERATION METHODS ////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    // AS THE NAME REVEALS. THIS METHOD READS ALL THE LINES OF A TXT FILE AND RETURNS //
    // A INT VARIABLE WHICH, REPRESENTS THE NUMBER OF LINES ON TXT FILE. ///////////////
    private int readLines() throws IOException {

        FileReader fr = new FileReader(path);

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
    private List<String> openFile() throws IOException {

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        int numberOfLines = readLines();

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
    private List<List<String>> createTwoDimensionList() throws IOException {

        List<String> file = openFile();

        List<String> items = null;

        List<List<String>> itemList = new ArrayList<>();

        //////////////////////////
        for (String part : file) {

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
    private boolean isImported(List<String> itemProperties) throws IOException {

        boolean importedItem = false;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (itemProperties.size() == 7 && (itemProperties.contains("imported")) && (!itemProperties.contains("headache"))) {

            importedItem = true;
        }

        return importedItem;
    }////////////////////////// -> IS IMPORTED.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // METHOD PERFORMS A SIMILAR OPERATION TO THE IS-IMPORTED METHOD. HOWEVER, THIS METHOD //
    // CHECKS IF THE ELEMENT QUALIFIES AS A SALES TAX EXEMPT ITEM. //////////////////////////
    private boolean isSalesTaxExempt(List<String> itemProperties) throws IOException {

        boolean isExempt;

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        isExempt = itemProperties.contains("chocolate") || itemProperties.contains("book") || itemProperties.contains("headache") || itemProperties.contains("chocolates");

        return isExempt;
    }////////////////////////// -> IS SALES TAX EXEMPT.

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //
    private void itemFactory(List<String> itemProperties) throws IOException {

//        // ASSIGN QUANTITY VALUE.
//        quantity = Integer.getInteger(itemProperties.get(0));
//
//        // ASSIGN PRICE VALUE.
//        price = new BigDecimal(itemProperties.get(itemProperties.size() - 1));

        ///////////// (special case: medication)
//        if (isSalesTaxExempt(itemProperties) && !isImported(itemProperties) && itemProperties.size() == 7) {
//            System.out.println("Medication(special item): ");
//            System.out.println(itemProperties.get(3));

        List<String> cleanProperties = new ArrayList<>();

        int lastItem = (itemProperties.size() -1);

        for (String property: itemProperties) {

            if ((itemProperties.indexOf(property) != 0) && (itemProperties.indexOf(property) != lastItem)) {
                cleanProperties.add(property);
            }

        }

        System.out.println(cleanProperties);

//
//        if (isSalesTaxExempt(itemProperties) && !isImported(itemProperties) && itemProperties.size() < 7) {
//
//            System.out.println(itemProperties);
//
//            System.out.println("Tax exempt items: ");
//
//
//        }

//            /////////////
//        } else if (!isSalesTaxExempt(itemProperties) && !isImported(itemProperties)) {
//
//            System.out.println("Not tax exempt items: ");
//
//            //////////////
//            if (itemProperties.size() < 6) {
//                System.out.println(itemProperties.get(2));
//
//            } else {
//                System.out.println(itemProperties.get(3));
//            }
//        } else if (isSalesTaxExempt(itemProperties) && isImported(itemProperties)) {
//
//            System.out.println("Tax exempt and Imported: ");
//            System.out.println(itemProperties.get(4));
//            //////////////
//        } else if (!isSalesTaxExempt(itemProperties) && isImported(itemProperties)) {
//
//            System.out.println("Not tax exempt and imported: ");
//            System.out.println(itemProperties.get(4));
//        }

    }///////////////////////// -> ITEMS FACTORY.


    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    void groceryList() throws IOException {

        List<List<String>> twoDimensionList;

        twoDimensionList = createTwoDimensionList();

        for (List<String> oneDimensionList : twoDimensionList) {

            itemFactory(oneDimensionList);
        }

//        // Parsing through two dimensional list in order to separate lists into four categories based on particular characteristics.
//        for (List<String> oneDimensionList : twoDimensionList) {
//
//            if (isSalesTaxExempt(oneDimensionList) && !isImported(oneDimensionList)) {
//
//
//                System.out.println("TAX EXEMPT ITEMS: " + oneDimensionList);
//            } else if (!isSalesTaxExempt(oneDimensionList) && !isImported(oneDimensionList)) {
//
//                System.out.println("NOT TAX EXEMPT ITEMS: " + oneDimensionList);
//            } else if (isSalesTaxExempt(oneDimensionList) && isImported(oneDimensionList)) {
//
//                System.out.println("TAX EXEMPT IMPORTED ITEMS: " + oneDimensionList);
//            } else if (!isSalesTaxExempt(oneDimensionList) && isImported(oneDimensionList)) {
//
//                System.out.println("NOT TAX EXEMPT IMPORTED ITEMS: " + oneDimensionList);
//            }
//
//        }

    }////////////////////////// -> ITEMS FACTORY.


}