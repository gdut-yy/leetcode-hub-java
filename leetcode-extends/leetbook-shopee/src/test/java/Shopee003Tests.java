import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Shopee003Tests extends AbstractOjTests {
    public Shopee003Tests() {
        super("/shopee/03/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Shopee003.main(null);
        super.doAssertion(OUTPUT1);
    }
}
