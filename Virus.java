import java.io.*;
import java.util.*;

public class Virus extends Organisme {
  protected int numero;
  protected static int cpt=0;
  Virus(int case_X, int case_Y){
    super(case_X,case_Y,5);
    numero = cpt;
    cpt ++;
  }


  public void affiche(){
    System.out.print("[##]");
  }


  public int test(int a, int b){
    return 4;
  }


  public boolean Menu_deplacements(Case[][] grille){
    if (mouvement){
      System.out.println("T'es un virus caca ");
      boolean valide2=false;
      while (!valide2){
        System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
        System.out.println("-> Pour plus de confort, utiliser le pavé numérique.");
        System.out.println("8. Haut");
        System.out.println("2. Bas");
        System.out.println("6. Droite");
        System.out.println("4. Gauche");
        int choix = saisie_entier();
        int check;
        if (((case_Y-1>=0) || (choix!=8)) && ((case_Y+1<20) || (choix!=2)) && ((case_X-1>=0) || (choix!=4)) && ((case_X+1<20) || (choix!=6))){
          switch (choix){
            case 8 :
            check=grille[case_Y-1][case_X].test(case_Y,case_X);
            set_Y(-1,check,grille);
            System.out.println("En haut");
            break;
            case 2 :
            check=grille[case_Y+1][case_X].test(case_Y,case_X);
            set_Y(1,check,grille);
            System.out.println("En bas");
            break;
            case 6 :
            check=grille[case_Y][case_X+1].test(case_Y,case_X);
            set_X(1,check,grille);
            System.out.println("A droite");
            break;
            case 4 :
            check=grille[case_Y][case_X-1].test(case_Y,case_X);
            set_X(-1,check,grille);
            System.out.println("A gauche");
            break;
            default : System.out.println("Erreur de saisie !");break;
          }
          valide2=true;
        }
        else {
          System.out.println("Mouvement hors Elsa SUPER relou");
        }
      }
      mouvement=false;
      return true;
    }
    else {
      System.out.println("Le virus que vous avez sélectionné a déjà été déplacé !");
      return false;
    }
  }


  public static String infection(){
    return "Rien";
  }

}
