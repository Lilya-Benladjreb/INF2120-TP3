import java.time.LocalDate;
import java.util.List;


public class Main {

    private static final String FICHIER_TEST = "./ficPourTestsPartiels.csv";
    private static final CollectionFilms COLLECTION =
            new CollectionFilms(FICHIER_TEST);

    public static void TestGetNbrFilmsDistincts() {
        int ExpectedFilmsDistincts = 19;
        int ResultFilmsDistincts = COLLECTION.getNbrFilmsDistincts();

        if (ExpectedFilmsDistincts != ResultFilmsDistincts) {
            System.out.println("TestGetNbrFilmsDistincts : [ ERROR ] Expected"
                    + " value: " + ExpectedFilmsDistincts + ". Result: "
                    + ResultFilmsDistincts);
        } else {
            System.out.println("TestGetNbrFilmsDistincts : [ PASSED ]");

        }
    }

    public static void TestRechercherParPeriode(){
        int ExceptedLongueurFilmParPeriode = 10 ;
        LocalDate dateDebut = LocalDate.parse("1989-06-22");
        LocalDate dateFin = LocalDate.parse("2001-02-17");


        int ResultListeFilmParPeriode = COLLECTION
                .rechercherParPeriode(dateDebut, dateFin).size();

        if(ExceptedLongueurFilmParPeriode != ResultListeFilmParPeriode){
            System.out.println("TestRechercherParPeriode: [ ERROR ] Expected"
                    + " value: " + ExceptedLongueurFilmParPeriode + ". Result: "
                    + ResultListeFilmParPeriode);
        } else {
            System.out.println("TestGetNbrFilmsDistincts : [ PASSED ]");

        }

    }

    public static void TestRechercherParPeriodeDateDebutIsNull(){
        int ExceptedLongueurFilmParPeriode = 1 ;
        LocalDate dateDebut = null;
        LocalDate dateFin = LocalDate.parse("1983-04-18");


        int ResultListeFilmParPeriode = COLLECTION
                .rechercherParPeriode(dateDebut, dateFin).size();

        if(ExceptedLongueurFilmParPeriode != ResultListeFilmParPeriode){
            System.out.println("TestRechercherParPeriodeDateDebutIsNull:" +
                    " [ ERROR ] Expected"
                    + " value: " + ExceptedLongueurFilmParPeriode + ". Result: "
                    + ResultListeFilmParPeriode);
        } else {
            System.out.println("TestRechercherParPeriodeDateDebutIsNull " +
                    ": [ PASSED ]");

        }
    }

    public static void TestRechercherParPeriodeDateFinIsNull(){
        int ExceptedLongueurFilmParPeriode = 7 ;
        LocalDate dateDebut = LocalDate.parse("2002-09-07");
        LocalDate dateFin = null;


        int ResultListeFilmParPeriode = COLLECTION
                .rechercherParPeriode(dateDebut, dateFin).size();

        if(ExceptedLongueurFilmParPeriode != ResultListeFilmParPeriode){
            System.out.println("TestRechercherParPeriode: [ ERROR ] Expected"
                    + " value: " + ExceptedLongueurFilmParPeriode + ". Result: "
                    + ResultListeFilmParPeriode);
        } else {
            System.out.println("TestGetNbrFilmsDistincts : [ PASSED ]");

        }
    }

    public static void main(String[] args) {

        TestGetNbrFilmsDistincts();
        TestRechercherParPeriode();
        TestRechercherParPeriodeDateDebutIsNull();
        TestRechercherParPeriodeDateFinIsNull();
    }
}

