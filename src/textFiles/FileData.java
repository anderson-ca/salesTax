package textFiles;

import java.io.IOException;

// THE CLASS WHERE THE FILE DATA WILL BE CONTAINED.
public class FileData {

    // THE MAIN METHOD WHERE I WILL RUN MY PROGRAM.
    public static void main(String[] args) {
        String fileName = "/Users/andersoncardoso/Desktop/test.txt";


        Item stuff = new Item();

        Product prod = new Product();

        try {

            System.out.println(prod.execute(fileName));


        } catch (Error e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
