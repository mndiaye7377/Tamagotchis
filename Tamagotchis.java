import static java.lang.Math.abs;

public class Tamagotchis{
    private int age;
    private final int dureeDeVie;
    private final int maxEnergie;
    private int energie; 
    public final String nom;


    public int rand(int max,int min) {
        return (int) (Math.random() * 5) + 9;
    }

    public Tamagotchis(String nom){
        this.age = 0;
        this.dureeDeVie = rand(9,14);
        this.maxEnergie = rand(5,9);
        this.energie = rand(3,this.maxEnergie);
        this.nom = nom;
    }

    public void parler(){
        System.out.println(nom);
        if(energie>5){
            System.out.println("tout va bien !");
        }
        else{
            System.out.println("je suis affamé");
        }
    }

    public void manger(){
        if(energie<maxEnergie){
            System.out.println("Merci !");
            energie += rand(1,3);
            if(energie>maxEnergie){
                energie = maxEnergie;
            }
        }
        else if(energie==maxEnergie){
            System.out.println("je n'ai pas faim !!");
        }
    }

    public boolean ageLimit(){
        if(age == dureeDeVie) {
            return true;
        }
        return false;
    }



    public boolean vivre() {


        if (ageLimit()) {
            return ageLimit();
        }



        if (energie <= 0) {
            System.out.println("je meurs... Arrrggh");
            SimulTamagotchis.gameEnded = true;
            return false;
        }


        if(energie>5){
            age++;
            energie--;


            if (ageLimit()) {
                System.out.println("En ayant atteint mon ageLimite ,Satisfait de Vivre encore plus grace a mon energie");
                return false;
            }






        }
        return true;
    }

}