import java.io.*;
import java.util.*;

public class X_cellule extends Cellule {
  X_cellule(int case_X, int case_Y){
    super(case_X,case_Y);
  }
  public void affiche(String type){
    if (type.equals("Virus")){
      System.out.print("[cc]");
    }
    else {
      if (mouvement){
        System.out.print("[\033[38;2;0;135;175mxx\033[0m]");//vert bleu
      }
      else {
        System.out.print("[\033[38;2;255;70;0mxx\033[0m]");//rouge orangé non bold
      }
    }
  }

  public int consequences(int a,int b, boolean type, String joueur, String type_cell){
    if (joueur.equals("joueur")){
      System.out.println("Vous avez atteint une cellule résistante X !");
      if (type){
        System.out.println("Vous fusionnez avec elle !");
        if ((type_cell.equals("Y")) || (type_cell.equals("Z"))){
          set_statut();
        }
      }
      else {System.out.println("Vous ne pouvez pas l'infecter et vous perdez alors 1 point de vie.");}
      return 3;
    }
    else {
      return 3;
    }
  }


  public String test_type(){
    return "X";
  }


  public void set_X(int a,int check, Case [][] grille){
    super.set_X(a,check,grille);
    if (check==0){
      case_X+=a;
    }
    else if (check!=4){
      set_statut();
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    super.set_Y(b,check,grille);
    if (check==0){
      case_Y+=b;
    }
    else if (check!=4){
      set_statut();
    }
  }
}
