import java.util.InputMismatchException;
import java.util.Scanner;
/* Projeto */

public class ControleDeFluxo {

    public static void main(String[] args) {
        limparTerminal();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean parametrosInvalidos;
            
            do {
                System.out.println("Informe o primeiro parâmetro:");
                int parametroUm = obterInteiro(scanner);

                System.out.println("Informe o segundo parâmetro:");
                int parametroDois = obterInteiro(scanner);

                parametrosInvalidos = validarParametros(parametroUm, parametroDois);

                if (parametrosInvalidos) {
                    System.out.println("Por favor, informe novamente os parâmetros. O primeiro número deve ser menor que o segundo.");
                } else {
                    int quantidadeIteracoes = calcularQuantidadeIteracoes(parametroUm, parametroDois);
                    System.out.println("Começando a iterar:");

                    for (int x = 0; x < quantidadeIteracoes; x++) {
                        System.out.println("Iteração: " + (x + 1));
                    }
                }
            } while (parametrosInvalidos);
        }
    }

    private static int obterInteiro(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, informe um número inteiro válido.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }
    }

    private static boolean validarParametros(int parametroUm, int parametroDois) {
        return parametroUm > parametroDois;
    }

    private static int calcularQuantidadeIteracoes(int parametroUm, int parametroDois) {
        return parametroDois - parametroUm;
    }

    private static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
