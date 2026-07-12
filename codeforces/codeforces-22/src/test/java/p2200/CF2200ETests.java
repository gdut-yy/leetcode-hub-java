package p2200;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2200ETests extends AbstractOjTests {
    public CF2200ETests() {
        super("/p2200/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2200E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
