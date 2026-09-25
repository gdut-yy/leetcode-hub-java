import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DDBook25Tests extends AbstractOjTests {
    public DDBook25Tests() {
        super("/didi/book25/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        DDBook25.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        DDBook25.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        DDBook25.main(null);
        super.doAssertion(OUTPUT3);
    }
}
