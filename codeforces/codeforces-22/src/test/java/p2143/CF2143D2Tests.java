package p2143;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2143D2Tests extends AbstractOjTests {
    public CF2143D2Tests() {
        super("/p2143/D2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2143D2.main(null);
        super.doAssertion(OUTPUT1);
    }
}
