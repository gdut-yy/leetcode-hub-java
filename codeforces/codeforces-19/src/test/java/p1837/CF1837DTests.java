package p1837;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1837DTests extends AbstractOjTests {
    public CF1837DTests() {
        super("/p1837/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1837D.main(null);
        // 答案不唯一
//        super.doAssertion();
    }
}