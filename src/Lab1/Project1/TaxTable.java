package Lab1.Project1;

/**
 * TaxTable.java
 */
public class TaxTable {
    public static void main(String[] args) {
        for (int i = 60000; i <= 1000000; i += 10000) {
            Tax tax = new Tax(i);
            System.out.println(tax);
        }
    }
}
