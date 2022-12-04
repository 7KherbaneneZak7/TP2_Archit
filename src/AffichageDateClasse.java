import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AffichageDateClasse implements IJournal {
    String message;
    static String classeName;
    public AffichageDateClasse(){}
    @Override
    public void outPut_Msg(String message) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now)); 
        System.out.println(message + "from "+ classeName); 
    }    
    public static void setClasseName(String classeName){
        this.classeName = classeName;
    }
}
