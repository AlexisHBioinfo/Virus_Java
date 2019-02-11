import java.io.*;
import java.util.*;
abstract public class Cellule extends Organisme {
  protected static int cpt =0;
  public Cellule (int case_X, int case_Y, int hp){
    super(case_X,case_Y,hp);
    cpt++;
  }


  public int consequences(int a,int b){
    return 0;
  }


  public Infectee get_infectee(){
    return null;
  }


  public void set_X(){

  }

  public void set_Y(){

  }
}
