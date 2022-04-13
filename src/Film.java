import java.time.LocalDate;
import java.util.Objects;
import java.util.Locale;

/**
 * Classe modelisant un Film. 
 * Classe utilisee pour le TP3 de INF2120 Hiver 2022.
 * @author Melanie Lord
 * @version Hiver 2022
 */
public class Film {

   //Les differentes classifications possibles pour un film
   public final static String[] CLASSEMENTS_MPAA = {
         "G", "PG", "PG-13", "R", "NC-17"
   };

   //Les differents genres possibles pour un film
   public final static String[] GENRES = {
      "Romance", "Comedie", "Crime", "Guerre", "Drame", "Famille", "Action",
      "Animation", "Science Fiction", "Aventure", "Thriller", "Western",
      "Horreur", "Mystere", "Histoire", "Fantastique"
   };

   //Attributs d'instance
   private int id;         //un numero unique pour ce film
   private String titre;   //le titre de ce film
   private String classementMPAA; //le classement MPAA de ce film 
                                  //(voir constante CLASSEMENTS_MPAA)
   private long budget;    //le budget de ce film
   private long recettes;  //les recettes de ce film
   private LocalDate dateSortie; //la date de sortie de ce film
   private String genre;   //le genre de ce film (voir constante GENRES)
   private int duree;      //la duree, en minutes, de ce film
   private double evaluation; //l'evaluation (moyenne) de ce film
   private int nbrEvaluations;//le nombre d'evaluations pour ce film avec 
                              //lesquelles on a calcule l'evaluation moyenne

   /**
    * Construit un film en initialisant ses attributs avec les parametres donnes.
    * @param id un numero unique pour ce film
    * @param titre le titre de ce film
    * @param classementMPAA le classement MPAA pour ce film
    * @param budget le budget pour ce film
    * @param recettes les recettes produites par ce film
    * @param dateSortie la date de sortie de ce film
    * @param genre le genre de ce film
    * @param duree la duree, en minutes, de ce fiml
    * @param evaluation l'evaluation moyenne de ce film
    * @param nbrEvaluations le nombre d'evaluations avec lesquelles on a calcule
    *                       l'evaluation moyenne
    * @throws FilmInvalideException si l'un des parametres est invalide.
    */
   public Film (int id, String titre, String classementMPAA, long budget,
         long recettes, LocalDate dateSortie, String genre, int duree, 
         double evaluation, int nbrEvaluations) throws FilmInvalideException {
   
      //Si l'un des parametres est invalides, leve une FilmInvalideException
      if (id <= 0 ||
            titre == null || titre.isEmpty() ||
            classementMPAA == null || classementMPAA.isEmpty() || 
            !valeurEstDansTab(CLASSEMENTS_MPAA, classementMPAA) ||
            budget <= 0 || recettes <= 0 || dateSortie == null ||
            genre == null || genre.isEmpty() || 
            !valeurEstDansTab(GENRES, genre) ||
            duree <= 0 ||
            evaluation <= 0 || nbrEvaluations <= 0) {
         
         throw new FilmInvalideException();
      }
      
      this.id = id;
      this.titre = titre;
      this.classementMPAA = classementMPAA;
      this.budget = budget;
      this.recettes = recettes;
      this.dateSortie = dateSortie;
      this.genre = genre;
      this.duree = duree;
      this.evaluation = evaluation;
      this.nbrEvaluations = nbrEvaluations;
   }
   
   /**
    * Permet d'obtenir l'id de ce film.
    * @return l'id de ce film.
    */
   public int getId() {
      return id;
   }

   /**
    * Permet d'obtenir le titre de ce film.
    * @return le titre de ce film. 
    */
   public String getTitre() {
      return titre;
   }

   /**
    * Permet d'obtenir le classement MPAA de ce film.
    * @return le classement MPAA de ce film. 
    */
   public String getClassementMPAA() {
      return classementMPAA;
   }

   /**
    * Permet d'obtenir le budget de ce film.
    * @return le budget de ce film.
    */
   public long getBudget() {
      return budget;
   }

   /**
    * Permet d'obtenir les recettes de ce film.
    * @return les recettes de ce film.
    */
   public long getRecettes() {
      return recettes;
   }

   /**
    * Permet d'obtenir la date de sortie de ce film.
    * @return la date de sortie de ce film.
    */
   public LocalDate getDateSortie() {
      return dateSortie;
   }

   /**
    * Permet d'obtenir le genre de ce film.
    * @return le genre de ce film.
    */
   public String getGenre() {
      return genre;
   }

   /**
    * Permet d'obtenir la duree (en minutes) de ce film.
    * @return la duree (en minutes) de ce film.
    */
   public int getDuree() {
      return duree;
   }

   /**
    * Permet d'obtenir l'evaluation (moyenne) de ce film.
    * @return l'evaluation (moyenne) de ce film.
    */
   public double getEvaluation() {
      return evaluation;
   }

   /**
    * Permet d'obtenir le nombre d'evaluations de ce film.
    * @return le nombre d'evaluations de ce film.
    */
   public int getNbrEvaluations() {
      return nbrEvaluations;
   }
   
   /**
    * Construit une representation sous forme de chaine de caracteres de 
    * ce film, sur une ligne, ayant le format suivant :
    * 
    * id dateSortie titre (duree min) - genre - classement MPAA - 
    *                         [evaluation/nbrEvaluations] - budget$/recettes$
    * 
    * @return une representation sous forme de chaine de caracteres de ce film
    */
   @Override
   public String toString() {
      return String.format("%3d ", id) + dateSortie + " " + titre 
         + " (" + duree + " min) - " + this.genre + " - " 
         + this.classementMPAA + " - [" 
         + String.format(Locale.ENGLISH, "%3.1f", evaluation) + "/" 
         + this.nbrEvaluations + "] - " 
         + this.budget + "$/" + this.recettes + "$";
   }
   
   /**
    * Deux films sont consideres egaux si leurs attributs 
    * titre (sans tenir compte de la casse), dateSortie, et duree sont egaux.
    * Si obj est null, cette methode retourne false.
    * 
    * @param obj le film avec lequel on veut comparer ce film.
    * @return true si ce film est egal a obj, false sinon.
    */
   @Override
   public boolean equals(Object obj) {
      Film autreFilm;
      boolean egaux = this == obj;
      
      if (!egaux) {
         if (obj != null && getClass() == obj.getClass()) {
            autreFilm = (Film)obj;
         
            egaux = Objects.equals(this.titre.toLowerCase(), 
                                   autreFilm.titre.toLowerCase())
                  && Objects.equals(this.dateSortie, autreFilm.dateSortie)
                  && Objects.equals(this.duree, autreFilm.duree);
         }
      }
      return egaux;
   }
   
   /**
    * Construit et retourne un hashcode pour ce film.  
    * Si deux films f1 et f2 sont egaux (f1.equals(f2) retourne true), cette 
    * methode retourne le meme hashcode pour f1 et f2.
    * 
    * Note : 
    *    Cette methode est necessaire pour que l'utilisation de la methode 
    *    Stream.distinct() sur un stream de films fonctionne.
    * 
    * @return un hashcode pour ce film. 
    */
   @Override
   public int hashCode() {
      int hash = 17;
      hash = 31 * hash + Objects.hashCode(this.titre);
      hash = 31 * hash + Objects.hashCode(this.dateSortie);
      hash = 31 * hash + Objects.hashCode(this.duree);
         
      return hash;
   }

   /**
    * Teste si la valeur donnee est dans le tab donne (sans tenir compte de 
    * la casse). 
    * @param tab le tableau dans lequel chercher la valeur donnee (sans tenir
    *            compte de la casse).
    *            ANT : tab est non null, et ne contient aucune valeur null.
    * @param valeur la valeur dont on veut savoir si elle appartient au tab donne
    * @return true si valeur est dans tab, false sinon.
    */
   private boolean valeurEstDansTab(String[] tab, String valeur) {
      int i = 0;
      boolean trouve = false;
      while (i < tab.length && !trouve) {
         trouve = tab[i].equalsIgnoreCase(valeur);
         i++;
      }
      return trouve;
   }

}
