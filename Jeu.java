import java.io.*;
import java.util.*;
import java.util.Vector;
import java.util.Random;
import java.lang.*;


public class Jeu {
  public static void main(String[] arg){
      Case[][] grille = creation_grille();
      Y_cellule item = new Y_cellule(12,12);
      Virus item2 = new Virus(13,18);
      grille[13][18] = item2;
      grille[12][12] = item ;
      grille = repartition(grille,15,1,1);
      affichage_grille(grille);
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
  public static Case[][] repartition(Case[][] grille, int nbX, int nbY, int nbZ){
    int nbV = 10;
    int[] indicegrille = new int[400];
    for (int a = 0; a<400 ; a++){
      indicegrille[a] = a;
    }
    return grille;
    for (int i = 0; i < nbX ; i++) {
      Random rand = new Random();
      int indice = rand.nextInt(400-i);
      int index_pos = indicegrille[indice];
      int pos_X = index_pos%20;
      int pos_Y = index_pos/20;
      grille[pos_X][pos_Y] = new X_cellule(pos_X,pos_Y);
      indicegrille = ArrayUtils.removeElement(indicegrille,indice);
    }
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
        if (i <= 9){ System.out.print(i+"   ");}
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
}
