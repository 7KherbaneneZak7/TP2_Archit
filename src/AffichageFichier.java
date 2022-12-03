import java.io.FileWriter;
import java.io.IOException;

public class AffichageFichier implements IJournal {
    String message;
    public AffichageFichier(){}
    public void outPut_Msg (String message){
    try {
      FileWriter fichier = new FileWriter("filename.txt");
      fichier.write(message);
      fichier.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
