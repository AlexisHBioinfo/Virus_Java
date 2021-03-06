import java.io.*;
import java.util.*;

public class Z_cellule extends Cellule {
  Z_cellule(int case_X, int case_Y){
    super(case_X,case_Y);
  }


////////////////////    METHODE D'AFFICHAGE DE LA CELLULE Z  //////////////////////////////


  public void affiche(String type){
    if (type.equals("Virus")){
      System.out.print("[cc]");
    }
    else {
      if (mouvement){
        System.out.print("[\033[0;94mzz\033[0m]");//ANSI Escape Code bleu gris
      }
      else {
        System.out.print("[\033[38;2;255;70;0mzz\033[0m]");//ANSI Escape Code rouge orangé
      }
    }
  }


////////////   METHODE APPLIQUEE PAR UNE CELLULE OU UN VIRUS A UNE CASE VIDE  ///////////////


  public int consequences(int a,int b, boolean type, String joueur, String type_cell){
    if (joueur.equals("joueur")){
      System.out.println("Vous avez atteint une cellule Z !");
      if (type){
        System.out.println("Vous fusionnez avec elle.");
      }
      else{
        System.out.println("Vous l'avez contaminée, elle est morte instantanément. Votre virus gagne 1 point de vie.");
        set_statut();
      }
      return 1;
    }
    else {
      return 1;
    }
  }


  public String test_type(){
    return "Z";
  }


/////////////// METHODES RENVOYEES PAR L'OBJET D'ARRIVE A L'OBJET EN DEPLACEMENT  ///////////////


  public void set_X(int a,int check, Case [][] grille){
    super.set_X(a,check,grille);
    if ((check==0) || (check==2) || (check==3)){
      case_X+=a;
    }
    else if (check==1){
      set_statut();
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    super.set_Y(b,check,grille);
    if ((check==0) || (check==2) || (check==3)){
      case_Y+=b;
    }
    else if (check==1){
      set_statut();
    }
  }
}
