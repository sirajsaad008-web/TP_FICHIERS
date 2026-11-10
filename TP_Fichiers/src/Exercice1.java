import java.io.*;

public class Exercice1 {
    public static void main(String[] args) throws IOException {
File dossier = new File("tp_fichiers");
if (!dossier.exists()) {
	dossier.mkdir();
	System.out.println("Répertoire créé : " + dossier.getAbsolutePath());
        }
 new File(dossier, "a.txt").createNewFile();
 new File(dossier, "b.txt").createNewFile();
 new File(dossier, "archives").mkdir();
 
 int nbFichiers = 0, nbRepertoires = 0;
        for (String nom : dossier.list()) {
          File f = new File(dossier, nom);
            if (f.isDirectory()) {
                System.out.println("[REP] " + nom);
                nbRepertoires++;
            } else {
                System.out.println("[FICHIER] " + nom + " (" + f.length() + " octets)");
                nbFichiers++;
            }
        }
        System.out.println(nbFichiers + " fichier(s), " + nbRepertoires + " répertoire(s)");
    }
}
