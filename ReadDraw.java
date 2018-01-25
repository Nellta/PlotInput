import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jfree.ui.RefineryUtilities;




public class ReadDraw {

  public static final int CATEGORY = 3;
  public static final int INTERVALSTART=5;
  public static final int INTERVALEND = 16;

  public int[] arr1 = new int[INTERVALEND - INTERVALSTART];
  public int[] arr2 = new int[INTERVALEND - INTERVALSTART];
  public int compCount;
  public int otherCount;
  public HashMap<Integer, String> header;

  /**
  * Get the headers of the input file as a HashMap
 * @throws IOException 
  */
  public void getTopics(Kattio io) throws IOException{
    String[] tmp = io.readLine().split(",");
    header = new HashMap<Integer, String>();
    for(int i=0; i<tmp.length; i++){
      header.put(i, tmp[i]);
    }
    
  }

  public int readInt(String word){
    int ans = 0;
    try{
      ans = Integer.parseInt(word);
    } catch (Exception e) {
    }
    return ans;
  }




  public static void main(String[] args) throws IOException {

    Kattio io = new Kattio(System.in, System.out);
    ReadDraw controller = new ReadDraw();
    controller.getTopics(io);
    
    String line = io.readLine();
    while (line != null){
      String[] tmp = line.split(",");
      if(tmp[CATEGORY].contains("Computer") ){
        controller.compCount++;
        for(int i=0; i<INTERVALEND - INTERVALSTART; i++)
          controller.arr1[i] += controller.readInt(tmp[i + INTERVALSTART]);
      } else {
        controller.otherCount++;
        for(int j=0; j<INTERVALEND - INTERVALSTART; j++)
          controller.arr2[j] += controller.readInt(tmp[j + INTERVALSTART]);
      }

      try{line = io.readLine();} catch (Exception e) {
		// TODO: handle exception
    	  line = null;
    	 }
    }
    
    io.close();
    final DualAxisChart graph = new DualAxisChart("A Chart", controller );
    graph.pack();
    RefineryUtilities.centerFrameOnScreen(graph);
    graph.setVisible(true);
    
  }

}
