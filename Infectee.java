import java.io.*;
import java.util.*;

public class Infectee extends Virus {
  protected int cpt_infection=3;
  Infectee(int case_X, int case_Y){
    super(case_X,case_Y);
    statut=false;
  }


  public void affiche(){
    System.out.print("[#y]");
  }


  public void maj_compteurs(){
    if (statut){
      cpt_infection-=1;
      if (cpt_infection==0){
        set_statut();
        cpt_infection=3;
      }
    }
    super.maj_compteurs();
  }


  public void set_position(int x,int y){
    case_X=x;
    case_Y=y;
  }
}
