package bytedance;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance003Tests extends AbstractOjTests {
    public Bytedance003Tests() {
        super("/bytedance/03/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Bytedance003.main(null);
        super.doAssertion();
    }
}
