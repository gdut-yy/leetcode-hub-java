import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Shopee004Tests extends AbstractOjTests {
    public Shopee004Tests() {
        super("/shopee/04/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Shopee004.main(null);
        super.doAssertion(OUTPUT1);
    }
}
