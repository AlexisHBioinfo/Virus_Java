import java.io.*;
import java.util.*;

public class X_cellule extends Cellule {
  private String immunite = "Immunisée";
  X_cellule(int case_X, int case_Y){
    super(case_X,case_Y,1000); //cellule immunisée donc vie "infinie"
  }
  public void affiche(){
    System.out.print("[xx]");
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
