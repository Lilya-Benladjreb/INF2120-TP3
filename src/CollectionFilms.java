import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionFilms {
    /**
     * Attribut d'instance :
     * La liste des films dans cette collection
     */
    List<Film> films;

    //Initialisations des constantes
    private static final String DELIMITER = ";";

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
     * • Peut prendre les valeurs : G, PG, PG-13, R, ou NC-17
     * Budget : Le budget alloué pour faire ce film
     * Recettes : Les recettes produites par ce film
     * Date de sortie : La date de sortie de ce film
     * • Sous le format aaaa-mm-jj (ex.: 1989-10-12)
     * Genre : Le genre de ce film
     * • Peut prendre les valeurs : Romance, Comedie, Crime, Guerre,
     * Drame, Famille, Action, Animation, Science Fiction, Aventure,
     * Thriller, Western, Horreur, Mistere, Histoire, et Fantastique.
     * Duree : La durée, en minutes, de ce film
     * Evaluation : Note moyenne (sur 10) attribuée à ce film
     * Nombre d'evaluations : Le nombre d'évaluations sur lequel on a calculé
     * l'évaluation précédente (note moyenne).
     * <p>
     * Le fichier statistiquesFilms.csv, donné avec l'énoncé de ce TP,
     * est un exemple de fichier valide. Notez que dans un fichier valide,
     * tous les films ont un Film ID différent, mais il peut cependant y avoir
     * des doublons. Deux films sont considérés comme des doublons s'ils ont le
     * même titre (titres égaux, sans tenir compte de la casse), la même date
     * de sortie, et la même durée (même si leurs IDs sont différents),
     * en conformité à la méthode equals de la classe Film. De plus, notez que
     * les films, dans un fichier valide, ne sont pas nécessairement triés.
     * <p>
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
     * <p>
     * NOTE :
     * Pour obtenir un objet de type LocalDate à partir d'une date représentée
     * sous forme de chaine de caractères dans le format aaaa-mm-jj, utilisez
     * la méthode de classe parse de la classe LocalDate, de cette manière :
     * LocalDate d = LocalDate.parse("1998-05-23").
     *
     * @param cheminFic Le chemin du fichier CSV qui contient la liste des
     *                  films que contiendra cette collection.
     */
    public CollectionFilms(String cheminFic) {
        Path path = Paths.get(cheminFic);

        try {
            films = Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(ligne -> ligne.split(DELIMITER))
                    .map(this::dataToFilm)
                    .collect(Collectors.toList());
        } catch (Exception ignored) {
            films = new ArrayList<>();
        }

    }


    /**
     * Cette méthode retourne un film avec toutes les informations prisent du
     * fichier CSV. Sert à transformer le data de type String à son type
     * approprié pour créer un objet Film. Si le film est invalide, il
     * retourne un film avec la valeur 'null'.
     * @param listeinfos - liste de String venant du stream, contient les
     *                   informations pour un film divisées par des ";".
     * @return Film film - avec les informations transformés avec le bon type
     *                      donnée. Peut être null si une information n'est
     *                      pas valide.
     */
    private Film dataToFilm(String[] listeinfos) {
        Film film = null;

        int id = Integer.parseInt(listeinfos[0]);
        String titre = listeinfos[1];
        String classementMPAA = listeinfos[2];
        long budget = Long.parseLong(listeinfos[3]);
        long recettes = Long.parseLong(listeinfos[4]);
        LocalDate dateSortie = LocalDate.parse(listeinfos[5]);
        String genre = listeinfos[6];
        int duree = Integer.parseInt(listeinfos[7]);
        double evaluation = Double.parseDouble(listeinfos[8]);
        int nbrEvalutation = Integer.parseInt(listeinfos[9]);


        try {
            film = new Film(id, titre, classementMPAA, budget, recettes,
                    dateSortie, genre, duree, evaluation, nbrEvalutation);
        } catch (FilmInvalideException ignored) {
        }

        return film;
    }

    /**
     * Cette méthode retourne le nombre total de films distincts
     * (sans compter les doublons) dans la collection.
     *
     * @return le nombre de film
     */
    public int getNbrFilmsDistincts() {
        int nbrTotalFilmDistinct = 0;

        nbrTotalFilmDistinct = (int) films.stream()
                .distinct()
                .count();

        return nbrTotalFilmDistinct;

    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) de cette collection qui contiennent, dans leur titre,
     * l'expression donnée en paramètre (sans tenir compte de la casse).
     * Si aucun film n'est trouvé, cette méthode retourne une liste vide.
     * <p>
     * Exemple :
     * En supposant que l'expression donnée en paramètre est bat, les films
     * ayant les titres suivants seraient retournés par cette recherche :
     * • LE BATEAU-MOUCHE
     * • Les Battements d'ailes d'un papillon
     * • Abats et autres mets délicieux.
     * Si le paramètre expression est null ou est égal à la chaine vide,
     * cette méthode retourne une liste vide.
     * De plus, la liste des films retournée doit être triée par titre
     * (sans tenir compte de la casse). Si plusieurs films ont
     * le même titre, ceux-ci doivent être triés entre eux selon leur ID.
     *
     * @param expression Expression qui doit être contenue dans le titre des
     *                   films qu'on recherche.
     * @return resultat
     */
    public List<Film> rechercherParTitre(String expression) {

        return films.stream()
                .filter(listeTitre -> listeTitre.getTitre()
                        .contains(expression))
                .distinct()
                //trier par titre
                .sorted(Comparator.comparing(Film::getTitre))
                //Trier par ID
                .collect(Collectors.toList());
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
     * @param evaluationMinimum  L'évaluation minimum des films recherchés.
     * @return resultatParEvaluation
     */
    public List<Film> rechercherParEvaluation(double evaluationMinimum) {
        return films.stream()
                .distinct()
                .filter(film -> film.getEvaluation() >= evaluationMinimum)
                .sorted(Comparator.comparingDouble((Film::getEvaluation)))
                .collect(Collectors.toList());
    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) dont le genre est présent dans la liste genres donnée
     * en paramètre ET dont l'évaluation est plus grande ou égale à
     * l'évaluationMinimum donné en paramètre. Si aucun film n'est trouvé,
     * la méthode retourne une liste vide.
     * <p>
     * En ce qui concerne la sélection selon le genre, pour qu'un film soit
     * sélectionné, il faut que son genre associé soit exactement égal (mais
     * sans tenir compte de la casse) à l'une des valeurs dans la liste genres
     * donnée. Si la liste genres donnée en paramètre est null ou vide, cette
     * méthode retourne une liste vide. De plus, la liste des films retournée
     * doit être triée par titre (sans tenir compte de la casse). Si plusieurs
     * films ont le même titre, ceux- ci doivent être triés entre eux selon
     * leur ID.
     *
     * @param genres            On cherche les films dont le genre est présent
     *                          dans cette liste.
     * @param evaluationMinimum L'évaluation minimum des films recherchés.
     * @return resultatParGenres
     */
    public List<Film> rechercherParGenres(List<String> genres,
                                         double evaluationMinimum) {
        Predicate<Film> filmParGenre = film ->
                genres.contains(film.getGenre());

        Predicate<Film> filmParEval= film ->
                film.getEvaluation() >= evaluationMinimum;

        return films.stream()
                .distinct()
                .filter(filmParGenre.and(filmParEval))
                //trier par titre, si +1 film ont même titre, trier ID
                .sorted(Comparator.comparing(Film::getTitre))
                .collect(Collectors.toList());
    }

    /**
     * Cette méthode retourne une liste contenant tous les films distincts
     * (sans doublons) dont la date de sortie se trouve entre dateDebut et
     * dateFin inclusivement. Si aucun film n'est trouvé, cette méthode
     * retourne une liste vide.
     * <p>
     * Précisions :
     * * Si dateDebut n'est pas null et dateFin n'est pas null, on
     * recherche les films dont la date de sortie est entre dateDebut et
     * dateFin inclusivement.
     * * Si dateDebut est null et dateFin n'est pas null, on rechercher
     * les films dont la date de sortie est inférieure ou égale à
     * dateFin.
     * * Si dateDebut n'est pas null et dateFin est null, on recherche
     * les films dont la date de sortie est supérieure ou égale à
     * dateDebut.
     * * Si dateDebut est égale à dateFin, on recherche les films dont la
     * date de sortie est égale à dateDebut (ou dateFin).
     * * Cette méthode doit lever une java.util.NoSuchElementException si
     * dateDebut et dateFin sont toutes les deux null ou si dateDebut
     * est supérieure à dateFin.
     * <p>
     * De plus, la liste retournée doit être triée par dates de sortie.
     * Si plusieurs films ont la même date de sortie, ceux-ci doivent être
     * triés entre eux selon leur ID.
     * <p>
     * NOTE :
     * Pour tester si une LocalDate est inférieure, égale ou supérieure à une
     * autre LocalDate, utilisez la méthode compareTo de la classe LocalDate.
     * Note que inférieure signifie antérieure et supérieure signifie
     * postérieure.
     *
     * @param dateDebut La date de sortie inférieure minimale des films
     *                  recherchés. Si cette date est null, il n'y a pas de
     *                  date minimale à considérer pour la recherche.
     * @param dateFin   La date de sortie supérieure maximale des films
     *                  recherchés. Si cette date est null, il n'y a pas de date
     *                  maximale à considérer pour la recherche.
     * @return resultatParPeriode
     */
    public List<Film> rechercherParPeriode(LocalDate dateDebut,
                                          LocalDate dateFin) {
        Stream<Film> sortedFilms;
        Stream<Film> distinctFilms;

        Predicate<Film> filmApresDateDebut = film ->
                film.getDateSortie().compareTo(dateDebut) >= 0;
        Predicate<Film> filmAvantDateFin =  film ->
                film.getDateSortie().compareTo(dateFin) <= 0;

        distinctFilms = films.stream().distinct();

        if ((dateDebut.compareTo(dateFin) > 0)){
            throw new NoSuchElementException();
        }else if (dateDebut.equals(null) && dateFin.equals(null)){
            throw new NoSuchElementException();
        }else if(dateDebut.equals(null) && !dateFin.equals(null)){
            sortedFilms = distinctFilms
                            .sorted(Comparator.comparing(Film::getDateSortie))
                            .filter(filmAvantDateFin);

        }else if(!dateDebut.equals(null) && dateFin.equals(null)){
            sortedFilms =  distinctFilms
                    .sorted(Comparator.comparing(Film::getDateSortie))
                    .filter(filmApresDateDebut);
        }else{
            sortedFilms = distinctFilms
                    .sorted(Comparator.comparing(Film::getDateSortie))
                    .filter(filmApresDateDebut.and(filmAvantDateFin));
        }

        return  sortedFilms
                .sorted(Comparator.comparingInt(Film::getId))
                .collect(Collectors.toList());
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
     * <p>
     * Si n > 0, la méthode doit retourner un tableau contenant les n titres de
     * film les PLUS profitables, et le tableau retourné doit être trié en
     * ordre décroisssant des profits. Si deux films ont le même profit, ils
     * doivent être triés entre eux selon leur ID (en ordre croissant).
     * <p>
     * Si n < 0, la méthode doit retourner un tableau contenant les -n titres
     * de film les MOINS profitables, et le tableau retourné doit être trié en
     * ordre croisssant des profits. Si deux films ont le même profit, ils
     * doivent être triés entre eux selon leur ID (en ordre croissant).
     * <p>
     * Si n = 0, le tableau retourné doit être de longueur 0.
     * Notez que si la valeur absolue de n est plus grande que le nombre de
     * films distincts contenu dans cette collection, la méthode retourne un
     * tableau contenant TOUS les titres des films disctincts de cette
     * collection.
     *
     * @param n Si n est positif, on recherche les n films ayant fait le plus
     *          de profit. Si n est négatif, on recherche les |n| films ayant
     *          fait le moins de profit.
     * @return resultatParProfit
     */
    public String[] rechercherParProfit(int n) {
        Stream<Film> sortedFilms;

        Stream<Film> distinctFilms = films.stream()
                .distinct();

        //Lister dans le bon ordre
        if (n > 0) {
            sortedFilms = distinctFilms.sorted(
                    Comparator.comparingLong(
                            film -> film.getRecettes() - film.getBudget()));
        } else {
            sortedFilms = distinctFilms.sorted(
                    Collections.reverseOrder(
                            Comparator.comparingLong(
                                    film -> film.getRecettes() -
                                            film.getBudget())

            ));
        }

        return sortedFilms
                .limit(Math.abs(n))
                .map(Film::getTitre)
                .toArray(String[]::new);
    }

}
