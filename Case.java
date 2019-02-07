import java.io.*;
import java.util.*;

public class Case {
  protected static int case_X;
  protected static int case_Y;
  public Case(int X, int Y){
    case_X = X;
    case_Y = Y;
  }
  public void affiche(){
    System.out.print("[  ]");
  }
  public boolean Menu_deplacements(){
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
}
