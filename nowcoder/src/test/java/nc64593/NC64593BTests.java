package nc64593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC64593BTests extends AbstractOjTests {
    public NC64593BTests() {
        super("/nc64593/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC64593B.main(null);
        super.doAssertion(OUTPUT1);
    }
}