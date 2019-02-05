import java.io.*;
import java.util.*;

public class Virus extends Organisme {
  protected int numero;
  protected static int cpt=0;
  Virus(int case_X, int case_Y){
    super(case_X,case_Y,5);
    numero = cpt;
    cpt ++;
  }

  public void affiche(){
    System.out.print("[¤¤]");
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
