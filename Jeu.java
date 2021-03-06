import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Random;
import java.lang.*;
import java.util.Arrays;


public class Jeu {
  public static void main(String[] arg){
    Vector <Case> contenuGrille = new Vector <> ();
    Case[][] grille = creation_grille();
    Menu(grille,contenuGrille);
  }

///////////////////////////////          MENUS            //////////////////////////////////////////////////////////////////
  public static void Menu(Case[][] grille,Vector <Case> contenuGrille){
    int choix;
    boolean run = true;
    while (run){
      try {
        System.out.println("~~~~~~~~~~~ Que voulez-vous faire ?~~~~~~~~~~~\n");
        System.out.println("1. Sélection du niveau.");
        System.out.println("2. Lecture des règles.");
        System.out.println("3. Quitter la simulation.\n");
        choix = saisie_entier();
      }
      catch (NumberFormatException e){
        System.out.println("Veuillez saisir un entier !");
        choix = 5;
      }
      System.out.println();
      switch (choix){
        case 1 :
          Menu_niveaux(grille,contenuGrille);
          run = false;
          break;
        case 2 :
          Regles();
          break;
        case 3 :
          run = false;
          break;
        default :
          System.out.println("Choix non valide");
          break;
      }
    }
  }


  public static void Menu_niveaux(Case[][] grille,Vector <Case> contenuGrille){
    System.out.println("~~~~~~~~~~~ Quel niveau voulez-vous tenter ?~~~~~~~~~~~\n");
    System.out.println("1. Facile");
    System.out.println("2. Intermédiaire");
    System.out.println("3. Difficile\n");
    int choix;
    boolean go = true;
    int config;
    while (go){
      try {
        choix = saisie_entier();
        System.out.println();
      }
      catch (NumberFormatException e){
        System.out.println("Veuillez saisir un entier !");
        choix=5;
      }
      switch (choix){
        case 1 :
          grille = repartition_organismes(grille,15,30,55,contenuGrille);
          go = false;
          break;
        case 2 :
          grille = repartition_organismes(grille,20,40,40,contenuGrille);
          go = false;
          break;
        case 3 :
          grille = repartition_organismes(grille,25,50,25,contenuGrille);
          go = false;
          break;
        default :
          System.out.println("Choix non valide");
          break;
      }
    }
    config=5;
    do {
      try {
        System.out.println("Voulez-vous jouer contre l'ordinateur (tapez 0) ou contre un joueur (tapez 1) ?");
        config = saisie_entier();
        go = false;
      }
      catch (NumberFormatException e){
        System.out.println("Veuillez saisir un entier !");
        config=5;
      }
    } while ((config!=0) && (config!=1));
    affichage_grille(grille, "Virus");
    boolean tour = true;
    int cpt_tour = 0;
    while ((tour) && (Virus.cpt<Cellule.cpt)){
      System.out.println("\n\nVoulez vous quitter ? Si oui entrez 0, si non, appuyez juste sur entrée !\n");
      System.out.println();
      int choix_exit;
      try {
        choix_exit=saisie_entier();
      }
      catch (NumberFormatException e){
        choix_exit=5;
      }
      if (choix_exit==0){
        tour = false;
      }
      else {
        contenuGrille=Menu_Virus(grille,contenuGrille);
        System.out.println("\n\nIl reste encore "+Cellule.cpt+" cellules et "+Virus.cpt+" virus en jeu.");
        grille=association_vecteur_grille(contenuGrille,grille);
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
        grille=association_vecteur_grille(contenuGrille,grille);
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
    boolean bad_input=true;
    while (((want_X !=42) || (want_Y != 42)) && (Virus.cpt!=mv_virus)) {
      bad_input=true;
      while (bad_input){
        try {
          System.out.println("\n                                  >> JOUEUR VIRUS <<            \n");
          System.out.println("\n~~~~~~~~~~~ Quel virus voulez-vous déplacer (1 déplacement maximum par virus par tour) ?~~~~~~~~~~~\n");
          System.out.println("Vous pouvez bouger autant de virus que vous le souhaitez !");
          System.out.println("Rentrez le numéro de la colonne voulue faites ENTREE puis rentrez les numéro de la ligne.");
          System.out.println("Tapez '42' deux fois pour finir votre tour.\n");
          System.out.println("\n\nVous pouvez bouger encore "+(Virus.cpt-mv_virus)+" virus.\n");
          want_X = saisie_entier();
          want_Y = saisie_entier();
          System.out.println();
          bad_input=false;
          if ((want_X != 42) && (want_Y != 42)){
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
        catch (NumberFormatException e){
          System.out.println("Veuillez saisir des entiers !");
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
    boolean bad_input=true;
    while (((want_X !=42) || (want_Y != 42)) && (10!=mv_cellule)) {
      bad_input=true;
      while (bad_input){
        try {
          System.out.println("\n                                  >> JOUEUR CELLULE <<            \n");
          System.out.println("\n~~~~~~~~~~~ Quelle cellule voulez-vous déplacer (1 déplacement maximum par cellule par tour) ?~~~~~~~~~~~\n");
          System.out.println("Vous pouvez bouger jusqu'à 10 cellules que vous le souhaitez !");
          System.out.println("Rentrez le numéro de la colonne voulue faites ENTREE puis rentrez les numéro de la ligne.");
          System.out.println("Tapez '42' deux fois pour finir votre tour.\n");
          System.out.println("\n\nVous pouvez bouger encore "+(10-mv_cellule)+" cellule(s).\n");
          want_X = saisie_entier();
          want_Y = saisie_entier();
          System.out.println();
          bad_input=false;
          if ((want_X != 42) && (want_Y != 42)){
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
        catch (NumberFormatException e){
          System.out.println("Veuillez saisir des entiers !");
        }
      }
    }
    return contenuGrille;
  }


  public static Vector <Case> Menu_Cellule_ordi(Case[][] grille, Vector <Case> contenuGrille){
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("\n                                  >> ORDINATEUR <<            \n");
    int mv_cellule=0;
    boolean valide;
    while (mv_cellule<=10){
      Random rand = new Random();
      int indice_X = rand.nextInt(20);
      int indice_Y = rand.nextInt(20);
      valide=grille[indice_X][indice_Y].Menu_deplacements_ordi(grille,true);
      if (valide){
        try {
          Thread.sleep(500);
        }
        catch (InterruptedException e){
        }
        System.out.println("\n                                       ...             \n");
        mv_cellule++;
        grille=association_vecteur_grille(contenuGrille,grille);
      }
    }
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


/////////////////////////////   INITIALISATION DE LA GRILLE    /////////////////////////////////////////////


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


/////////////////////////         PREMIERE REPARTITION DES OBJETS DANS LA GRILLE         ////////////////////////////////////



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
    contenuGrille = repartition(indexgrille, nbX,1, nbcases,contenuGrille);     // CREE UN NOMBRE NBX DE CELLULE X
    contenuGrille = repartition(indexgrille, nbY,2, nbcasesX,contenuGrille);    // CREE UN NOMBRE NBY DE CELLULE Y
    contenuGrille = repartition(indexgrille, nbZ,3, nbcasesY,contenuGrille);    // CREE UN NOMBRE NBZ DE CELLULE Z
    contenuGrille = repartition(indexgrille, 10,4,nbcasesZ,contenuGrille);      // CREE 10 VIRUS
    contenuGrille = repartition(indexgrille, 290, 5, 290,contenuGrille);        // CREE 290 CASES VIDES
    grille=association_vecteur_grille(contenuGrille,grille);                    // PLACE LES OBJETS DANS LA GRILLE
    return grille;
  }


////////////////////////          CREATION DES OBJETS AVEC COORDONNEES ALEATOIRES              ////////////////////////


  public static Vector <Case> repartition(Vector <Integer> indexgrille, int nbOrganisme, int quelOrganisme, int nbcases, Vector <Case> contenuGrille){
    for (int i = 0; i < nbOrganisme ; i++) {
      Random rand = new Random();
      int indice = rand.nextInt(nbcases-i);
      int index_pos = indexgrille.get(indice);
      indexgrille.remove(indice);
      int pos_X = index_pos%20;
      int pos_Y = index_pos/20;
      switch (quelOrganisme){
        case 1 :
            X_cellule itemX = new X_cellule(pos_X,pos_Y);
            contenuGrille.add(itemX);
            break;
        case 2 :
            Y_cellule itemY = new Y_cellule(pos_X,pos_Y);
            Infectee item_infectee=itemY.get_infectee();
            contenuGrille.add(itemY);
            contenuGrille.add(item_infectee);
            break;
        case 3 :
            Z_cellule itemZ = new Z_cellule(pos_X,pos_Y);
            contenuGrille.add(itemZ);
            break;
        case 4 :
            Virus itemV = new Virus(pos_X,pos_Y,5);
            contenuGrille.add(itemV);
            break;
        case 5 :
            Case itemC = new Case(pos_X,pos_Y);
            contenuGrille.add(itemC);
            break;
        default :
            System.out.println("Création d'organisme invalide");
            break;
      }
    }
    return contenuGrille;
  }


////////////////// PARCOURT DU VECTEUR ET REPLACEMENT DES OBJETS DANS LA GRILLE /////////////////


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


//////////////////////////////   AFFICHAGE DE LA GRILLE SUR LE TERMINAL ////////////////////////////


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
}
