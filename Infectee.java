import java.io.*;
import java.util.*;

public class Infectee extends Virus {
  protected int cpt_infection=3;
  Infectee(int case_X, int case_Y){
    super(case_X,case_Y);
    statut=false;
    cpt--;
  }


  public void affiche(String type){
    if (mouvement){
      System.out.print("[\033[32;1;2m#y\033[0m]");
    }
    else {
      System.out.print("[\033[31;1m#y\033[0m]");
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
