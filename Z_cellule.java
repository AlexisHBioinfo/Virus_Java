import java.io.*;
import java.util.*;

public class Z_cellule extends Cellule {
  Z_cellule(int case_X, int case_Y){
    super(case_X,case_Y,1); //1 ? Mais on sait pas encore comment gérer la vie
  }


  public void affiche(){
    System.out.print("[zz]");
  }


  public int consequences(int a,int b, boolean type){
    System.out.println("Vous avez atteint une cellule Z !");
    if (type){
      System.out.println("Vous fusionnez avec elle.");
    }
    else{
      System.out.println("Vous l'avez contaminée, elle est morte instantanément. Votre virus gagne 1 point de vie.");
    }
    statut=false;
    return 1;
  }


  public void set_X(int a,int check, Case [][] grille){
    super.set_X(a,check,grille);
    if (check==0){
      case_X+=a;
    }
    else if (check!=4){
      grille[case_Y][case_X+a].set_statut();
      case_X+=a;
    }
  }


  public void set_Y(int b, int check, Case [][] grille){
    super.set_Y(b,check,grille);
    if (check==0){
      case_Y+=b;
    }
    else if (check!=4){
      grille[case_Y+b][case_X].set_statut();
      case_Y+=b;
    }
  }
}
