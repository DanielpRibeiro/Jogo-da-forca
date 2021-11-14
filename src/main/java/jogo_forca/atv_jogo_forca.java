/*
Logica de programção em Java, jogo da forca.
 */
package jogo_forca;

/**
 *
 * @author daniel
 */
import java.util.Scanner;

public class atv_jogo_forca {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String palavra = "daniel";
        String letraUsada = "";
        String palavraAdivinhada = "";

        int MAXtentativas = 10;
        //System.out.println("Insira a palavra: ");
        //palavra = input.next();
        //System.out.println("inserida : "+palavra);
        for (int i = 0; i < palavra.length(); i++) {
            palavraAdivinhada += "_";

            for (int tentativas = 1;; tentativas++) {
                if (tentativas == MAXtentativas) {
                    System.out.println("\nforam usadas todas as tentativas... A palavra era " + palavra + "\n");
                    System.exit(0);

                }
                System.out.println("Rodada " + tentativas + ". Até agora advinhadas " + palavraAdivinhada + " ; Qual sua proxima letra ?");

                char letraTentada = input.next().charAt(0);

                if (letraUsada.indexOf(letraTentada) >= 0) {
                    System.out.println("Você já tentou a letra' " + letraTentada + "'");
                } else {
                    letraUsada += letraTentada;

                    if (palavra.indexOf(letraTentada) >= 0) {
                        palavraAdivinhada = "";

                        for (int j = 0; j < palavra.length(); j++) {
                            palavraAdivinhada += letraUsada.indexOf(palavra.charAt(j)) >= 0 ? palavra.charAt(j) : "e_";
                        }
                        if (palavraAdivinhada.contains("_")) {
                            System.out.println("Muito Bom! " + letraTentada + " Existe na palvra. Continue...");
                        } else {
                            System.out.println("Parabéns!! A PALAVRA ADIVINHADA ERA '" + palavra + "' ");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Infelizmente a letra '" + letraTentada + "' não existe na palavra.");
                    }
                }
            }
        }

    }

}
