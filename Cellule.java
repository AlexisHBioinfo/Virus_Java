import java.io.*;
import java.util.*;
abstract public class Cellule extends Organisme {
  protected static int cpt =0;
  public Cellule (int case_X, int case_Y, int hp){
    super(case_X,case_Y,hp);
    cpt++;
  }


  public int consequences(int a,int b, boolean type){
    return 0;
  }


  public Infectee get_infectee(){
    return null;
  }


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


  public int test_case(){
    return 1;
  }
}
