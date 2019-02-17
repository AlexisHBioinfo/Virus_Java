import java.io.*;
import java.util.*;

public class Y_cellule extends Cellule {
  protected Infectee Y_infectee;
  private int cpt_guerison=0;
  Y_cellule(int case_X, int case_Y){
    super(case_X,case_Y);
    Y_infectee = new Infectee(case_X,case_Y,5);
  }


////////////////////    METHODE D'AFFICHAGE DE LA CELLULE Y  //////////////////////////////


  public void affiche(String type){
    if (type.equals("Virus")){
      System.out.print("[cc]");
    }
    else {
      if (mouvement){
        System.out.print("[\033[0;96myy\033[0m]");//ANSI Escape Code cyan
      }
      else {
        System.out.print("[\033[38;2;255;70;0myy\033[0m]");//ANSI Escape Code rouge orangé non bold
      }
    }
  }


////////////   METHODE APPLIQUEE PAR UNE CELLULE OU UN VIRUS A UNE CASE VIDE  ///////////////


  public int consequences(int a,int b, boolean type, String joueur, String type_cell){
    if (joueur.equals("joueur")){
      System.out.println("Vous avez atteint une cellule sensible Y.");
      if(type){
        System.out.println("Vous fusionnez avec elle.");
        if (type_cell.equals("Z")){
          set_statut();
        }
      }
      else {
        System.out.println("Vous la contaminez et elle se comporte alors comme un virus pendant 3 tours. JACKPOT !");
        set_statut();
        Y_infectee.set_statut();
        Y_infectee.cpt++;
        Y_infectee.set_position(case_X,case_Y);
      }
      return 2;
    }
    else {
      return 2;
    }
  }


////////////////////////////////// METHODE RENVOYANT L'OBJET INFECTEE LIE A LA CELLULE Y ///////////////////////


  public Infectee get_infectee(){
    return Y_infectee;
  }


///////////////////////////////    METHODE METTANT A JOUR LES ATTRIBUTS DE L'OBJET A CHAQUE TOUR   ////////////////


  public void maj_compteurs(){
    if (!statut){
      cpt_guerison+=1;
      case_X=Y_infectee.get_X();
      case_Y=Y_infectee.get_Y();
      if (cpt_guerison>=3){
        set_statut();
        cpt_guerison=0;
      }
    }
    super.maj_compteurs();
  }


////////////////////////////////   RENVOIT LA CLASSE DE L'OBJET ////////////////////////


  public String test_type(){
    return "Y";
  }



/////////////// METHODES RENVOYEES PAR L'OBJET D'ARRIVE A L'OBJET EN DEPLACEMENT  ///////////////


  public void set_X(int a,int check, Case [][] grille){
    super.set_X(a,check,grille);
    if ((check==0) || (check==3)){
      case_X+=a;
    }
    else if ((check==1) || (check==2)){
      set_statut();
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    super.set_Y(b,check,grille);
    if ((check==0) || (check==3)){
      case_Y+=b;
    }
    else if ((check==1) || (check==2)){
      set_statut();
    }
  }
}
