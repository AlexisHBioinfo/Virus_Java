import java.io.*;
import java.util.*;
abstract public class Cellule extends Organisme {
  protected int numero;
  protected static int cpt =0;
  protected String type = "Cellule";
  public Cellule (int case_X, int case_Y, int hp){
    super(case_X,case_Y,hp);
    numero = cpt;
    cpt++;
  }


  public int test(int a,int b){
    return 0;
  }
}
