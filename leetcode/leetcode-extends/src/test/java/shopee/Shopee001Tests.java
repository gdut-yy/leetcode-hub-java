package shopee;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Shopee001Tests extends AbstractOjTests {
    public Shopee001Tests() {
        super("/shopee/01/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Shopee001.main(null);
        super.doAssertion();
    }
}
