import java.io.*;
import java.util.*;

public class Z_cellule extends Cellule {
  private String immunite = "Destructible";
  Z_cellule(int case_X, int case_Y){
    super(case_X,case_Y,1); //1 ? Mais on sait pas encore comment gérer la vie
  }

  public void affiche(){
    System.out.print("[Zz]");
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