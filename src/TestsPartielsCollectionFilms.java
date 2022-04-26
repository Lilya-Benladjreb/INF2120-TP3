
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


/**
 * Classe de TESTS PARTIELS pour tester la classe CollectionFilms.
 * Executez la methode main et verifiez que ce qui s'affiche a la console
 * (resultats obtenus) est identique a ce qui est montre dans le fichier 
 * resultatsAttendus.txt fourni avec cette classe de tests partiels.
 * 
 * Cette classe de tests NE TESTENT PAS TOUS LES CAS. Vous devrez faire vos 
 * propres tests pour tester correctement votre classe CollectionFilms.
 * 
 * INF2120 : TP3 Hiver 2022
 * @author melanie lord
 * @version H22
 */
public class TestsPartielsCollectionFilms {
   
   public final static String FIC = "ficPourTestsPartiels.csv";
   
   /**
    * Affiche le titre donne en majuscule et entre deux lignes de tirets de 
    * meme longueur.
    * @param titre le titre a afficher.
    */
   private static void titre (String titre) {
      String s = "\n";
      for (int i = 0 ; i < titre.length() ; i++) {
         s = s + "-";
      }
      s = s + "\n" + titre.toUpperCase() + "\n";
      for (int i = 0 ; i < titre.length() ; i++) {
         s = s + "-";
      }
      
      System.out.println(s);
   }
   
   /**
    * Retourne une representation sous forme de chaine de caracteres de la liste
    * donnee en parametre.
    * @param <T> le type des elements dans liste.
    * @param liste la liste dont on veut une representation sous forme de chaine
    *              de caracteres.
    * @return une representation sous forme de chaine de caracteres de la liste
    * donnee en parametre
    */
   private static <T> String toString(List<T> liste) {
      String s;
      
      if (liste == null) {
         s = "Liste null";
      } else if (liste.isEmpty()) {
         s = "[ ]";
      } else {
         s = "[";
         for (T elt : liste) {
            s = s + "\n " + elt;
         }
         s = s + "\n]";
      }
      return s;
   }
   

   public static void main(String[] args) {
      List<Film> liste;
      CollectionFilms cf = new CollectionFilms(FIC);
      String[] tab;
      
      titre("test - get nbr distincts");
      
      System.out.println("cf.getNbrFilmsDistincts()");
      System.out.println(cf.getNbrFilmsDistincts());
      
      //-------------------------------------------------------------
      
      titre("test - rechercher par titre");
      
      System.out.println("cf.rechercherParTitre(\"pic\")");
      liste = cf.rechercherParTitre("pic");
      System.out.println(toString(liste));  
      
      //-------------------------------------------------------------
      
      titre("tests - rechercher par evaluation");
      
      System.out.println("cf.rechercherParEvaluation(2)");
      liste = cf.rechercherParEvaluation(2);
      System.out.println(toString(liste)); 
      
      System.out.println("\ncf.rechercherParEvaluation(8.3)");
      liste = cf.rechercherParEvaluation(8.3);
      System.out.println(toString(liste) + "\n"); 
      
      //-------------------------------------------------------------
      
      titre("tests - rechercher par genres");
      
      System.out.println("\ncf.rechercherParGenres"
         + "(Arrays.asList(\"ANIMATION\", \"romance\", \"Comedie\", null), 5.8)");
      liste = cf.rechercherParGenres(Arrays.asList(
         "ANIMATION", "romance", "Comedie", null), 5.8);
      System.out.println(toString(liste)); 
      
      System.out.println("\ncf.rechercherParGenres"
         + "(Arrays.asList(\"\", \"guerre\", \"abc\"), 7.3)");
      liste = cf.rechercherParGenres(Arrays.asList("", "guerre", "abc"), 7.3);
      System.out.println(toString(liste)); 
      
      System.out.println("\ncf.rechercherParGenres"
         + "(Arrays.asList(\"\", \"guerre\", \"abc\"), 7.2)");
      liste = cf.rechercherParGenres(Arrays.asList("", "guerre", "abc"), 7.2);
      System.out.println(toString(liste));
      
      //-------------------------------------------------------------
      
      titre("tests - rechercher par periode");
      
      System.out.println("\ncf.rechercherParPeriode"
         + "(1989-06-22, 2001-02-17))");
      liste = cf.rechercherParPeriode(LocalDate.parse("1989-06-22"), 
         LocalDate.parse("2001-02-17"));
      System.out.println(toString(liste));
      
      System.out.println("\ncf.rechercherParPeriode(2002-09-07, null)");
      liste = cf.rechercherParPeriode(LocalDate.parse("2002-09-07"), null);
      System.out.println(toString(liste));
      
      System.out.println("\ncf.rechercherParPeriode(null, 1983-04-18)");
      liste = cf.rechercherParPeriode(null, LocalDate.parse("1983-04-18"));
      System.out.println(toString(liste));
      
      //-------------------------------------------------------------
      
      titre("tests - rechercher par profit");
      
      System.out.println("\ncf.rechercherParProfit(9)");
      tab = cf.rechercherParProfit(9);
      System.out.println(toString(Arrays.asList(tab)));
      
      System.out.println("\ncf.rechercherParProfit(-5)");
      tab = cf.rechercherParProfit(-5);
      System.out.println(toString(Arrays.asList(tab)));

   }
   
}
