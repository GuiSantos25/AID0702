package modelo;

public class Mota extends Veiculo {
    private int cilindrada;
    private static final double CONSUMO_MEDIO_L100 = 3.5; // litros / 100km

    public Mota(String matricula, String marca, double capacidadeDeposito, int cilindrada) {
        super(matricula, marca, capacidadeDeposito);
        setCilindrada(cilindrada);
    }

    @Override
    public double calcularAutonomia() {
        return (nivelCombustivel / CONSUMO_MEDIO_L100) * 100;
    }

    @Override
    public String descrever() {
        return String.format("Mota  | Marca: %s | Matrícula: %s | Cilindrada: %d cc | Autonomia: %.1f km",
                marca, matricula, cilindrada, calcularAutonomia());
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        if (cilindrada <= 0) {
            throw new IllegalArgumentException("A cilindrada deve ser estritamente positiva.");
        }
        this.cilindrada = cilindrada;
    }
}