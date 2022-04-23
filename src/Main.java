public class Main {
    public static void main(String[] args) {
        String fichier = "./statistiquesFilms.csv";

        CollectionFilms c = new CollectionFilms(fichier);

        System.out.println(c.getNbrFilmsDistincts());
        System.out.println(c.rechecherParTitre("Batman"));
    }
}
