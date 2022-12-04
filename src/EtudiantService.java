import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService implements InterfaceEtudiantService{
	private InterfaceEtudiantRepository StudRep;
    private InterfaceUniversiteRepository UnivRep;
	private IJournal  AffichageListes;
	public EtudiantService(InterfaceEtudiantRepository EtudRep ,InterfaceUniversiteRepository UnivRep,  IJournal AffichageListes) {
		super();
		this.StudRep = EtudRep;
		this.UnivRep = UnivRep;
		this.AffichageListes = AffichageListes;
   }
	
	@Override
	public
	boolean inscription (int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException	
	{
		
	    InterfaceEtudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    InterfaceUniversite univ=UnivRep.GetById(id_universite);
	    
	    System.out.println("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }
	    
	    if (StudRep.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (StudRep.Exists(email))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	
	
	
@Override
public ArrayList<InterfaceEtudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

@Override
public ArrayList<InterfaceEtudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
