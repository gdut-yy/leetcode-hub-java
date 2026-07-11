package p1303;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1303ETests extends AbstractOjTests {
    public CF1303ETests() {
        super("/p1303/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1303E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
