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
  public boolean Menu_deplacements(Case[][] grille){
      System.out.println("Case invalide orga");
      return false;
    }

  public int test(int a,int b){
    return 0;
  }



  public void set_X(int a,int check, Case [][] grille){
    switch (check){
      case 0 : //case vide
        case_X+=a;
        break;
      case 1 : //Z
        case_X+=a;
        point_de_vie+=1;
        break;
      case 2 : // Y
        // Infectee grille[case_Y][case_X+a] = new Infectee(case_X,case_Y);
        point_de_vie+=1;
        break;
      case 3 : // X
        point_de_vie-=1;
        break;
      case 4 : // V
        break;
      default :
        System.out.println("FATAL ERROR");
        break;
    }
  }

  public void set_Y(int b, int check, Case [][] grille){
    switch (check){
      case 0 : //case vide
        case_Y+=b;
        break;
      case 1 : //Z
        case_Y+=b;
        point_de_vie+=1;
        break;
      case 2 : // Y
        // Infectee grille[case_Y][case_X+a] = new Infectee(case_X,case_Y);
        point_de_vie+=1;
        break;
      case 3 : // X
        point_de_vie-=1;
        break;
      case 4 : // V
        break;
      default :
        System.out.println("FATAL ERROR");
        break;
    }
  }

  public Infectee get_infectee(){
    return null;
  }

  public void maj_compteurs(){}
}
