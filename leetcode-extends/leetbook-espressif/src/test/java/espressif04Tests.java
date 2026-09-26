import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class espressif04Tests extends AbstractOjTests {
    public espressif04Tests() {
        super("/espressif/04/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        espressif04.main(null);
        super.doAssertion(OUTPUT1);
    }
}
