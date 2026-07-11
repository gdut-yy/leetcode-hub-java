package p2112;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2112DTests extends AbstractOjTests {
    public CF2112DTests() {
        super("/p2112/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2112D.main(null);
        // 答案不唯一
//        super.doAssertion(OUTPUT1);
    }
}
