package p1560;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1560F2Tests extends AbstractOjTests {
    public CF1560F2Tests() {
        super("/p1560/F2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1560F2.main(null);
        super.doAssertion(OUTPUT1);
    }
}
