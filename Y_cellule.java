import java.io.*;
import java.util.*;

public class Y_cellule extends Cellule {
  protected Infectee Y_infectee;
  private int cpt_guerison=0;
  private String immunite = "Sensible";
  Y_cellule(int case_X, int case_Y){
    super(case_X,case_Y,3);
    Y_infectee = new Infectee(case_X,case_Y);
    // Y_infectee.affiche();
  }
  public void affiche(){
    System.out.print("[yy]");
  }


  public int test(int a,int b){
    System.out.println("Vous avez contaminé une cellule sensible. Elle est triste.");
    set_statut();
    Y_infectee.set_statut();
    return 2;
  }


  public Infectee get_infectee(){
    return Y_infectee;
  }

  public void maj_compteurs(){
    if (!statut){
      cpt_guerison+=1;
      if (cpt_guerison>=3){
        set_statut();
        cpt_guerison=0;
      }
    }
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
}
