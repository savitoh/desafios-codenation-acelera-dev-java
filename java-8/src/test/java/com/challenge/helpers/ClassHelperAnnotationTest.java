package com.challenge.helpers;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class ClassHelperAnnotationTest {

    @Somar
    private final BigDecimal field1;

    @Somar
    private final BigDecimal field2;

    @Subtrair
    private final BigDecimal field3;

    @Subtrair
    private final BigDecimal field4;

    private final BigDecimal field5;

    private final BigDecimal field6;

    public ClassHelperAnnotationTest(final BigDecimal field1, final BigDecimal field2, final BigDecimal field3,
                                     final BigDecimal field4, final BigDecimal field5, final BigDecimal field6) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
    }
}
