package textFiles;

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

public class FileHandler {

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
    }
}
