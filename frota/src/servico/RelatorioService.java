package servico;

import modelo.Veiculo;

public class RelatorioService {

    // Visibilidade package-private (sem modificador explicitado)
    // Permite que componentes do package servico utilizem este utilitário de formatação,
    // ocultando-o de invocações diretas no package principal.
    static String formatarLinhaRelatorio(Veiculo veiculo) {
        return "[REGISTO FROTA] " + veiculo.descrever();
    }

    public void emitirRelatorioGeral(GestorFrota gestor) {
        System.out.println("==========================================================");
        System.out.println("            RELATÓRIO OPERACIONAL DA FROTA                ");
        System.out.println("==========================================================");
        for (Veiculo v : gestor.getFrota()) {
            System.out.println(formatarLinhaRelatorio(v));
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("Autonomia Média Global: %.2f km\n", gestor.calcularAutonomiaMedia());
        System.out.println("==========================================================\n");
    }
}