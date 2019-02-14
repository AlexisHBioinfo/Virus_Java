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
    System.out.println("Vous avez sélectionné une cellule !");
    super.Menu_deplacements(grille,true);
    return true;
  }


  public void set_X(int a, int check, Case [][] grille){
    if (check==4){
      System.out.println("Mais dywallah ! Vous allez vers un virus ! Pour votre propre sécurité, nous n'avons pas validé votre déplacement. \nMAIS votre cellule est tétanisée et doit attendre la fin du tour pour se remettre de ses émotions !");
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    if (check==4){
      System.out.println("Mais dywallah ! Vous allez vers un virus ! Pour votre propre sécurité, nous n'avons pas validé votre déplacement. \nMAIS votre cellule est tétanisée et doit attendre la fin du tour pour se remettre de ses émotions !");
    }
  }
}
