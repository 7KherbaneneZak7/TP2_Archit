import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

         
        

		AffichageComposite AffichageListes = new AffichageComposite();
		IJournal AffichageEcran = new AffichageEcran();
		IJournal AffichageDateClasse = new AffichageDateClasse();
		IJournal AffichageFichier = new AffichageFichier();

		AffichageListes.addAffichage(AffichageFichier);
		AffichageListes.addAffichage(AffichageEcran);
		AffichageListes.addAffichage(AffichageDateClasse);
		AffichageListes.outPut_Msg("Ce message va etre affich� par 3 fa�on diff�rentes");



        InterfaceEtudiantRepository StudRep = new EtudiantRepository();
        InterfaceUniversiteRepository UnivRep= new UniversiteRepository();
		InterfaceEtudiantService  serv=new EtudiantService(StudRep, UnivRep, AffichageListes);
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
