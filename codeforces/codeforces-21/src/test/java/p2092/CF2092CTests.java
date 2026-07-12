package p2092;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2092CTests extends AbstractOjTests {
    public CF2092CTests() {
        super("/p2092/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2092C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
