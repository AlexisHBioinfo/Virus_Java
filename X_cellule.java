import java.io.*;
import java.util.*;

public class X_cellule extends Cellule {
  X_cellule(int case_X, int case_Y){
    super(case_X,case_Y,1000); //cellule immunisée donc vie "infinie"
  }
  public void affiche(){
    System.out.print("[xx]");
  }

  public int consequences(int a,int b){
    System.out.println("Victime bolosse !");
    return 3;
    //Pas oublier enlever un pv au virus
  }


  public void set_X(int a,int check, Case [][] grille){
    if (check==0){
      case_X+=a;
    }
    else {
      statut=false;
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    if (check==0){
      case_Y+=b;
    }
    else {
      statut=false;
    }
  }
}
