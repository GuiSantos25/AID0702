package modelo;

public abstract class Veiculo {
    // Visibilidade protected para acesso controlado nas subclasses
    protected String matricula;
    protected String marca;
    protected double velocidadeAtual;
    protected double capacidadeDeposito;
    protected double nivelCombustivel;

    // Constante estática e imutável
    public static final double VELOCIDADE_MAXIMA_ABS = 250.0;

    public Veiculo(String matricula, String marca, double capacidadeDeposito) {
        setMatricula(matricula);
        this.marca = marca;
        setCapacidadeDeposito(capacidadeDeposito);
        this.velocidadeAtual = 0.0;
        this.nivelCombustivel = capacidadeDeposito; // Inicia atestado
    }

    // Método abstrato 1: cálculo específico de autonomia por tipologia
    public abstract double calcularAutonomia();

    // Método abstrato 2: descrição detalhada das características do veículo
    public abstract String descrever();

    // Método final para proteger o algoritmo crítico de aceleração contra override
    public final void acelerar(double incremento) {
        if (incremento < 0) {
            throw new IllegalArgumentException("O incremento de velocidade deve ser positivo.");
        }
        if (this.velocidadeAtual + incremento > VELOCIDADE_MAXIMA_ABS) {
            this.velocidadeAtual = VELOCIDADE_MAXIMA_ABS;
        } else {
            this.velocidadeAtual += incremento;
        }
    }

    // Getters e Setters com encapsulamento estrito e validações
    public String getMatricula() {
        return matricula;
    }

    public final void setMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty() || !matricula.matches("^[A-Z0-9]{2}-[A-Z0-9]{2}-[A-Z0-9]{2}$")) {
            throw new IllegalArgumentException("Formato de matrícula inválido. Exemplo esperado: AA-00-AA");
        }
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public double getCapacidadeDeposito() {
        return capacidadeDeposito;
    }

    public void setCapacidadeDeposito(double capacidadeDeposito) {
        if (capacidadeDeposito <= 0) {
            throw new IllegalArgumentException("A capacidade do depósito deve ser estritamente positiva.");
        }
        this.capacidadeDeposito = capacidadeDeposito;
    }

    public double getNivelCombustivel() {
        return nivelCombustivel;
    }

    public void setNivelCombustivel(double nivelCombustivel) {
        if (nivelCombustivel < 0 || nivelCombustivel > capacidadeDeposito) {
            throw new IllegalArgumentException("Nível de combustível fora dos limites permitidos.");
        }
        this.nivelCombustivel = nivelCombustivel;
    }
}