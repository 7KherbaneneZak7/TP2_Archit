public class AffichageEcran implements IJournal  {
    String message;
    public AffichageEcran(){}
    @Override
    public void outPut_Msg(String message) {
        System.out.println(message);
    }
}
