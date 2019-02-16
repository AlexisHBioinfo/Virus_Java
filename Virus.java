import java.io.*;
import java.util.*;

public class Virus extends Organisme {
  protected int point_de_vie;
  protected static int cpt=0;
  Virus(int case_X, int case_Y, int hp){
    super(case_X,case_Y);
    point_de_vie = hp;
    numero = cpt;
    cpt ++;
  }


  public void affiche(String type){
    if (type.equals("Cellule")){
      System.out.print("[##]");
    }
    else {
      if (mouvement){
        System.out.print("[\033[38;2;50;200;0m##\033[0m]");//vert
      }
      else {
        System.out.print("[\033[38;2;255;70;0m##\033[0m]");//rouge orangé non bold
      }
    }
  }


  public int consequences(int a, int b,boolean type, String joueur, String type_cell){
    return 4;
  }


  public void set_X(int a,int check, Case [][] grille){
  switch (check){
    case 0 : //case vide
      case_X+=a;
      break;
    case 1 : //Z
      case_X+=a;
      set_pv(1);
      break;
    case 2 : // Y
      set_pv(1);
      break;
    case 3 : // X
      set_pv(-1);
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
        set_pv(1);
        break;
      case 2 : // Y
        set_pv(1);
        break;
      case 3 : // X
        set_pv(-1);
        break;
      case 4 : // V
        break;
      default :
        System.out.println("FATAL ERROR");
        break;
    }
  }


  public void set_pv(int a){
    point_de_vie+=a;
  }


  public boolean Menu_deplacements(Case[][] grille, boolean type){
    if (type){
      System.out.println("Vous essayez de déplacer un virus alors que vous êtes le joueur CELLULE ! Try again.");
      return false;
    }
    else {
      System.out.println("Vous avez sélectionné un virus ! Que voulez vous faire ?");
      System.out.println("Tapez 0 pour déplacer le virus sélectionné.\nTapez 1 pour afficher des informations sur le virus.");
      int action = saisie_entier();
      if (action == 0){
        super.Menu_deplacements(grille,false);
        return true;
      }
      else {
        System.out.println("Le virus que vous avez sélectionné a "+point_de_vie+" points de vie !");
        return false;
      }
    }
  }


  public void maj_compteurs(){
    super.maj_compteurs();
    if (point_de_vie<1){statut=false;System.out.println("lalala");}
  }


 public Vector<Case> division(Vector<Case> contenuGrille, Case[][] grille){
    if (point_de_vie == 10){
      set_pv(-6);
      for (int i=-1 ; i<=1 ; i++){
        for (int j=-1; j<=1 ;j++){
          if ((case_X+i <20) && (case_X+i >=0) && (case_Y+j < 20) && (case_Y+j >= 0)){
            if (grille[case_X+i][case_Y+j].test_case()==0){
              Virus item = new Virus(case_X+i,case_Y+j,4);
              contenuGrille.add(item);
              System.out.println("Bravo ! Le virus que vous avez déplacé a atteint 10 points de vie et s'est divisé en deux virus ayant chacun 4 points de vie.");
              System.out.println("Les rangs de votre armée de virus se sont aggrandis !");
              return contenuGrille;
            }
          }
        }
      }
    }
    return contenuGrille;
  }


  public String test_type(){
    return "Virus";
  }


  public int test_case(){
    return 2;
  }
}
