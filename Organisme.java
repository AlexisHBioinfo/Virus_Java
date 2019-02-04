import java.io.*;
import java.util.*;
abstract public class Organisme {
  private int point_de_vie;
  private int position_X;
  private int position_Y;
  public Organisme (x,y,hp){
    position_X=x;
    position_Y=y;
    point_de_vie=hp;
  }


  public void deplacement(){

  }


  public abstract void mourir();



}
