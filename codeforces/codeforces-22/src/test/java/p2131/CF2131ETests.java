package p2131;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2131ETests extends AbstractOjTests {
    public CF2131ETests() {
        super("/p2131/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2131E.main(null);
        super.doAssertion(OUTPUT1);
    }
}
