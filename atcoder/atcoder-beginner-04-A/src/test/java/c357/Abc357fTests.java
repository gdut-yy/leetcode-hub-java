package c357;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc357fTests extends AbstractOjTests {
    public Abc357fTests() {
        super("/c357/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc357_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc357_f.main(null);
        super.doAssertion(OUTPUT2);
    }
}
