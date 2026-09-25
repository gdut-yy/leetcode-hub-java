import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Shopee005Tests extends AbstractOjTests {
    public Shopee005Tests() {
        super("/shopee/05/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Shopee005.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Shopee005.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Shopee005.main(null);
        super.doAssertion(OUTPUT3);
    }
}
