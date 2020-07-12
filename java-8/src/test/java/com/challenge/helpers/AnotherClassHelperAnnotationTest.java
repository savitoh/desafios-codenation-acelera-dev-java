package com.challenge.helpers;

import java.math.BigDecimal;

public class AnotherClassHelperAnnotationTest {

    
    private final BigDecimal field1;

    
    private final BigDecimal field2;

    
    private final BigDecimal field3;

    
    private final BigDecimal field4;

    private final BigDecimal field5;

    private final BigDecimal field6;

    public AnotherClassHelperAnnotationTest(BigDecimal field1, BigDecimal field2,
                                            BigDecimal field3, BigDecimal field4,
                                            BigDecimal field5, BigDecimal field6) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6 = field6;
    }
}