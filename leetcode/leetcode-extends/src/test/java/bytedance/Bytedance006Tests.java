package bytedance;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance006Tests extends AbstractOjTests {
    public Bytedance006Tests() {
        super("/bytedance/06/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Bytedance006.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Bytedance006.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Bytedance006.main(null);
        super.doAssertion(OUTPUT3);
    }
}
