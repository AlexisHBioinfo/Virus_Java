import java.io.*;
import java.util.*;
abstract public class Organisme extends Case{
  protected int point_de_vie;
  protected boolean mouvement=true;
  public Organisme (int case_X, int case_Y, int hp){
    super(case_X,case_Y);
    point_de_vie=hp;
  }


  public boolean Menu_deplacements(Case[][] grille, boolean type){
    if (mouvement){
      boolean valide2=false;
      while (!valide2){
        System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
        System.out.println("-> Pour plus de confort, utilisez le pavé numérique.");
        System.out.println("8. Haut");
        System.out.println("2. Bas");
        System.out.println("6. Droite");
        System.out.println("4. Gauche");
        int choix = saisie_entier();
        int check;
        if (((case_Y-1>=0) || (choix!=8)) && ((case_Y+1<20) || (choix!=2)) && ((case_X-1>=0) || (choix!=4)) && ((case_X+1<20) || (choix!=6))){
          switch (choix){
            case 8 :
            check=grille[case_Y-1][case_X].consequences(case_Y,case_X,type,"joueur");
            set_Y(-1,check,grille);
            System.out.println("En haut");
            break;
            case 2 :
            check=grille[case_Y+1][case_X].consequences(case_Y,case_X,type,"joueur");
            set_Y(1,check,grille);
            System.out.println("En bas");
            break;
            case 6 :
            check=grille[case_Y][case_X+1].consequences(case_Y,case_X,type,"joueur");
            set_X(1,check,grille);
            System.out.println("A droite");
            break;
            case 4 :
            check=grille[case_Y][case_X-1].consequences(case_Y,case_X,type,"joueur");
            set_X(-1,check,grille);
            System.out.println("A gauche");
            break;
            default : System.out.println("Erreur de saisie !");break;
          }
          valide2=true;
        }
        else {
          System.out.println("Mouvement hors limite ?");
        }
      }
      stop_mouvement();
      return true;
    }
    else {
      System.out.println("L'organisme que vous avez sélectionné a déjà été déplacé !");
      return false;
    }
  }


  public int consequences(int a,int b,boolean type, String joueur){
    return 0;
  }


  public void set_X(int a, int b, Case[][] grille){return;}


  public void set_Y(int a, int b, Case[][] grille){return;}


  public Infectee get_infectee(){
    return null;
  }


  public void stop_mouvement(){
    mouvement=false;
  }


  public void set_statut(){
    super.set_statut();
  }



  public void maj_compteurs(){
    mouvement=true;
  }


  public int test_case(){
    return 99;
  }
}
