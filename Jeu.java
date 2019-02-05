import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Random;
import java.lang.*;
import java.util.Arrays;


// A FAIRE :
//Fonctions déplacements :
//Affichage des règles :
//Revoir enchainement des menus : while au mauvais endroit ?
public class Jeu {
  public static void main(String[] arg){
    Case[][] grille = creation_grille();
    Menu(grille);
  }
  public static void Menu(Case[][] grille){
    boolean run = true;
    while(run){
      System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
      System.out.println("1. Sélection du niveau.");
      System.out.println("2. Lecture des règles.");
      int choix = saisie_entier();
      switch (choix){
        case 1 : Menu_niveaux(grille);
                  break;
        case 2 : Regles();
                  break;
        default : System.out.println("Choix non valide");
                  break;
      }
    }
  }
  public static void Menu_niveaux(Case[][] grille){
    boolean run = true;
    System.out.println("~~~~~~~~~~~ Quel niveau voulez-vous tenter ?~~~~~~~~~~~");
    System.out.println("1. Facil");
    System.out.println("2. Intermédiaire");
    System.out.println("3. Difficile");
    int choix = saisie_entier();
    switch (choix){
      case 1 : grille = repartition_organismes(grille,15,30,55);
                Menu_Virus();
                break;
      case 2 : grille = repartition_organismes(grille,20,40,40);
                Menu_Virus();
                break;
      case 3 : grille = repartition_organismes(grille,25,50,25);
                Menu_Virus();
                break;
      default : System.out.println("Choix non valide");
                break;
    }
  }
  public static void Menu_Virus(){
    boolean run = true;
    System.out.println("~~~~~~~~~~~ Quel virus voulez-vous déplacer (4possibles par tour) ?~~~~~~~~~~~");
    System.out.println("Rentrez le numéro de la ligne voulue faites ENTRER puis rentrez les numéro de la colonne.");
    int ligne = saisie_entier();
    int colonne = saisie_entier();
    //Appelle du menu déplacement puis des déplacements
  }
  public static void Menu_déplacements(){
    System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~");
    System.out.println("-> Pour plus de confort, utiliser le pavé numérique.");
    System.out.println("8. Haut");
    System.out.println("2. Bas");
    System.out.println("6. Droite");
    System.out.println("4. Gauche");
  }
  public static void Regles(){
    System.out.println("~~~~~~~~~~~ Les règles ~~~~~~~~~~~");
    System.out.println(" A FAIRE ");
  }
  public static Case[][] creation_grille(){
    Case grille[][] = new Case[20][];
    for ( int i=0; i < grille.length ; i++){
      grille[i] = new Case[20];
      }
    for (int a = 0; a < grille.length ; a++){
      for (int b=0 ; b < grille[a].length ; b++){
        grille[a][b] = new Case(a,b);
      }
    }
    return grille;
  }
  public static Case[][] repartition_organismes(Case[][] grille, int nbX, int nbY, int nbZ){
    int nbV = 10;
    Vector <Integer> indexgrille = new Vector<>();
    for (int a = 0; a<400 ; a++){
      indexgrille.add(a);
    }
    int nbcases = 400;
    int nbcasesX = nbcases - nbX;
    int nbcasesY = nbcasesX - nbY;
    int nbcasesZ = nbcasesY - nbZ;
    grille = repartition(grille, indexgrille, nbX,1, nbcases);
    grille = repartition(grille, indexgrille, nbY,2, nbcasesX);
    grille = repartition(grille, indexgrille, nbZ,3, nbcasesY);
    grille = repartition(grille, indexgrille, 10,4,nbcasesZ);
    affichage_grille(grille);
    return grille;
  }
  public static Case[][] repartition(Case[][] grille, Vector <Integer> indexgrille, int nbOrganisme, int quelOrganisme, int nbcases){
    for (int i = 0; i < nbOrganisme ; i++) {
      Random rand = new Random();
      int indice = rand.nextInt(nbcases-i);
      int index_pos = indexgrille.get(indice);
      int pos_X = index_pos%20;
      int pos_Y = index_pos/20;
      switch (quelOrganisme){
        case 1 : grille[pos_X][pos_Y] = new X_cellule(pos_X,pos_Y);break;
        case 2 : grille[pos_X][pos_Y] = new Y_cellule(pos_X,pos_Y);break;
        case 3 : grille[pos_X][pos_Y] = new Z_cellule(pos_X,pos_Y);break;
        case 4 : grille[pos_X][pos_Y] = new Virus(pos_X,pos_Y);break;
        default : System.out.println("Création d'organisme invalide");break;
      }
      indexgrille.remove(indice);
    }
    return grille;
  }
  public static void affichage_grille(Case[][] grille){
    try {
      for (int horizontal = 0 ; horizontal < 20 ; horizontal++){
        if (horizontal == 0) {System.out.print("     0"+horizontal+" ");}
        if (horizontal > 0 && horizontal < 10) {System.out.print(" 0"+horizontal+" ");}
        if (horizontal > 9 && horizontal < 20) {System.out.print(" "+horizontal+" ");}
      }
      System.out.println("");
      for (int i=0 ; i < grille.length ; i++){
        if (i <= 9){ System.out.print(i+"0  ");}
        else {System.out.print(i+"  ");}
        for (int j=0 ; j < grille[i].length ; j++){
          grille[i][j].affiche();
        }
        System.out.println("");
      }
    }
    catch (NullPointerException e){
      System.out.println("Création de la grille réussie.");
    }
  }
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
}
