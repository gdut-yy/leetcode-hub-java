package nc60245;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60245CTests extends AbstractOjTests {
    public NC60245CTests() {
        super("/nc60245/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60245C.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        NC60245C.main(null);
        super.doAssertion(OUTPUT2);
    }
}