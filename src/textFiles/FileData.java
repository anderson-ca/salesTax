package textFiles;

import java.io.IOException;

// THE CLASS WHERE THE FILE DATA WILL BE CONTAINED.
public class FileData {

    // THE MAIN METHOD WHERE I WILL RUN MY PROGRAM.
    public static void main(String[] args) {
        String fileName = "/Users/andersoncardoso/Desktop/test.txt";


        Item stuff = new Item(fileName);

        try {
            System.out.println(stuff.createTwoDimentionList());

        } catch( IOException e) {
            System.out.println(e.getMessage());
        }

//
//        try {
//
//            // SAVE FILE PATH TO A VARIABLE.
//
//
//            ReadFile someFile = new ReadFile(fileName);
//
//            someFile.printLines();
//
//        } catch (IOException e) {
//
//            System.out.println(e.getMessage());
//        }
//
//
//        // USE THE TRY CATCH IN ORDER TO CATCH ANY ERROR CAUSED BY THE OPERATION WITHOUT COMPLETELY CRASHING THE APPLICATION.
//        try {
//
//            // CREATE A READFILE OBJ INSTANCE AND USE THE VARIABLE WITH THE TXT FILE PATH AS AN ARGUMENT.
//            ReadFile myFile = new ReadFile(fileName);
//
//            // ASSIGN THE RETURN VALUE OF THE OPENFILE METHOD TO THE STRING OBJ ARRAY INSTANTIATE IN THE PAGE.
//            String[] allLines = myFile.openFile();
//
//            // LOOP THROUGH THE ALLLINES ARRAY AND DISPLAY THE CONTENT IN EACH INDEX POSITION.
//            for (int i = 0; i < allLines.length; i++) {
//
//                // OUTPUT OF THE DATA.
//                System.out.println(allLines[i]);
//
//            }
//
//        } catch (IOException e) {
//
//            // DISPLAY THE ERROR MESSAGE IN CASE THE OPERATION FAILS.
//            System.out.println("/////////////////////");
//            System.out.println(e.getMessage());
//            System.out.println("/////////////////////");
//
//        }

    }
}
