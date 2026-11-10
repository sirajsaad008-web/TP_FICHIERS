import java.io.*;

public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;

    private int num;
    private String designation;
    private float prix;

    public Produit(int num, String designation, float prix) {
        this.num = num;
        this.designation = designation;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return num + " -- " + designation + " -- " + prix;
    }
}
