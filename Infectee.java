import java.io.*;
import java.util.*;

public class Infectee extends Virus {
  protected int cpt_infection=3;
  Infectee(int case_X, int case_Y, int hp){
    super(case_X,case_Y, hp);
    statut=false;
    cpt--;
  }


  public void affiche(String type){
    if(type.equals("Virus")){
      if (mouvement){
        System.out.print("[\033[38;2;50;200;0m#y\033[0m]");//vert
      }
      else {
        System.out.print("[\033[38;2;255;70;0m#y\033[0m]");//rouge orangé non bold
      }
    }
    else{
      System.out.print("[#y]");
    }
  }

  public void maj_compteurs(){
    if (statut){
      cpt_infection-=1;
      if (cpt_infection==0){
        set_statut();
        cpt--;
        cpt_infection=3;
      }
    }
    mouvement=true;
  }


  public void set_position(int x,int y){
    case_X=x;
    case_Y=y;
  }
}
