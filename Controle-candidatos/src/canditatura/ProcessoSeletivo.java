package canditatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {

        System.out.println("Pocesso Seletivo");

        selecaoCanditados();

    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println(candidato + " - Contato realizado com sucesso!");
            }

        } while (continuarTentando && tentativasRealizadas < 3);
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void selecaoCanditados() {

        String[] candidatos = { "FELIPE", "MARIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };

        int candidatosSelecionados = 0;
        int canditadoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && canditadoAtual < candidatos.length) {

            double salarioPretendito = valorPretendido();

            if (salarioBase >= salarioPretendito) {
                candidatosSelecionados++;

                imprimirSelecionados(canditadoAtual);
                entrandoEmContato(candidatos[canditadoAtual]);
            }
            canditadoAtual++;
        }
    }

    static void imprimirSelecionados(int indice) {
        String[] candidatos = { "FELIPE", "MARIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };

        double salarioPretendito = valorPretendido();

        System.out.println("\nO canditado " + candidatos[indice] + " foi selecionado");
        
        analisarCandidato(salarioPretendito);

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato!");

        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta!");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos!");
        }
    }
}
