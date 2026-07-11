package p2171;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2171ETests extends AbstractOjTests {
    public CF2171ETests() {
        super("/p2171/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2171E.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
