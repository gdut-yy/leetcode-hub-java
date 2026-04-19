package p1982;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1982DTests extends AbstractOjTests {
    public CF1982DTests() {
        super("/p1982/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1982D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
