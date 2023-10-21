package nc64593;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC64593ATests extends AbstractOjTests {
    public NC64593ATests() {
        super("/nc64593/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC64593A.main(null);
        super.doAssertion(OUTPUT1);
    }
}