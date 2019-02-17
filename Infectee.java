import java.io.*;
import java.util.*;

public class Infectee extends Virus {
  protected int cpt_infection=3;
  Infectee(int case_X, int case_Y, int hp){
    super(case_X,case_Y, hp);
    statut=false;
    cpt--;
  }


////////////////////    METHODE D'AFFICHAGE DE LA CELLULE INFECTEE  //////////////////////////////


  public void affiche(String type){
    if(type.equals("Virus")){
      if (mouvement){
        System.out.print("[\033[38;2;50;200;0m#y\033[0m]");//ANSI Escape Code vert
      }
      else {
        System.out.print("[\033[38;2;255;70;0m#y\033[0m]");//ANSI Escape Code rouge orangé
      }
    }
    else{
      System.out.print("[#y]");
    }
  }


///////////////////////////////    METHODE METTANT A JOUR LES ATTRIBUTS DE L'OBJET A CHAQUE TOUR   ////////////////


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


///////////////////////////////////       PERMET D'AVOIR LA MEME POSITION QUE LA CELLULE Y ASSOCIEE  //////////////


  public void set_position(int x,int y){
    case_X=x;
    case_Y=y;
  }
}
