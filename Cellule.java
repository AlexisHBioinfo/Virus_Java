import java.io.*;
import java.util.*;
abstract public class Cellule extends Organisme {
  String numero;
  static int cpt =0;
  String type = "Cellule";
  public Cellule (){
    super();
    numero = cpt;
    cpt++;
  }
