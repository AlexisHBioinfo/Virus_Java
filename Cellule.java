import java.io.*;
import java.util.*;
abstract public class Cellule extends Organisme {
  protected static int cpt =0;
  public Cellule (int case_X, int case_Y){
    super(case_X,case_Y);
    cpt++;
  }


  //////////////////    AFFICHAGE DE CELLULE (JOUEUR VIRUS)     ////////////////////////////


  public void affiche(String type){
    System.out.print("[cc]");
  }


///////////////////////      MENUS SPECIFIQUE AUX CELLULES     ////////////////////////////////

  public boolean Menu_deplacements(Case[][] grille,boolean type){
    if (type){
      System.out.println("Vous avez sélectionné une cellule !");
      super.Menu_deplacements(grille,true);
      return true;
    }
    else {
      System.out.println("Vous essayez de déplacer une cellule alors que vous êtes le joueur VIRUS ! Try again.");
      return false;
    }
  }


  public boolean Menu_deplacements_ordi(Case[][] grille, boolean type){
    String type_cell=test_type();
    if (mouvement){
      boolean valide2=false;
      Random rand = new Random();
      while (!valide2){
        int choix=rand.nextInt(4);
        int check;
        if (((case_Y-1>=0) || (choix!=0)) && ((case_Y+1<20) || (choix!=1)) && ((case_X-1>=0) || (choix!=3)) && ((case_X+1<20) || (choix!=2))){
          switch (choix){
            case 0 : // Haut
              check=grille[case_Y-1][case_X].consequences(case_Y,case_X,type,"ordinateur",type_cell);
              if (check!=4){
                set_Y(-1,check,grille);
              }
              break;
            case 1 : // Bas
              check=grille[case_Y+1][case_X].consequences(case_Y,case_X,type,"ordinateur",type_cell);
              if (check!=4){
                set_Y(1,check,grille);
              }
              break;
            case 2 : // Droite
              check=grille[case_Y][case_X+1].consequences(case_Y,case_X,type,"ordinateur",type_cell);
              if (check!=4){
                set_X(1,check,grille);
              }
              break;
            case 3 : // Gauche
              check=grille[case_Y][case_X-1].consequences(case_Y,case_X,type,"ordinateur",type_cell);
              if (check!=4){
                set_X(-1,check,grille);
              }
              break;
            default : break;
          }
          valide2=true;
        }
      }
      stop_mouvement();
      return true;
    }
    else {
      return false;
    }
  }


/////////////// METHODES RENVOYEES PAR L'OBJET D'ARRIVE A L'OBJET EN DEPLACEMENT  ///////////////


  public void set_X(int a, int check, Case [][] grille){
    if (check==4){
      System.out.println("Mais non ! Vous allez vers un virus ! Pour votre propre sécurité, nous n'avons pas validé votre déplacement. \nMAIS votre cellule est quand même tétanisée et doit attendre la fin du tour pour se remettre de ses émotions !");
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    if (check==4){
      System.out.println("Mais non ! Vous allez vers un virus ! Pour votre propre sécurité, nous n'avons pas validé votre déplacement. \nMAIS votre cellule est tétanisée et doit attendre la fin du tour pour se remettre de ses émotions !");
    }
  }


////////////////////////////////   MODIFIE L'ATTRIBUT STATUT     ////////////////////


  public void set_statut(){
    if (statut){
      statut=false;
      cpt--;
    }
    else {
      statut=true;
      cpt++;
    }
  }


////////////////////////////////   PERMET DE VERIFIER SI L'OBJET ET VIDE    ////////////////


  public int test_case(){
    return 1;
  }
}
