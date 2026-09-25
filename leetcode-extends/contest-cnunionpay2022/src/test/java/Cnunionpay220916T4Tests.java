import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cnunionpay220916T4Tests {
    @Test
    public void example1() {
        Cnunionpay220916T4.VendingMachine vendingMachine = new Cnunionpay220916T4.VendingMachine();
        vendingMachine.addItem(0, 3, "Apple", 10, 10);
        Assertions.assertEquals(10, vendingMachine.sell(1, "Tom", "Apple", 1));
        Assertions.assertEquals(-1, vendingMachine.sell(2, "Tom", "Apple", 3));
        Assertions.assertEquals(-1, vendingMachine.sell(3, "Mary", "Banana", 2));
        Assertions.assertEquals(-1, vendingMachine.sell(11, "Jim", "Apple", 1));
    }

    @Test
    public void example2() {
        Cnunionpay220916T4.VendingMachine vendingMachine = new Cnunionpay220916T4.VendingMachine();
        vendingMachine.addItem(0, 1, "Apple", 4, 3);
        vendingMachine.addItem(1, 3, "Apple", 4, 2);
        Assertions.assertEquals(8, vendingMachine.sell(2, "Mary", "Apple", 2));
        vendingMachine.addItem(2, 1, "Banana", 2, 5);
        Assertions.assertEquals(-1, vendingMachine.sell(4, "Jim", "Banana", 2));
        Assertions.assertEquals(2, vendingMachine.sell(4, "Mary", "Banana", 1));
        Assertions.assertEquals(-1, vendingMachine.sell(4, "Mary", "Apple", 1));
        vendingMachine.addItem(6, 200, "Apple", 2, 5);
        Assertions.assertEquals(200, vendingMachine.sell(6, "Jim", "Apple", 100));
        Assertions.assertEquals(196, vendingMachine.sell(7, "Mary", "Apple", 100));
    }
}
