package codefestival2016;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Codefestival2016QualCCTests extends AbstractOjTests {
    public Codefestival2016QualCCTests() {
        super("/codefestival2016/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Codefestival_2016_qualC_c.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Codefestival_2016_qualC_c.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Codefestival_2016_qualC_c.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Codefestival_2016_qualC_c.main(null);
        super.doAssertion(OUTPUT4);
    }
}