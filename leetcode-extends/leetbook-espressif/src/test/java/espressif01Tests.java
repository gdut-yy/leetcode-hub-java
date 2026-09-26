import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class espressif01Tests extends AbstractOjTests {
    public espressif01Tests() {
        super("/espressif/01/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        espressif01.main(null);
        super.doAssertion(OUTPUT1);
    }
}
