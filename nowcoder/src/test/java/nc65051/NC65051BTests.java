package nc65051;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65051BTests extends AbstractOjTests {
    public NC65051BTests() {
        super("/nc65051/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65051B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        NC65051B.main(null);
        super.doAssertion(OUTPUT2);
    }
}