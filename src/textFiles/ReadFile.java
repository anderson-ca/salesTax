package textFiles;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.nio.Buffer;

// CLASS USED TO READ THE TEXT FILES.
public class ReadFile {

    // PRIVATE FIELD THAT CONTAINS THE PATH TO THE SPECIFIED FILE I WISH TO READ.
    private String path;

    // CONSTRUCTOR METHOD USED TO INITIALIZE AN INSTANCE OF THIS CLASS. THIS CONSTRUCTOR TAKES A FILE PATH AS A ARGUMENT.
    public ReadFile(String filePath) {

        // ASSIGN INPUT TO PATH VARIABLE.
        this.path = filePath;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // METHOD USED TO READ LINES IN A TEXT FILE. THIS METHOD RETURNS A INT. AND THROWS A INPUT OUTPUT EXCEPTION.//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    int readLines() throws IOException {
//
//        // CREATE FILE READER OBJ HOLDING THE SPECIFIED FILE DATA
//        FileReader fr = new FileReader(path);
//
//        // CREATE BF OBJ THAT WILL READ THE LINES OF THE SPECIFIED FILE THAT IS NOW STORED INSIDE FILE-TO-READ.
//        BufferedReader br = new BufferedReader(fr);
//
//        // DECLARE NULL VARIABLE SOME-LINE.
//        String someLine;
//
//        // DECLARE INT VARIABLE WITH INITIAL VALUE OF 0.
//        int numberOfLines = 0;
//
//        //LOOP WILL RUN AND INCREMENT THE NUMBER-OF-LINES VARIABLE AS LONG AS THE RETURN TYPE THE THE READLINE METHOD BEING APPLIED TO THE SOME-LINE VARIABLE IS NOT NULL. WHICH MEANS THAT AS LONG AS THE TXT FILE HAS A LINE THE LOOP WILL RUN.
//        while ((someLine = br.readLine()) != null) {
//
//            // INCREMENTATION
//            numberOfLines++;
//
//        }
//
//        // FLUSH MEMORY
//        br.close();
//
//        // RETURN THE NUMBER OF LINES CONTAdINED IN THE FILE.
//        return numberOfLines;
//
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    // METHOD USED TO OPEN THE TEXT FILE. THIS METHOD RETURNS A STRING ARRAY. AND THROWS A INPUT OUTPUT EXCEPTION.//
//    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public String[] openFile() throws IOException {
//
//        // INSTANTIATE THE FILE READER LIBRARY WITH THE PATH VARIABLE AS AN ARGUMENT. RF IS USED TO READ BYTES FROM A TXT FILE, AND EACH BYTE IS A SINGLE CHARACTER. OBJ CREATED.
//        FileReader fr = new FileReader(path);
//
//        // BUFFERED READER WILL BE USED TO READ WHOLE LINES OF THE FILE INSTEAD OF SINGLE CHARACTERS. THIS LIBRARY USES A METHOD CALLED READLINE TO ACCOMPLISH THAT. OBJ CREATED.
//        BufferedReader br = new BufferedReader(fr);
//
//        // VARIABLE THAT WILL HOLD THE NUMBER OF LINES CONTAINED IN THE TXT FILE.
//        int numberOfLines = readLines();
//
//        // CREATE A STRING OBJ ARRAY AND ASSIGN THE NUMBER OF LINES IN THE TXT FILE AS THE NUMBER OF POSITIONS INSIDE THE ARRAY. (ITS SIZE)
//        String[] textData = new String[numberOfLines];
//
//        // CREATE LOOP THAT ITERATES THROUGH THE TEXTDATA VARIABLE  WHICH HAS THE NUMBER OF LINES IN THE TXT FILE. AND USE THE READLINE METHOD TO READ EACH LINE OF THE TXT FILE.
//        for (int i = 0; i < numberOfLines; i++) {
//            textData[i] = br.readLine();
//        }
//
//        // THIS STATEMENT FLUSHES THE TEMPORARY MEMORY OF THE BUFFER NAME TEXTREADER.
//        br.close();
//
//        // THIS STATEMENT RETURNS THE TEXTDATA ARRAY.
//        return textData;
//
//    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    // METHOD USED TO OPEN DISPLAY ALL LINES IN THE CONSOLE. AND THROWS A INPUT OUTPUT EXCEPTION//
    //////////////////////////////////////////////////////////////////////////////////////////////
//    public void printLines() throws IOException {
//
//        String[] myFile = openFile();
//
//
//        for (int i = 0; i < myFile.length; i++) {
//
//            System.out.println(myFile[i]);
//
//        }
//    }



}