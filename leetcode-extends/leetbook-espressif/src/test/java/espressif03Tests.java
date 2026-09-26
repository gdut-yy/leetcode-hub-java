import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class espressif03Tests extends AbstractOjTests {
    public espressif03Tests() {
        super("/espressif/03/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        espressif03.main(null);
        super.doAssertion(OUTPUT1);
    }
}
