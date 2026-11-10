import java.io.*;

public class Exercice2 {
    public static void main(String[] args) throws IOException {
        String chemin = "tp_fichiers/produits.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(chemin));
 pw.println("1;Ordinateur;5600.0");
 pw.println("2;Imprimante;1200.5");
 pw.println("3;Clavier;150.0");
 pw.println("4;Ecran;1800.0");
 pw.close();

 BufferedReader br = new BufferedReader(new FileReader(chemin));
    String ligne;
    int nb = 0;
     double total = 0, prixMax = -1;
        String plusCher = "";

        while ((ligne = br.readLine()) != null) {
            String[] champs = ligne.split(";");
            int num = Integer.parseInt(champs[0]);
            String designation = champs[1];
            double prix = Double.parseDouble(champs[2]);

            System.out.println(num + " -- " + designation + " -- " + prix + " DH");

            nb++;
            total += prix;
            if (prix > prixMax) {
                prixMax = prix;
                plusCher = designation;
            }
        }
        br.close();
 System.out.println("Nombre de produits : " + nb);
 System.out.println("Prix total : " + total + " DH");
 System.out.println("Produit le plus cher : " + plusCher);

        FileWriter fw = new FileWriter(chemin, true);
        fw.write("5;Souris;80.0\n");
        fw.close();

  FileReader fr = new FileReader(chemin);
       int c, nbCaracteres = 0, nbLignes = 0;
        while ((c = fr.read()) != -1) {
            nbCaracteres++;
            if (c == '\n') nbLignes++;
        }
        fr.close();

        System.out.println("Caractères : " + nbCaracteres);
        System.out.println("Lignes : " + nbLignes);
    }
}
