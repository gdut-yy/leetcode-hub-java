package bytedance;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance004Tests extends AbstractOjTests {
    public Bytedance004Tests() {
        super("/bytedance/04/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Bytedance004.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Bytedance004.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Bytedance004.main(null);
        super.doAssertion(OUTPUT3);
    }
}
