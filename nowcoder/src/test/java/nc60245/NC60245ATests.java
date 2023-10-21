package nc60245;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NC60245ATests extends AbstractOjTests {
    public NC60245ATests() {
        super("/nc60245/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        NC60245A.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        NC60245A.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        NC60245A.main(null);
        super.doAssertion(OUTPUT3);
    }
}