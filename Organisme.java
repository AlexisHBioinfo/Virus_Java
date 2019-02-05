import java.io.*;
import java.util.*;
abstract public class Organisme extends Case{
  protected int point_de_vie;
  public Organisme (int case_X, int case_Y, int hp){
    super(case_X,case_Y);
    point_de_vie=hp;
  }

  //
  // public void deplacement(){
  //
  // }
  //
  //
  // public abstract void mourir();
  //


}
