import static java.lang.Character.isDigit;

import java.util.*;

public class SimulTamagotchis {

    //tableau en attribut de classe
    private static Tamagotchis[] listeTamagotchis;
    public static boolean gameEnded;
    private static int cycle;

    public static void createTamagotchis(){
        System.out.println("Entrer le nombre de Tamagotchis a adopter: ");
        Scanner sc_number = new Scanner(System.in);
        int n = sc_number.nextInt();

        //initialisation du tableau avec la taille 'n' saisie
        listeTamagotchis = new Tamagotchis[n];

        for(int i = 0; i < n; i++) {
            System.out.println("Quel nom pour le nouveau  tamagotchi " + (i+1) + ": ");
            Scanner sc_nom = new Scanner(System.in);
            String nom = sc_nom.nextLine();

            // Remplissage du tableau
            listeTamagotchis[i] = new Tamagotchis(nom);
        }
    }
    // ...

    public static int chooseTamagotchis(){
        System.out.println("Nourrir quel tamagotchi ?");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    public static void runtime() {

            for(int i = 0; i < listeTamagotchis.length; i++) {
                listeTamagotchis[i].vivre();
                if (!(listeTamagotchis[i].ageLimit())) {
                    gameEnded = false;
                    break;
                }
                else {
                    gameEnded = true;
                }
            }

            while (!gameEnded) {
                int choice = chooseTamagotchis();
                if(choice<listeTamagotchis.length && choice>=0) {
                    listeTamagotchis[choice].manger();
                }
            }
    }


    public static void main() {

        createTamagotchis();

        if(!gameEnded) {

        System.out.println("-------Cycle no " + (cycle+1) + " -------");

        for(int i=0;i<listeTamagotchis.length;i++) {
            listeTamagotchis[i].parler();
        }

        for(int i=0;i<listeTamagotchis.length;i++) {
            System.out.println("\n");
            System.out.println("(" + i + ")" + listeTamagotchis[i].nom + "\n");
        }


            runtime();
            cycle++;
        }

    }
}