package p295;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF295ETests extends AbstractOjTests {
    public CF295ETests() {
        super("/p295/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF295E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
