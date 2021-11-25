import java.awt.*;

public class Square extends Rectangle{ // Sous classe de Rectangle

    // Constructeur :

    public  Square(int px, int py, Color c){ // Constructeur
        super(px, py, c);
    }


    // La méthode est redéfini car la forme n'est pas la même que pour un rectangle

    public void setBoundingBox (int heightBB, int widthBB){
        super.length = Math.max(heightBB, widthBB);
        super.width = Math.max(heightBB, widthBB);
    }

}
