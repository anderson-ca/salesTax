package textFiles;

// Import libraries.
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

    private String product;

    private BigDecimal price;




    public Item(String filePath) {

        this.path = filePath;
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
    public List<List<String>> createItems() throws IOException {

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
    //////////////////////////////////////////////
    public List<List<Item>> assignItems() {
        
    }






















}