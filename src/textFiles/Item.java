package textFiles;

// Import libraries.

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.management.ObjectName;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.math.BigDecimal;
import java.util.Currency;

// Build Item model.
public class Item {

    private String path;

    private int quantity;

    private String productName;

    private BigDecimal price;

    private List<List<Item>> shoppingList;


    public Item(String filePath) {

        this.path = filePath;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    public void getQuantity(int q) {

        this.quantity = q;
    }

    public void getProduct(String p) {

        this.productName = p;
    }

    public void getPrice(BigDecimal p) {

        this.price = p;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    int readLines() throws IOException {

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        String someLine;

        int numberOfLines = 0;

        while ((someLine = br.readLine()) != null) {

            numberOfLines++;
        }

        br.close();

        return numberOfLines;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    public List<String> openFile() throws IOException {

        FileReader fr = new FileReader(path);

        BufferedReader br = new BufferedReader(fr);

        int numberOfLines = readLines();

        String lines = String.valueOf(numberOfLines);

        List<String> textData = new ArrayList<>();

        textData.add(lines);

        for (int i = 0; i < numberOfLines; i++) {

            textData.add(br.readLine());
        }

        textData.remove(0);

        br.close();

        return textData;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    public List<List<String>> createTwoDimensionList() throws IOException {

        List<String> file = openFile();

        List<String> items = null;

        String trim;

        List<List<String>> itemList = new ArrayList<List<String>>();

        //////////////////
        for (String part : file) {

            items = Arrays.asList(part.split(" "));

            itemList.add(items);
        }

        return itemList;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    ////////////////////////////////////////////
//    public boolean ItemParser() {
//
//
//    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
//    public void itemFactory(List<String> itemProperties) {
//
//        for (String property : itemProperties) {
//
//            if(itemProperties.size() == 7) {
//                System.out.println("it worked!!");
//                System.out.println(property);
//            }
//        }
//    }

    public boolean isImported(List<String> itemProperties) throws IOException {

        boolean importedItem = false;

            if (itemProperties.size() == 7 && (itemProperties.contains("imported"))) {

                importedItem = true;
            }

        return importedItem;
    }

    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    public void ItemsFactory() throws IOException {

        List<List<String>> twoDimensionList = new ArrayList<List<String>>();

        List<Item> groceryList = new ArrayList<Item>();

        twoDimensionList = createTwoDimensionList();

        // Parsing through two dimensional list in order to separate lists into four categories based on particular characteristics.
        for (List<String> oneDimensionList : twoDimensionList) {

            if (isImported(oneDimensionList)) {
                System.out.println(oneDimensionList);
            }

//            // tax exempt, imported items.
//            if (oneDimensionList.size() == 7 && oneDimensionList.contains("chocolates")) {
//
//                System.out.println("TAX EXEMPT IMPORTED ITEMS => " + oneDimensionList);
//
//                // not tax exempt, imported items.
//            } else if (oneDimensionList.size() == 7 && oneDimensionList.contains("perfume")) {
//
//                System.out.println("NOT TAX EXEMPT IMPORTED ITEMS => " + oneDimensionList);
//
//                // not tax exempt not imported items.
//            } else

//            if ((oneDimensionList.size() <= 5 && ((oneDimensionList.contains("chocolate"))) | oneDimensionList.contains("book") | oneDimensionList.contains("headache"))) {
//                System.out.println("TAX EXEMPT NOT IMPORTED ITEMS: " + oneDimensionList);
//            }
//
//            if (oneDimensionList.size() <= 6 && (oneDimensionList.contains("perfume") || oneDimensionList.contains("CD"))) {
//
//                System.out.println("NOT TAX EXEMPT NOT IMPORTED ITEMS => " + oneDimensionList);
//            }


        }
    }


}