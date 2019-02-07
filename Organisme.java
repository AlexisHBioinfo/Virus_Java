import java.io.*;
import java.util.*;
abstract public class Organisme extends Case{
  protected int point_de_vie;
  public Organisme (int case_X, int case_Y, int hp){
    super(case_X,case_Y);
    point_de_vie=hp;
  }

  //
  // public void deplacement(){
  //
  // }
  //
  //
  // public abstract void mourir();
  //
  // public static boolean Menu_deplacements(){
  //   return false;
  // }
  public boolean Menu_deplacements(){
      System.out.println("Case invalide orga");
      return false;
    }
  public static boolean set_X(int x){
    int tmp=case_X+x;
    if ((tmp<20) || (tmp>=0)){
      case_X+=x;
      return true;
    }
    return false;
  }

  public static boolean set_Y(int y){
    int tmp=case_Y+y;
    if ((tmp<20) || (tmp>=0)){
      case_Y+=y;
      return true;
    }
    return false;
  }

}
