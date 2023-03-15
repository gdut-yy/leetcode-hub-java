package bytedance;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance010Tests extends AbstractOjTests {
    public Bytedance010Tests() {
        super("/bytedance/10/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Bytedance010.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Bytedance010.main(null);
        super.doAssertion(OUTPUT2);
    }
}
