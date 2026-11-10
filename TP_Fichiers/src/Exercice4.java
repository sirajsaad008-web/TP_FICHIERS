import java.io.*;
import java.util.ArrayList;

public class Exercice4 {

    static ArrayList<Produit> lireProduits(String fichier) throws IOException {
        ArrayList<Produit> liste = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne;
        while ((ligne = br.readLine()) != null) {
            String[] c = ligne.split(";");
            liste.add(new Produit(Integer.parseInt(c[0]), c[1], Float.parseFloat(c[2])));
        }
        br.close();
        return liste;
    }

    static void sauvegarder(ArrayList<Produit> liste, String nom) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nom));
        oos.writeObject(liste);
        oos.close();
        System.out.println(liste.size() + " produits sauvegardés");
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Produit> charger(String nom) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nom));
            ArrayList<Produit> liste = (ArrayList<Produit>) ois.readObject();
            ois.close();
            return liste;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();   
        }
    }

    public static void main(String[] args) {
        String fichierDat = "tp_fichiers/stock.dat";
        try {
            ArrayList<Produit> liste = lireProduits("tp_fichiers/produits.txt");
            sauvegarder(liste, fichierDat);

            liste = charger(fichierDat);
            liste.add(new Produit(6, "Webcam", 350));
            sauvegarder(liste, fichierDat);

            liste = charger(fichierDat);
            for (Produit p : liste) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichier introuvable : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe introuvable lors de la lecture : " + e.getMessage());
        }
    }
}
