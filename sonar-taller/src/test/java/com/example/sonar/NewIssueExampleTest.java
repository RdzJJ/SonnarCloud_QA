package com.example.sonar;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NewIssueExampleTest {
    @Test
    void testCompute() {
        assertEquals(4, new NewIssueExample().compute(2));
    }
}
