package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal somar(Object object, List<Predicate<Field>> rules) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        BigDecimal somatorioCampo = BigDecimal.ZERO;
        for(Field field: fields) {
            field.setAccessible(true);
            if(field.getType().isNestmateOf(BigDecimal.class) && rules.stream().reduce(x -> true, Predicate::and).test(field)) {
                BigDecimal valor = (BigDecimal) field.get(object);
                somatorioCampo = somatorioCampo.add(valor);
            }
        }
        return somatorioCampo;
    }

    @Override
    public BigDecimal somar(Object object) throws IllegalAccessException {
        Predicate<Field> regraSomar = field -> Objects.nonNull(field.getAnnotation(Somar.class));
        return somar(object, Arrays.asList(regraSomar));
    }

    @Override
    public BigDecimal subtrair(Object object) throws IllegalAccessException {
        Predicate<Field> regraSubtracao = field -> Objects.nonNull(field.getAnnotation(Subtrair.class));
        return somar(object, Arrays.asList(regraSubtracao));
    }

    @Override
    public BigDecimal totalizar(Object object) throws IllegalAccessException {
        BigDecimal resultadoSoma = somar(object);
        BigDecimal resultadoSubtracao = subtrair(object);
        return resultadoSoma.subtract(resultadoSubtracao);
    }
    
}