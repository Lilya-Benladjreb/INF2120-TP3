import java.time.LocalDate;
import java.util.List;

public class CollectionFilms {
    /**
     * Attribut d'instance :
     * La liste des films dans cette collection
     */
    List<Film> film;

    /**
     * Constructeur :
     * Ce constructeur lit chacun des films contenus dans le fichier donné en
     * paramètre, et construit la liste des films (attribut films). Le fichier
     * est formaté de la façon suivante (supposez qu'il est valide c.-à-d.
     * formaté correctement, et qu'il n'y manque aucune donnée) : chaque ligne
     * du fichier (sauf la première) contient les informations sur un film.
     * Chaque information correspond à une colonne, et chaque colonne est
     * séparée par un point-virgule. Voici les entêtes des colonnes
     * (se trouvant toujours sur la première ligne du fichier) que vous devrez
     * utiliser pour construire les objets de type Films qui doivent être
     * stockés dans la liste films.
     * Film ID : Numéro d'identification unique du film
     * Titre : Titre du film
     * Classement MPAA : Classement MPAA pour ce film.
     *                  • Peut prendre les valeurs : G, PG, PG-13, R, ou NC-17
     * Budget : Le budget alloué pour faire ce film
     * Recettes : Les recettes produites par ce film
     * Date de sortie : La date de sortie de ce film
     *                  • Sous le format aaaa-mm-jj (ex.: 1989-10-12)
     * Genre : Le genre de ce film
     *         • Peut prendre les valeurs : Romance, Comedie, Crime, Guerre,
     *        Drame, Famille, Action, Animation, Science Fiction, Aventure,
     *        Thriller, Western, Horreur, Mistere, Histoire, et Fantastique.
     * Duree : La durée, en minutes, de ce film
     * Evaluation : Note moyenne (sur 10) attribuée à ce film
     * Nombre d'evaluations : Le nombre d'évaluations sur lequel on a calculé
     *                        l'évaluation précédente (note moyenne).
     *
     * Le fichier statistiquesFilms.csv, donné avec l'énoncé de ce TP,
     * est un exemple de fichier valide. Notez que dans un fichier valide,
     * tous les films ont un Film ID différent, mais il peut cependant y avoir
     * des doublons. Deux films sont considérés comme des doublons s'ils ont le
     * même titre (titres égaux, sans tenir compte de la casse), la même date
     * de sortie, et la même durée (même si leurs IDs sont différents),
     * en conformité à la méthode equals de la classe Film. De plus, notez que
     * les films, dans un fichier valide, ne sont pas nécessairement triés.
     *
     * IMPORTANT :
     * 1. Tous les films contenus dans le fichier passé en paramètre doivent
     * être présents dans la liste film créée (même les doublons, s'il y a
     * lieu).
     * 2. L'ordre des films, dans la liste films créée, doit respecter l'ordre
     * des films dans le fichier donné en paramètre.
     * 3. Si le fichier reçu en paramètre ne peut pas être lu (est null, est
     * inexistant sur le disque, etc.) ou s'il existe, mais qu'il est vide,
     * alors la collection créée demeure vide (sa liste films a une longueur
     * égale à 0).
     *
     * NOTE :
     * Pour obtenir un objet de type LocalDate à partir d'une date représentée
     * sous forme de chaine de caractères dans le format aaaa-mm-jj, utilisez
     * la méthode de classe parse de la classe LocalDate, de cette manière :
     * LocalDate d = LocalDate.parse("1998-05-23").
     *
     * @param cheminFic Le chemin du fichier CSV qui contient la liste des
     *                  films que contiendra cette collection.
     */
    public CollectionFilms(String cheminFic){

    }

    /**
     * Cette méthode retourne le nombre total de films distincts
     * (sans compter les doublons) dans la collection.
     * @return le nombre de film
     */
    public int getNbrFilmsDistincts(){
        int nbrTotalFilmDistinct = 0;

        return nbrTotalFilmDistinct;

    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) de cette collection qui contiennent, dans leur titre,
     * l'expression donnée en paramètre (sans tenir compte de la casse).
     * Si aucun film n'est trouvé, cette méthode retourne une liste vide.
     *
     * Exemple :
     * En supposant que l'expression donnée en paramètre est bat, les films
     * ayant les titres suivants seraient retournés par cette recherche :
     *      • LE BATEAU-MOUCHE
     *      • Les Battements d'ailes d'un papillon
     *      • Abats et autres mets délicieux.
     * Si le paramètre expression est null ou est égal à la chaine vide,
     * cette méthode retourne une liste vide.
     * De plus, la liste des films retournée doit être triée par titre
     * (sans tenir compte de la casse). Si plusieurs films ont
     * le même titre, ceux-ci doivent être triés entre eux selon leur ID.
     *
     * @param expression Expression qui doit être contenue dans le titre des
     *                  films qu'on recherche.
     * @return resultat
     */
    public List<Film> rechecherParTitre(String expression){
        List<Film> resultatParTitre;

        return resultatParTitre;
    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) de cette collection qui possèdent une évaluation plus
     * grande ou égale à evaluationMinimum. Si aucun film n'est trouvé, cette
     * méthode retourne une liste vide. De plus, la liste des films retournée
     * doit être triée par évaluation. Si plusieurs des films retournés ont la
     * même évaluation, ceux-ci doivent être triés entre eux selon leur genre
     * (sans tenir compte de la casse), et si plusieurs films ont la même
     * évaluation, et le même genre, ceux-ci doivent être triés entre eux
     * selon leur ID.
     *
     * @param evaluationMinimum
     * @return
     */
    public List<Film> rechercherParEvalutaion(double evaluationMinimum){
        List<Film> resultatParEvaluation;

        return resultatParEvaluation;
    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) dont le genre est présent dans la liste genres donnée
     * en paramètre ET dont l'évaluation est plus grande ou égale à
     * l'évaluationMinimum donné en paramètre. Si aucun film n'est trouvé,
     * la méthode retourne une liste vide.
     *
     * En ce qui concerne la sélection selon le genre, pour qu'un film soit
     * sélectionné, il faut que son genre associé soit exactement égal (mais
     * sans tenir compte de la casse) à l'une des valeurs dans la liste genres
     * donnée. Si la liste genres donnée en paramètre est null ou vide, cette
     * méthode retourne une liste vide. De plus, la liste des films retournée
     * doit être triée par titre (sans tenir compte de la casse). Si plusieurs
     * films ont le même titre, ceux- ci doivent être triés entre eux selon
     * leur ID.
     *
     * @param genres On cherche les films dont le genre est présent dans cette
     *               liste.
     * @param evaluationMinimum L'évaluation minimum des films recherchés.
     * @return resultatParGenres
     */
    public List<Film> rechercheParGenres(List<String> genres,
                                         double evaluationMinimum){
        List<Film> resultatParGenres;

        return resultatParGenres;
    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) dont la date de sortie se trouve entre dateDebut et
     * dateFin inclusivement. Si aucun film n'est trouvé, cette méthode
     * retourne une liste vide.
     *
     * Précisions :
     *      * Si dateDebut n'est pas null et dateFin n'est pas null, on
     *        recherche les films dont la date de sortie est entre dateDebut et
     *        dateFin inclusivement.
     *      * Si dateDebut est null et dateFin n'est pas null, on rechercher
     *        les films dont la date de sortie est inférieure ou égale à
     *        dateFin.
     *      * Si dateDebut n'est pas null et dateFin est null, on recherche
     *        les films dont la date de sortie est supérieure ou égale à
     *        dateDebut.
     *      * Si dateDebut est égale à dateFin, on recherche les films dont la
     *        date de sortie est égale à dateDebut (ou dateFin).
     *      * Cette méthode doit lever une java.util.NoSuchElementException si
     *        dateDebut et dateFin sont toutes les deux null ou si dateDebut
     *        est supérieure à dateFin.
     *
     * De plus, la liste retournée doit être triée par dates de sortie.
     * Si plusieurs films ont la même date de sortie, ceux-ci doivent être
     * triés entre eux selon leur ID.
     *
     * NOTE :
     * Pour tester si une LocalDate est inférieure, égale ou supérieure à une
     * autre LocalDate, utilisez la méthode compareTo de la classe LocalDate.
     * Note que inférieure signifie antérieure et supérieure signifie
     * postérieure.
     *
     * @param dateDebut La date de sortie inférieure minimale des films
     *                  recherchés. Si cette date est null, il n'y a pas de
     *                  date minimale à considérer pour la recherche.
     * @param dateFin La date de sortie supérieure maximale des films
     *               recherchés. Si cette date est null, il n'y a pas de date
     *               maximale à considérer pour la recherche.
     * @return resultatParPeriode
     */
    public List<Film> rechercheParPeriode(LocalDate dateDebut,
                                         LocalDate dateFin){
        List<Film> resultatParPeriode;

        return resultatParPeriode;
    }

    /**
     * Cette méthode retourne un tableau de longueur minimale contenant les n
     * titres de film distincts (sans doublons) qui ont généré le plus de
     * profit ou le moins de profit. Un tableau de longueur minimale signifie
     * que sa longueur est égale au nombre d'éléments qu'il contient. En
     * d'autres mots, si la méthode retourne x titres de film, le tableau
     * doit être de longueur x. Notez qu'on calcule ici le profit d'un film en
     * faisant la différence entre ses recettes et son budget
     * (recettes - budget).
     *
     * Si n > 0, la méthode doit retourner un tableau contenant les n titres de
     * film les PLUS profitables, et le tableau retourné doit être trié en
     * ordre décroisssant des profits. Si deux films ont le même profit, ils
     * doivent être triés entre eux selon leur ID (en ordre croissant).
     *
     * Si n < 0, la méthode doit retourner un tableau contenant les -n titres
     * de film les MOINS profitables, et le tableau retourné doit être trié en
     * ordre croisssant des profits. Si deux films ont le même profit, ils
     * doivent être triés entre eux selon leur ID (en ordre croissant).
     *
     * Si n = 0, le tableau retourné doit être de longueur 0.
     * Notez que si la valeur absolue de n est plus grande que le nombre de
     * films distincts contenu dans cette collection, la méthode retourne un
     * tableau contenant TOUS les titres des films disctincts de cette
     * collection.
     * @param n Si n est positif, on recherche les n films ayant fait le plus
     *          de profit. Si n est négatif, on recherche les |n| films ayant
     *          fait le moins de profit.
     * @return resultatParProfit
     */
    public String[] rechercheParProfit(int n){
        String[] resultatParProfit;

        return resultatParProfit;
    }
}
