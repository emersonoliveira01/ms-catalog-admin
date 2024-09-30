package com.stream.catalog.admin.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main() {
        Assertions.assertNotNull(new Main());
        Main.main(new String[]{});
    }
}