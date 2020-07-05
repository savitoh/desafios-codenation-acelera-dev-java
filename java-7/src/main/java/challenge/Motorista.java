package challenge;

import java.util.Objects;

public class Motorista {

    private static final int PONTUACAO_MAXIMA_SUSPENDER = 20;

    private static final int IDADE_SENIOR = 56;

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) { 
        Objects.requireNonNull(nome);
        Objects.requireNonNull(habilitacao);
        this.nome = nome;
        this.idade = idade;
        this.pontos = pontos;
        this.habilitacao = habilitacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public boolean ehMenorIdade() {
        return this.idade < 18;
    }


    public boolean habilitacaoEstaSuspensa() {
        return pontos > PONTUACAO_MAXIMA_SUSPENDER;
    }

    public boolean ehSenior() {
        return idade >= IDADE_SENIOR;
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if(idade < 0) {
                throw new IllegalArgumentException("Idade não pode ser menor do que o (:");
            }
            this.idade = idade;
            return this;
        }

        public MotoristaBuilder withPontos(int pontos) {
            if(pontos < 0) {
                throw new IllegalArgumentException("Pontos não podem ser negativo (:");
            }
            this.pontos = pontos;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            Objects.requireNonNull(habilitacao);
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((habilitacao == null) ? 0 : habilitacao.hashCode());
        result = prime * result + idade;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + pontos;
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
        Motorista other = (Motorista) obj;
        if (habilitacao == null) {
            if (other.habilitacao != null)
                return false;
        } else if (!habilitacao.equals(other.habilitacao))
            return false;
        if (idade != other.idade)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (pontos != other.pontos)
            return false;
        return true;
    }

    
}
