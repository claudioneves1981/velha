import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Velha {

    static short[] numbers = new short[]{1,2,3,4,5,6,7,8,9};
    static String[] tab = new String[]{"_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ ", "_ "};
    static boolean human = true;
    static Scanner scanner = new Scanner(System.in);
    static short posicao;

    public static void main(String[] args) {


       System.out.println("Jogo da Velha");
       System.out.println("Você é o X");
       tabuleiro();

       do {
           System.out.println("Digite uma posição de 1 a 9, sendo 1, 2,3, a parte superior, 4,5,6  o meio, e 7,8,9 a ṕarte inferior do tabuleiro");
           posicao = scanner.nextShort();
           jogada(posicao, true);
       }while(posicao > 0 && posicao <= 9);

    }

    public static void tabuleiro(){
        for(short i = 0 ; i < 9; i++){

           if(i%3 == 0){
               System.out.println();
           }
            System.out.print(tab[i]);
        }

    }



    public static void jogada(short posicaoTabuleiro, boolean human){

       if(numbers[posicaoTabuleiro-1] == 0){
           System.out.print("Essa posicão ja está marcada tente outra");
      }



        if(human) {
            if (Objects.equals(tab[posicaoTabuleiro - 1], "_ ")) {
                tab[posicaoTabuleiro - 1] = "X ";
                do {
                    posicao = (short) (Math.random() * 9);
                } while (numbers[posicao] == 0);
                if (Objects.equals(tab[posicao], "_ ")) {
                    if (numbers[posicao] != 0) {
                        tab[posicao] = "O ";
                        numbers[posicao] = 0;
                        //jogada(posicao, true);
                        // tabuleiro();
                    }
                    jogada(posicaoTabuleiro, false);
                    tabuleiro();
                }

            }
        }


        //numbers[posicaoTabuleiro-1] = 0;
    }

}