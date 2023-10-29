package tenka1_2019;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Tenka12019dTests extends AbstractOjTests {
    public Tenka12019dTests() {
        super("/tenka1_2019/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Tenka1_2019_d.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Tenka1_2019_d.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Tenka1_2019_d.main(null);
        super.doAssertion(OUTPUT3);
    }
}