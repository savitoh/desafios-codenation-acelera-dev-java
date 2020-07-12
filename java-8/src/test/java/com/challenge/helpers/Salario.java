package com.challenge.helpers;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class Salario {

    @Somar
    private BigDecimal salarioBruto;
    @Subtrair
    private BigDecimal inss;
    @Subtrair
    private BigDecimal planoSaude;
    @Somar
    private BigDecimal valeRefeicao;


    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public BigDecimal getInss() {
        return inss;
    }

    public void setInss(BigDecimal inss) {
        this.inss = inss;
    }

    public BigDecimal getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(BigDecimal planoSaude) {
        this.planoSaude = planoSaude;
    }

    public BigDecimal getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(BigDecimal valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }
    
}