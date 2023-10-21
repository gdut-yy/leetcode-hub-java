package nc64593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC64593DTests extends AbstractOjTests {
    public NC64593DTests() {
        super("/nc64593/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC64593D.main(null);
        super.doAssertion(OUTPUT1);
    }
}