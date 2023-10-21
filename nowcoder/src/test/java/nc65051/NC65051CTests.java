package nc65051;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65051CTests extends AbstractOjTests {
    public NC65051CTests() {
        super("/nc65051/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65051C.main(null);
        super.doAssertion(OUTPUT1);
    }
}