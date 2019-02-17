import java.io.*;
import java.util.*;

public class Case {
  protected boolean statut = true;
  protected int case_X;
  protected int case_Y;
  public Case(int X, int Y){
    case_X = X;
    case_Y = Y;
  }


//////////////////    AFFICHAGE DE CASE VIDE     ////////////////////////////


  public void affiche(String type){
    System.out.print("[  ]");
  }


//////////////////     MENU DE DEPLACEMENT POUR UNE CASE VIDE    /////////////


  public boolean Menu_deplacements(Case[][] grille, boolean type){
    System.out.println("Case invalide");
    return false;
  }


///////////////   MENU DE DEPLACEMENT POUR UNE CASE VIDE COTE ORDINATEUR ///////////


  public boolean Menu_deplacements_ordi(Case[][] grille, boolean type){
    return false;
  }


  /////////////////////////////       ENTREE STANDARD D'ENTIER         ///////////////////////


  public static int saisie_entier() {
    try {
      BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
      String chaine = buff.readLine();
      int num = Integer.parseInt(chaine);
      return num;
    }
    catch(IOException e){
      return 0;
    }
  }


////////////   METHODE APPLIQUEE PAR UNE CELLULE OU UN VIRUS A UNE CASE VIDE  ///////////////


  public int consequences(int a,int b, boolean type, String joueur, String type_cell){
    case_Y=a;
    case_X=b;
    return 0;
  }


///////////////////////    RENVOIT L'ATTRIBUT CASE_X DE L'OBJET     /////////////////////


  public int get_X(){
    return case_X;
  }


///////////////////////    RENVOIT L'ATTRIBUT CASE_Y DE L'OBJET     /////////////////////


  public int get_Y(){
    return case_Y;
  }


///////////////////////    RENVOIT L'ATTRIBUT STATUT DE L'OBJET     /////////////////////


  public boolean get_statut(){
    return statut;
  }


///////////////////////      METHODE APPLICANT LA NOTION DE TEMPS AUX OBJETS  //////////////////


  public void maj_compteurs(){}


////    METHODE PERMETTANT A L'OBJET DE DONNER SON IDENTITE AFIN D'APPLIQUER UNE CONSEQUENCE SPECIFIQUE    ////////


  public int test_case(){
    return 0;
  }


////////////////////////      INTERVERTIT LE STATUT DE L'OBJET : MORT / VIVANT  //////////////////////////


  public void set_statut(){
    if (statut){
      statut=false;
    }
    else {
      statut=true;
    }
  }


  public Vector<Case> division(Vector<Case> contenuGrille, Case[][] grille){
    return contenuGrille;
  }
}
