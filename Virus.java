import java.io.*;
import java.util.*;

public class Virus extends Organisme {
  protected int numero;
  protected static int cpt=0;
  Virus(int case_X, int case_Y){
    super(case_X,case_Y,5);
    numero = cpt;
    cpt ++;
  }


  public void affiche(){
    System.out.print("[##]");
  }


  public int consequences(int a, int b){
    return 4;
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


  public boolean Menu_deplacements(Case[][] grille){
    System.out.println("Vous avez sélectionné un virus ! Que voulez vous faire ?");
    System.out.println("Tapez 0 pour déplacer le virus sélectionné.\nTapez 1 pour afficher des informations sur le virus.");
    int action = saisie_entier();
    if (action == 0){
      if (mouvement){
        boolean valide2=false;
        while (!valide2){
          System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
          System.out.println("-> Pour plus de confort, utiliser le pavé numérique.");
          System.out.println("8. Haut");
          System.out.println("2. Bas");
          System.out.println("6. Droite");
          System.out.println("4. Gauche");
          int choix = saisie_entier();
          int check;
          if (((case_Y-1>=0) || (choix!=8)) && ((case_Y+1<20) || (choix!=2)) && ((case_X-1>=0) || (choix!=4)) && ((case_X+1<20) || (choix!=6))){
            switch (choix){
              case 8 :
              check=grille[case_Y-1][case_X].consequences(case_Y,case_X);
              set_Y(-1,check,grille);
              System.out.println("En haut");
              break;
              case 2 :
              check=grille[case_Y+1][case_X].consequences(case_Y,case_X);
              set_Y(1,check,grille);
              System.out.println("En bas");
              break;
              case 6 :
              check=grille[case_Y][case_X+1].consequences(case_Y,case_X);
              set_X(1,check,grille);
              System.out.println("A droite");
              break;
              case 4 :
              check=grille[case_Y][case_X-1].consequences(case_Y,case_X);
              set_X(-1,check,grille);
              System.out.println("A gauche");
              break;
              default : System.out.println("Erreur de saisie !");break;
            }
            valide2=true;
          }
          else {
            System.out.println("Mouvement hors Elsa SUPER SUPER relou");
          }
        }
        stop_mouvement();
        return true;
      }
      else {
        System.out.println("Le virus que vous avez sélectionné a déjà été déplacé !");
        return false;
      }
    }
    else if (action ==1) {
      System.out.println("Le virus que vous avez sélectionné a "+point_de_vie+" points de vie !");
    }
    return false;
  }


  public void maj_compteurs(){
    super.maj_compteurs();
    if (point_de_vie==0){statut=false;}
  }


 public Vector<Case> division(Vector<Case> contenuGrille, Case[][] grille){
    if (point_de_vie == 10){
      set_pv(-6);
      for (int i=-1 ; i<=1 ; i++){
        for (int j=-1; j<=1 ;j++){
          if ((case_X+i <20) && (case_X+i >=0) && (case_Y+j < 20) && (case_Y+j >= 0)){
            if (grille[case_X+i][case_Y+j].test_case()){
              Virus item = new Virus(case_X+i,case_Y+j);
              item.set_pv(-1);
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
}
