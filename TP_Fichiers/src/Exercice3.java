import java.io.*;

public class Exercice3 {

    static void copierAvecNumeros(String source, String dest) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));

        String ligne;
        int n = 1;
        while ((ligne = br.readLine()) != null) {
            bw.write(n + ": " + ligne);
            bw.newLine();
            n++;
        }
        br.close();
        bw.close();
    }

    static long copierBinaire(String source, String dest) throws IOException {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(dest);

        int octet;
        long compteur = 0;
        while ((octet = in.read()) != -1) {
            out.write(octet);
            compteur++;
        }
        in.close();
        out.close();
        return compteur;
    }

    public static void main(String[] args) throws IOException {
        copierAvecNumeros("tp_fichiers/produits.txt", "tp_fichiers/produits_num.txt");

        long octets = copierBinaire("tp_fichiers/produits.txt",
                                    "tp_fichiers/archives/produits_copie.txt");
        System.out.println(octets + " octets copiés");

        long tailleOriginal = new File("tp_fichiers/produits.txt").length();
        long tailleCopie = new File("tp_fichiers/archives/produits_copie.txt").length();
        System.out.println("Même taille : " + (tailleOriginal == tailleCopie));
    }
}
