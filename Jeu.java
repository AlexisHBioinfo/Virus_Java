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
//Changement couleur? si déjà déplacé ou par type d'objet.
//Affichages joueurs : possibilité voir type (yy xx zz) sur la grille ?
//Selection du virus pour déplacements MAIS AUSSI pour autre chose ? genre check pdv ?


public class Jeu {
  public static void main(String[] arg){
    Vector <Case> contenuGrille = new Vector <> ();
    Case[][] grille = creation_grille();
    Menu(grille,contenuGrille);
  }


  public static void Menu(Case[][] grille,Vector <Case> contenuGrille){
    System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~\n");
    System.out.println("1. Sélection du niveau.");
    System.out.println("2. Lecture des règles.");
    System.out.println("3. Quitter la simulation.\n");
    int choix = saisie_entier();
    System.out.println();
    switch (choix){
      case 1 : Menu_niveaux(grille,contenuGrille);
                break;
      case 2 : Regles();
                break;
      case 3 : break;
      default : System.out.println("Choix non valide");
                break;
      }
    }


  public static void Menu_niveaux(Case[][] grille,Vector <Case> contenuGrille){
    System.out.println("~~~~~~~~~~~ Quel niveau voulez-vous tenter ?~~~~~~~~~~~\n");
    System.out.println("1. Facile");
    System.out.println("2. Intermédiaire");
    System.out.println("3. Difficile\n");
    int choix = saisie_entier();
    System.out.println();
    switch (choix){
      case 1 : grille = repartition_organismes(grille,15,30,55,contenuGrille);
                break;
      case 2 : grille = repartition_organismes(grille,20,40,40,contenuGrille);
                break;
      case 3 : grille = repartition_organismes(grille,25,50,25,contenuGrille);
                break;
      default : System.out.println("Choix non valide");
                break;
    }
    System.out.println("Voulez-vous jouer contre l'ordinateur (tapez 0) ou contre un joueur (tapez 1) ?");
    int config = saisie_entier();
    affichage_grille(grille, "Virus");
    boolean tour = true;
    int cpt_tour = 0;
    while ((tour) && (Virus.cpt<Cellule.cpt)){
      System.out.println("\n\nVoulez vous quitter ? Si oui entrez 0, si non, entrez un autre nombre\n");
      int choix_exit=saisie_entier();
      System.out.println();
      if (choix_exit==0){
        tour = false;
      }
      else {
        contenuGrille=Menu_Virus(grille,contenuGrille);
        System.out.println("\n\nIl reste encore "+Cellule.cpt+" cellules et "+Virus.cpt+" virus en jeu.");
        if(config==0){
          contenuGrille=Menu_Cellule_ordi(grille,contenuGrille);
        }
        else {
          contenuGrille=Menu_Cellule(grille,contenuGrille);
        }
        for (int i=0;i<contenuGrille.size();i++){
          Case item = contenuGrille.get(i);
          item.maj_compteurs();
        }
        cpt_tour++;
        System.out.println("Fin du tour "+cpt_tour);
      }
    }
    System.out.println("Fin de la partie !");
    if (Virus.cpt>Cellule.cpt){
      System.out.println("Le joueur Virus a gagné !");
    }
    else {
      System.out.println("Le joueur Cellule a gagné");
    }
  }


  public static Vector <Case> Menu_Virus(Case[][] grille,Vector <Case> contenuGrille){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n                                  >> JOUEUR VIRUS <<            \n");
    System.out.println("\n\nIl reste encore "+Cellule.cpt+" cellules et "+Virus.cpt+" virus en jeu.\n\n");
    affichage_grille(grille, "Virus");
    int mv_virus=0;
    boolean valide;
    int want_X = 0;
    int want_Y = 0;
    while (((want_X !=666) || (want_Y != 666)) && (Virus.cpt!=mv_virus)) {
      System.out.println("\n                                  >> JOUEUR VIRUS <<            \n");
      System.out.println("\n~~~~~~~~~~~ Quel virus voulez-vous déplacer (1 déplacement maximum par virus par tour) ?~~~~~~~~~~~\n");
      System.out.println("Vous pouvez bouger autant de virus que vous le souhaitez !");
      System.out.println("Rentrez le numéro de la colonne voulue faites ENTRER puis rentrez les numéro de la ligne.");
      System.out.println("Tapez '666' deux fois pour finir votre tour.\n");
      System.out.println("\n\nVous pouvez bouger encore "+(Virus.cpt-mv_virus)+" virus.\n");
      want_X = saisie_entier();
      want_Y = saisie_entier();
      System.out.println();
      if ((want_X != 666) && (want_Y != 666)){
        if (want_X < 20 && want_Y < 20 && want_X >= 0 && want_Y >= 0){
          valide=grille[want_Y][want_X].Menu_deplacements(grille, false);
          if (valide){
            contenuGrille=grille[want_Y][want_X].division(contenuGrille, grille);
            mv_virus++;
            grille=association_vecteur_grille(contenuGrille,grille);
            affichage_grille(grille, "Virus");
          }
        }
      }
    }
    return contenuGrille;
  }


  public static Vector <Case> Menu_Cellule(Case[][] grille,Vector <Case> contenuGrille){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n                                  >> JOUEUR CELLULE <<            \n");
    System.out.println("\nIl reste encore "+Cellule.cpt+" cellules et "+Virus.cpt+" virus en jeu.\n\n");
    affichage_grille(grille,"Cellule");
    int mv_cellule=0;
    boolean valide;
    int want_X = 0;
    int want_Y = 0;
    while (((want_X !=666) || (want_Y != 666)) && (10!=mv_cellule)) {
      System.out.println("\n                                  >> JOUEUR CELLULE <<            \n");
      System.out.println("\n~~~~~~~~~~~ Quelle cellule voulez-vous déplacer (1 déplacement maximum par cellule par tour) ?~~~~~~~~~~~\n");
      System.out.println("Vous pouvez bouger jusqu'à 10 cellules que vous le souhaitez !");
      System.out.println("Rentrez le numéro de la colonne voulue faites ENTRER puis rentrez les numéro de la ligne.");
      System.out.println("Tapez '666' deux fois pour finir votre tour.\n");
      System.out.println("\n\nVous pouvez bouger encore "+(10-mv_cellule)+" cellule(s).\n");
      want_X = saisie_entier();
      want_Y = saisie_entier();
      System.out.println();
      if ((want_X != 666) && (want_Y != 666)){
        if (want_X < 20 && want_Y < 20 && want_X >= 0 && want_Y >= 0){
          valide=grille[want_Y][want_X].Menu_deplacements(grille,true);
          if (valide){
            mv_cellule++;
            grille=association_vecteur_grille(contenuGrille,grille);
            affichage_grille(grille, "Cellule");
          }
        }
      }
    }
    return contenuGrille;
  }


  public static Vector <Case> Menu_Cellule_ordi(Case[][] grille, Vector <Case> contenuGrille){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n                                  >> ORDINATEUR <<            \n");
    int mv_cellule=0;
    boolean valide;
    while (mv_cellule<=10){
      Random rand = new Random();
      int indice_X = rand.nextInt(20);
      int indice_Y = rand.nextInt(20);
      valide=grille[indice_X][indice_Y].Menu_deplacements_ordi(grille,true);
      if (valide){
        mv_cellule++;
        grille=association_vecteur_grille(contenuGrille,grille);
      }
    }
    affichage_grille(grille, "Virus");
    return contenuGrille;
  }


  public static void Regles(){
    System.out.println("~~~~~~~~~~~ Les règles ~~~~~~~~~~~");
    System.out.println("\nBienvenue dans la simulation HACE Harmed Cell\n");
    System.out.println("Dans cette simulation, le joueur 1 contrôle les virus pendant que le joueur 2 contrôle les cellules.");
    System.out.println("Elle se déroule en tours de jeu. \nLe joueur 1 commence et peut déplacer une fois chacun de ses virus de une case.");
    System.out.println("Son but est d'atteindre les cellules afin de les infecter ! ATTENTION CEPENDANT : certaines cellules sont immunisées.");
    System.out.println("Le joueur 2, lui, contrôle les cellules. Il peut déplacer que 10 cellules saines par tour ! Il dispose de cellules immunisées [xx],\nde cellules sensibles [yy] pouvant être infectées par des virus durant 3 tours et enfin des cellules destructibles [zz] qui meurent instantanément au contact d'un virus.");
    System.out.println("Son but ? Survivre !\n");
    System.out.println("Lorsque le nombre de cellules passe sous la barre des 75 saines, le joueur 1 gagne !");
    System.out.println("Si il n'y a plus de virus en vie, le joueur 2 remporte la partie !\n");
    System.out.println("A VOUS DE JOUER !\n");
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


  public static Case[][] repartition_organismes(Case[][] grille, int nbX, int nbY, int nbZ,Vector <Case> contenuGrille){
    int nbV = 10;
    Vector <Integer> indexgrille = new Vector<>();
    for (int a = 0; a<400 ; a++){
      indexgrille.add(a);
    }
    int nbcases = 400;
    int nbcasesX = nbcases - nbX;
    int nbcasesY = nbcasesX - nbY;
    int nbcasesZ = nbcasesY - nbZ;
    contenuGrille = repartition(indexgrille, nbX,1, nbcases,contenuGrille);
    contenuGrille = repartition(indexgrille, nbY,2, nbcasesX,contenuGrille);
    contenuGrille = repartition(indexgrille, nbZ,3, nbcasesY,contenuGrille);
    contenuGrille = repartition(indexgrille, 10,4,nbcasesZ,contenuGrille);
    contenuGrille = repartition(indexgrille, 290, 5, 290,contenuGrille);
    grille=association_vecteur_grille(contenuGrille,grille);
    return grille;
  }


  public static Vector <Case> repartition(Vector <Integer> indexgrille, int nbOrganisme, int quelOrganisme, int nbcases, Vector <Case> contenuGrille){
    for (int i = 0; i < nbOrganisme ; i++) {
      Random rand = new Random();
      int indice = rand.nextInt(nbcases-i);
      int index_pos = indexgrille.get(indice);
      indexgrille.remove(indice);
      int pos_X = index_pos%20;
      int pos_Y = index_pos/20;
      Case item;
      switch (quelOrganisme){
        case 1 :
            item = new X_cellule(pos_X,pos_Y);
            contenuGrille.add(item);
            break;
        case 2 :
            item = new Y_cellule(pos_X,pos_Y);
            Infectee item_infectee=item.get_infectee();
            contenuGrille.add(item);
            contenuGrille.add(item_infectee);
            break;
        case 3 :
            item = new Z_cellule(pos_X,pos_Y);
            contenuGrille.add(item);
            break;
        case 4 :
            item = new Virus(pos_X,pos_Y);
            contenuGrille.add(item);
            break;
        case 5 :
            item = new Case(pos_X,pos_Y);
            contenuGrille.add(item);
            break;
        default :
            System.out.println("Création d'organisme invalide");
            break;
      }
    }
    return contenuGrille;
  }


  public static Case [][] association_vecteur_grille(Vector <Case> contenuGrille,Case [][] grille){
    grille=creation_grille();
    int x;
    int y;
    for (int i=0;i<contenuGrille.size();i++){
      Case item = contenuGrille.get(i);
      if (item.get_statut()){
        x = item.get_X();
        y = item.get_Y();
        grille[y][x]=item;
      }
    }
    return grille;
  }


  public static void affichage_grille(Case[][] grille, String type){
    try {
      for (int horizontal = 0 ; horizontal < 20 ; horizontal++){
        if (horizontal == 0) {System.out.print("     0"+horizontal+" ");}
        if (horizontal > 0 && horizontal < 10) {System.out.print(" 0"+horizontal+" ");}
        if (horizontal > 9 && horizontal < 20) {System.out.print(" "+horizontal+" ");}
      }
      System.out.println("");
      for (int i=0 ; i < grille.length ; i++){
        if (i <= 9){ System.out.print("0"+i+"  ");}
        else {System.out.print(i+"  ");}
        for (int j=0 ; j < grille[i].length ; j++){
          grille[i][j].affiche(type);
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
