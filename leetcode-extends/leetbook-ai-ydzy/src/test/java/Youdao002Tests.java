import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Youdao002Tests extends AbstractOjTests {
    public Youdao002Tests() {
        super("/youdao/002/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        Youdao002.main(null);
        super.doAssertion();
    }
}
