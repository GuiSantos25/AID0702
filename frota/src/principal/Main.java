package principal;

import modelo.Carro;
import modelo.Mota;
import modelo.Camiao;
import servico.GestorFrota;
import servico.RelatorioService;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>> Inicializando o Sistema de Gestão de Frota...\n");

        GestorFrota gestor = new GestorFrota();
        RelatorioService relatorioService = new RelatorioService();

        // 1. Instanciação e adição de veículos válidos
        try {
            Carro carro = new Carro("AA-11-BB", "Volkswagen", 50.0, 5);
            Mota mota = new Mota("CC-22-DD", "Honda", 15.0, 500);
            Camiao camiao = new Camiao("EE-33-FF", "Volvo", 300.0, 18.0);

            // Demonstração de método final herdado
            carro.acelerar(50.0);

            gestor.adicionarVeiculo(carro);
            gestor.adicionarVeiculo(mota);
            gestor.adicionarVeiculo(camiao);

        } catch (IllegalArgumentException e) {
            System.err.println("Erro inesperado na criação inicial: " + e.getMessage());
        }

        // 2. Emissão do relatório operacional
        relatorioService.emitirRelatorioGeral(gestor);

        // 3. Teste de Validação / Exceção 1: Matrícula Inválida
        System.out.println(">>> Teste de Validação: Matrícula Inválida");
        try {
            Carro carroInvalido = new Carro("MATRICULA-ERRADA", "BMW", 55.0, 3);
            gestor.adicionarVeiculo(carroInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("Sucesso (Exceção Capturada): " + e.getMessage() + "\n");
        }

        // 4. Teste de Validação / Exceção 2: Capacidade de Depósito Negativa
        System.out.println(">>> Teste de Validação: Depósito Negativo");
        try {
            Mota motaInvalida = new Mota("GG-44-HH", "Yamaha", -10.0, 250);
            gestor.adicionarVeiculo(motaInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Sucesso (Exceção Capturada): " + e.getMessage() + "\n");
        }
    }
}