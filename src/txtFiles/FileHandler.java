package txtFiles;

// IMPORT LIBRARIES.


import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

//////////////////////////////////////////////////////////////////////
// BUILD FILE HANDLER CLASS TO ASSIST ON THE TXT FILE MANIPULATION. //
//////////////////////////////////////////////////////////////////////
class FileHandler {

    /* METHODS USED TO OPEN AND PERFORM BASIC OPERATIONS. SUCH AS, READING LINES OF A
     TXT FILE OR THE FILE ITSELF. */
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////// BASIC FILE OPERATION METHODS ////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    // AS THE NAME REVEALS. THIS METHOD READS ALL THE LINES OF A TXT FILE AND RETURNS //
    // A INT VARIABLE WHICH REPRESENTS THE NUMBER OF LINES ON THE TXT FILE. ////////////
    static int readLines(String path) throws IOException {

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

    /////////////////////////////////////////////////////////////////////////////////
    // METHOD USED IN CONJUNCTION WITH THE READ-LINES METHOD ////////////////////////
    // TO OPEN A TXT FILE. THIS METHOD RETURNS A STRING LIST. ///////////////////////
    /////////////////////////////////////////////////////////////////////////////////
    static List<String> openFile(int numberOfLines, String path) throws IOException {

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

    ////////////////////////////////////////////////////////////////////////////////////////////
    // METHOD USED TO ACCESS THE ELEMENTS OF A ONE DIMENSION LIST(A), AND BY PARSING ///////////
    // THROUGH THE ELEMENTS OF LIST(A) THIS METHOD SPLITS EACH ELEMENT INTO A LIST(B). /////////
    // THEREFORE, RETURN A TWO DIMENSION LIST (A)(B). //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    static List<List<String>> createTwoDimensionList(List<String> testList) throws IOException {

        List<String> items = null;

        List<List<String>> itemList = new ArrayList<>();

        //////////////////////////
        for (String part : testList) {

            items = Arrays.asList(part.split(" "));

            itemList.add(items);
        }

        return itemList;
    }////////////////////////// -> CREATE TWO DIMENSION LIST.
}



