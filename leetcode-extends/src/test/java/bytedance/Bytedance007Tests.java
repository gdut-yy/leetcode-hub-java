package bytedance;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Bytedance007Tests extends AbstractOjTests {
    public Bytedance007Tests() {
        super("/bytedance/07/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Bytedance007.main(null);
        super.doAssertion();
    }
}
