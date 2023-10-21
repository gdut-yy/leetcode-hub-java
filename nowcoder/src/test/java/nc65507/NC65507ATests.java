package nc65507;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65507ATests extends AbstractOjTests {
    public NC65507ATests() {
        super("/nc65507/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65507A.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        NC65507A.main(null);
        super.doAssertion(OUTPUT2);
    }
}