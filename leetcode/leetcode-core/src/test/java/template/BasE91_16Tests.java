package template;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BasE91_16Tests extends AbstractOjTests {
    public BasE91_16Tests() {
        super("/template/");
    }

    @Test
    public void test() throws IOException {
        super.doSetSystemInOut("BasE91_16-input.txt");
        BasE91_16.main(null);
        super.doAssertion("BasE91_16-output.txt");
    }
}
