package nc64593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC64593CTests extends AbstractOjTests {
    public NC64593CTests() {
        super("/nc64593/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC64593C.main(null);
        super.doAssertion(OUTPUT1);
    }
}