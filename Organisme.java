import java.io.*;
import java.util.*;
abstract public class Organisme extends Case{
  protected int point_de_vie;
  protected boolean mouvement=true;
  public Organisme (int case_X, int case_Y, int hp){
    super(case_X,case_Y);
    point_de_vie=hp;
  }


  public boolean Menu_deplacements(Case[][] grille){
      System.out.println("Case invalide orga");
      return false;
    }


  public int consequences(int a,int b){
    return 0;
  }


  public void set_X(){return;}


  public void set_Y(){return;}


  public Infectee get_infectee(){
    return null;
  }


  public void stop_mouvement(){
    mouvement=false;
  }


  public void maj_compteurs(){
    mouvement=true;
  }


  public void set_statut(){
    if (statut){
      statut=false;
    }
    else {
      statut=true;
    }
  }


  public int test_case(){
    return 9;
  }
}
