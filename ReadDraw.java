import java.util.ArrayList;
import java.util.HashMap;



public class ReadDraw {

  public static final int CATEGORY = 3;
  public static final int INTERVALSTART=5;
  public static final int INTERVALEND = 16;

  public int[] arr1 = new int[INTERVALEND - INTERVALSTART];
  public int[] arr2 = new int[INTERVALEND - INTERVALSTART];

  /**
  * Get the headers of the input file as a HashMap
  */
  public HashMap<Integer,String> getTopics(Kattio io){
    String[] header = io.readLine().split(",");
    HashMap<Integer, String> ans = new HashMap<Integer, String>();
    for(int i=0; i<header.length; i++){
      ans.put(i, header[i]);
    }
    return ans;
  }

  public int readInt(String word){
    int ans = 0;
    try{
      ans = Integer.parseInt(word);
    } catch (Exception e) {
    }
    return ans;
  }




  public static void main(String[] args) {

    Kattio io = new Kattio(System.in, System.out);
    ReadDraw controller = new ReadDraw();
    HashMap<Integer, String> header = controller.getTopics(io);
    String line = io.readLine();
    int compCount = 0; int otherCount =0;
    while (line != null){
      String[] tmp = line.split(",");
      if(tmp[CATEGORY].contains("Computer") ){
        compCount++;
        for(int i=0; i<INTERVALEND - INTERVALSTART; i++)
          controller.arr1[i] += controller.readInt(tmp[i + INTERVALSTART]);
      } else {
        otherCount++;
        for(int j=0; j<INTERVALEND - INTERVALSTART; j++)
          controller.arr2[j] += controller.readInt(tmp[j + INTERVALSTART]);
      }

      line = io.readLine();
    }

    for(int i = 0; i<controller.arr1.length; i++) System.out.println(controller.arr1[i]/compCount);
  }

}
