import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Youdao001Tests extends AbstractOjTests {
    public Youdao001Tests() {
        super("/youdao/001/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Youdao001.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Youdao001.main(null);
        super.doAssertion(OUTPUT2);
    }
}
