package txtFiles;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Calculator {

    /* HELPER METHODS USED TO ASSIST IN THE LOGICAL OPERATION OF THE CALCULATE PRICE METHOD. */
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    // METHOD RETURNS A BOOLEAN VALUE BASED ON THE NECESSARY CHARACTERISTICS OF AN ELEMENT, ///
    // INSIDE THE PRODUCT-PROPERTIES LIST, TO INDICATE THAT THE ELEMENT IS IMPORTED OR NOT. ///
    private static boolean isImported(Product product) throws IOException {

        boolean importedItem = false;

        List<String> testList = Arrays.asList(product.getProductName().split(" "));

        for (String test : testList) {

            if (test.equalsIgnoreCase("imported")) {

                importedItem = true;
            }
        }

        return importedItem;
    }////////////////////////// -> IS-IMPORTED.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // METHOD PERFORMS A SIMILAR OPERATION TO THE IS-IMPORTED METHOD. HOWEVER, THIS METHOD //
    // CHECKS IF THE ELEMENT QUALIFIES AS A SALES TAX EXEMPT ITEM. //////////////////////////
    static private boolean isSalesTaxExempt(Product product) {

        boolean taxExempt = false;

        List<String> testList = Arrays.asList(product.getProductName().split(" "));

        for (String test : testList) {

            if (test.equalsIgnoreCase("chocolate") || test.equalsIgnoreCase("book") || test.equalsIgnoreCase("headache") || test.equalsIgnoreCase("chocolates")) {

                taxExempt = true;
            }
        }

        return taxExempt;
    }////////////////////////// -> IS-SALES-TAX-EXEMPT.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // METHOD USED TO CALCULATE SALES TAX AND DISPLAY A RESULT. /////////////////////////////
    static private BigDecimal calculateSalesTax(BigDecimal number) {

        BigDecimal result = BigDecimal.ZERO;

        BigDecimal tenPercent = BigDecimal.TEN;

        BigDecimal oneHundred = BigDecimal.valueOf(100);

        result = result.add(tenPercent.multiply(number).divide(oneHundred, BigDecimal.ROUND_HALF_EVEN));

        return result;
    }////////////////////////// -> CALCULATE SALES TAX.

    /////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////
    // SIMILAR TO CALCULATE TAX. THIS METHOD CALCULATES THE IMPORT TAX. /////////////////////
    static private BigDecimal calculateImportTax(BigDecimal number) {

        BigDecimal result = BigDecimal.ZERO;

        BigDecimal fivePercent = BigDecimal.valueOf(5);

        BigDecimal oneHundred = BigDecimal.valueOf(100);

        result = result.add(fivePercent.multiply(number).divide(oneHundred));

        result = result.setScale(1, BigDecimal.ROUND_UP);

        return result;
    }////////////////////////// -> CALCULATE IMPORT TAX.

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    // THIS METHOD IS USED IN CONJUNCTION WITH ALL OF THE ABOVE METHOD TO DISPLAY ///////
    // A FINAL RESULT. THIS METHOD WILL PARSE THROUGH THE LIST OF PRODUCTS A SEPARATE ///
    // EACH ITEM BASED IN THE INDIVIDUAL CHARACTERISTIC OF EACH ITEM. ///////////////////
    static void getTotalCost(List<Product> shoppingCart) throws IOException {

        /////////////////////////////////////////////////
        //////////////////// VARIABLES //////////////////
        /////////////////////////////////////////////////
        /* VARIABLES CREATED TO GENERATE LESS CLUTTER. */

        // CONTAINS THE FINAL SALES TAX.
        BigDecimal salesTax = BigDecimal.ZERO;

        // CONTAINS THE FINAL IMPORT TAX.
        BigDecimal importTax = BigDecimal.ZERO;

        // CONTAINS FINAL TOTAL COST.
        BigDecimal total = BigDecimal.ZERO;


        // ENHANCED FOR LOOP USED TO PARSE THROUGH THE OBJS.
        for (Product prod : shoppingCart) {

            ///////////////////////////////////////////////////////////////////////////////////
            // 1ST CONDITION -> PRODUCT IS SALES TAX EXEMPT AND NOT IMPORTED. (NO TAX APPLY) //
            if (isSalesTaxExempt(prod) && !isImported(prod)) {
                System.out.println("===========================================");
                System.out.println("TESTING CONDITION 1 =======================");

                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + prod.getQuantity().multiply(prod.getPrice()));

                // DISPLAY SALES AND IMPORT TAX INFO FOR SPECIFIC ITEM.
                System.out.println("Sales Tax: " + salesTax);
                System.out.println("Import Tax: " + importTax);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()));

            //////////////////////////////////////////////////////////////////////////////////////////
            // 2ND CONDITION -> PRODUCT IS NOT SALES TAX EXEMPT ANDF NOT IMPORTED. (SALES TAX APPLY) //
            } else if (!isSalesTaxExempt(prod) && !isImported(prod)) {
                System.out.println("===========================================");
                System.out.println("TESTING CONDITION 2 =======================");

                BigDecimal condition2sales = calculateSalesTax(prod.getQuantity().multiply(prod.getPrice()));

                BigDecimal condition2import = calculateImportTax(prod.getQuantity().multiply(prod.getPrice()));

                salesTax = salesTax.add(condition2sales);

                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + prod.getQuantity().multiply(prod.getPrice().add(condition2sales)));

                // DISPLAY SALES AND IMPORT TAX INFO FOR SPECIFIC ITEM.
                System.out.println("Sales Tax: " + condition2sales);
                System.out.println("Import Tax: " + condition2import);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()).add(condition2sales));

            ///////////////////////////////////////////////////////////////////////////////////
            // 3RD CONDITION -> PRODUCT IS SALES TAX EXEMPT AND IMPORTED. (IMPORT TAX APPLY) //
            } else if (isSalesTaxExempt(prod) && isImported(prod)) {
                System.out.println("===========================================");
                System.out.println("TESTING CONDITION 3 =======================");

                BigDecimal condition3sales = calculateImportTax(prod.getQuantity().multiply(prod.getPrice()));

                BigDecimal condition3import = calculateImportTax(prod.getQuantity().multiply(prod.getPrice()));

                salesTax = salesTax.add(condition3import);

                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + prod.getQuantity().multiply(prod.getPrice()).add(condition3import));

                // DISPLAY SALES AND IMPORT TAX INFO FOR SPECIFIC ITEM.
                System.out.println("Sales Tax: " + condition3sales);
                System.out.println("Import Tax: " + condition3import);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()).add(condition3import));

            //////////////////////////////////////////////////////////////////////////////////////////////////
            // 4TH CONDITION -> PRODUCT IS NOT SALES TAX EXEMPT AND IMPORTED. (SALES TAX AND IMPORT TAX APPLY)
            } else if (!isSalesTaxExempt(prod) && isImported(prod)) {
                System.out.println("===========================================");
                System.out.println("TESTING CONDITION 4 =======================");

                BigDecimal condition4sales = calculateSalesTax(prod.getQuantity().multiply(prod.getPrice()));

                BigDecimal condition4import = calculateImportTax(prod.getQuantity().multiply(prod.getPrice()));

                salesTax = salesTax.add(condition4sales).add(condition4import);

                importTax = importTax.add(calculateImportTax(prod.getQuantity().multiply(prod.getPrice())));
                System.out.println(prod.getQuantity() + " " + prod.getProductName() + ": " + prod.getQuantity().multiply(prod.getPrice()).add(condition4sales).add(condition4import));


                // DISPLAY SALES AND IMPORT TAX INFO FOR SPECIFIC ITEM.
                System.out.println("Sales Tax: " + condition4sales);
                System.out.println("Import Tax: " + condition4import);

                total = total.add(prod.getQuantity().multiply(prod.getPrice()).add(condition4sales).add(condition4import));
            }

        }
        System.out.println("=====================================");
        System.out.println("Sales Tax: " + salesTax);
        System.out.println("Total: " + total);
    }////////////////////////// -> GET TOTAL COST.

}////////////////////////// -> CALCULATOR CLASS.
