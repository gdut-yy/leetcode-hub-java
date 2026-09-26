import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class espressif02Tests extends AbstractOjTests {
    public espressif02Tests() {
        super("/espressif/02/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        espressif02.main(null);
        super.doAssertion(OUTPUT1);
    }
}
