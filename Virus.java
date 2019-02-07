import java.io.*;
import java.util.*;

public class Virus extends Organisme {
  protected int numero;
  protected boolean mouvement=true;
  protected static int cpt=0;
  Virus(int case_X, int case_Y){
    super(case_X,case_Y,5);
    numero = cpt;
    cpt ++;
  }

  public void affiche(){
    System.out.print("[##]");
  }

  // public boolean set_X(int x){
  //   int tmp=case_X+x;
  //   if ((tmp<20) || (tmp>=0)){
  //     case_X+=x;
  //     return true;
  //   }
  //   return false;
  // }

  public boolean Menu_deplacements(){
    System.out.println("T'es un virus caca ");
    // System.out.println(case_X+"    "+case_Y);
    boolean valide2=false;
    while (!valide2){
      System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
      System.out.println("-> Pour plus de confort, utiliser le pavé numérique.");
      System.out.println("8. Haut");
      System.out.println("2. Bas");
      System.out.println("6. Droite");
      System.out.println("4. Gauche");
      int choix = saisie_entier();
      switch (choix){
        case 8 : valide2=set_Y(-1);System.out.println("En haut");break;
        case 2 : valide2=set_Y(1);System.out.println("En bas");break;
        case 6 : valide2=set_X(1);System.out.println("A droite");break;
        case 4 : valide2=set_X(-1);System.out.println("A gauche");break;
        default : System.out.println("Erreur de saisie !");
      }
    }
    System.out.println(case_X+"    "+case_Y);
    return true;
  }
  //
  // public static int fusion(){
  //   return 2;
  // }
  //
  //
  // public static String infection(){
  //   return "Infection";
  // }

  public static String infection(){
    return "Rien";
  }
}
