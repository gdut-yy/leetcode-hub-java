package template;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Base64_11Tests extends AbstractOjTests {
    public Base64_11Tests() {
        super("/template/");
    }

    @Test
    public void test() throws IOException {
        super.doSetSystemInOut("Base64_11-input.txt");
        Base64_11.main(null);
        super.doAssertion("Base64_11-output.txt");
    }
}
