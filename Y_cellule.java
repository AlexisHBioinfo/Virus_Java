import java.io.*;
import java.util.*;

public class Y_cellule extends Cellule {
  private String immunite = "Sensible";
  Y_cellule(int case_X, int case_Y){
    super(case_X,case_Y,3);
  }
  public void affiche(){
    System.out.print("[yy]");
  }


  public int test(int a,int b){
    System.out.println("Vous avez contaminé une cellule sensible. Elle est triste.");
    return 2;
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
