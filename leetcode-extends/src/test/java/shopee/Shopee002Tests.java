package shopee;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Shopee002Tests extends AbstractOjTests {
    public Shopee002Tests() {
        super("/shopee/02/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Shopee002.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Shopee002.main(null);
        super.doAssertion(OUTPUT2);
    }
}
