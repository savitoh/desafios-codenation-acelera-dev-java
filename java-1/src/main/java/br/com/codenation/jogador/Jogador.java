package br.com.codenation.jogador;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Jogador {

    private static final short MENOR_VALOR_HABILIDADE_PERMITIDA = 0;

    private static final short MAIOR_VALOR_HABILIDADE_PERMITIDA = 100;

    private final Long id;

    private final String nome;

    private final LocalDate dataNascimento;

    private final Integer nivelHabilidade;

    private final BigDecimal salario;

    public Jogador(Long id, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        if(nivelHabilidade < MENOR_VALOR_HABILIDADE_PERMITIDA || nivelHabilidade > MAIOR_VALOR_HABILIDADE_PERMITIDA) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public boolean ehIdDoJogador(Long id) {
        return this.id.equals(id);
    }

    public int comparatorIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period period = Period.between(dataAtual, dataNascimento);
        return period.getDays();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogador other = (Jogador) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}