import java.awt.*;

public class Circle extends Ellipse{ // Sous classe de Ellipse

    // Constructeur :

    public Circle(int px, int py, Color c){ // Constructeur
        super(px,py,c);
    }

    // La méthode est redéfini car la forme n'est pas la même que pour une ellipse

    public void setBoundingBox (int heightBB, int widthBB){
            super.semiAxisX = Math.max(heightBB, widthBB);
            super.semiAxisY = Math.max(heightBB,widthBB);
    }
}
