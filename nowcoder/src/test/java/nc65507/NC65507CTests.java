package nc65507;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC65507CTests extends AbstractOjTests {
    public NC65507CTests() {
        super("/nc65507/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC65507C.main(null);
        super.doAssertion(OUTPUT1);
    }
}