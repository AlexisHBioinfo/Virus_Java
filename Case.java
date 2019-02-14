import java.io.*;
import java.util.*;

public class Case {
  protected boolean statut = true;
  protected int case_X;
  protected int case_Y;
  public Case(int X, int Y){
    case_X = X;
    case_Y = Y;
  }
  public void affiche(){
    System.out.print("[  ]");
  }
  public boolean Menu_deplacements(Case[][] grille, boolean type){
    System.out.println("Case invalide");
    return false;
  }
  public static int saisie_entier() {
    try {
      BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
      String chaine = buff.readLine();
      int num = Integer.parseInt(chaine);
      return num;
    }
    catch(IOException e){
      return 0;
    }
  }


  public int consequences(int a,int b, boolean type){
    case_Y=a;
    case_X=b;
    return 0;
  }


  public int get_X(){
    return case_X;
  }

  public int get_Y(){
    return case_Y;
  }


  public boolean get_statut(){
    return statut;
  }


  public void maj_compteurs(){}


  public Infectee get_infectee(){return null;}


  public boolean test_case(){
    return true;
  }


  public void set_statut(){
    if (statut){
      statut=false;
    }
    else {
      statut=true;
    }
  }


  public Vector<Case> division(Vector<Case> contenuGrille, Case[][] grille){
    return contenuGrille;
  }
}
