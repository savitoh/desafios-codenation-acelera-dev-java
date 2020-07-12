package com.challenge.desafio;

import com.challenge.helpers.ClassHelperAnnotationTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculadorDeClassesTest {

    private final CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();

    @Test
    public void somar() throws IllegalAccessException {

        ClassHelperAnnotationTest test = new ClassHelperAnnotationTest(
                BigDecimal.valueOf(40.25), BigDecimal.valueOf(20.25),
                BigDecimal.valueOf(20.25), BigDecimal.valueOf(10.25),
                BigDecimal.valueOf(10.50), BigDecimal.valueOf(10.50));


        BigDecimal resultadoSoma = calculadorDeClasses.somar(test);


        Assert.assertNotNull(resultadoSoma);
        Assert.assertEquals(BigDecimal.valueOf(60.50).setScale(2), resultadoSoma);
    }

    @Test
    public void subtrair() throws IllegalAccessException {

        ClassHelperAnnotationTest test = new ClassHelperAnnotationTest(
                BigDecimal.valueOf(40.25), BigDecimal.valueOf(20.25),
                BigDecimal.valueOf(20.25), BigDecimal.valueOf(10.25),
                BigDecimal.valueOf(10.50), BigDecimal.valueOf(10.50));


        BigDecimal resultadoSubtracao = calculadorDeClasses.subtrair(test);

        Assert.assertNotNull(resultadoSubtracao);
        Assert.assertEquals(BigDecimal.valueOf(30.50).setScale(2), resultadoSubtracao);

    }

    @Test
    public void total() throws IllegalAccessException {

        ClassHelperAnnotationTest test = new ClassHelperAnnotationTest(
                BigDecimal.valueOf(40.25), BigDecimal.valueOf(20.25),
                BigDecimal.valueOf(20.25), BigDecimal.valueOf(10.25),
                BigDecimal.valueOf(10.50), BigDecimal.valueOf(10.50));

        BigDecimal total = calculadorDeClasses.totalizar(test);

        Assert.assertNotNull(total);
        Assert.assertEquals(BigDecimal.valueOf(30).setScale(2), total);

    }
}