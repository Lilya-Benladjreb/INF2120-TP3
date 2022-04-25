import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fichier = "./statistiquesFilms.csv";

        CollectionFilms c = new CollectionFilms(fichier);

        System.out.println(c.getNbrFilmsDistincts());
        System.out.println(c.rechecherParTitre("of"));
        Arrays.stream(c.rechercheParProfit(7)).forEach(System.out::println);
        System.out.println(c.rechercherParEvalutaion(3));
    }
}
