import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure{ // Sous classe de Figure

    // Variables :

    protected int length = 0, width = 0;


    public Rectangle (int px, int py, Color c){ // Constructeur

        super(c, new Point(px, py));  //Appel au constructeur de la classe Figure
    }


    // Override des méhtodes abstraites de Figure :

    // Défini le dessin pour toute les directions de la souris
    public void draw (Graphics g){

        g.setColor(couleur);

        if (width > 0 && length > 0) {
            g.fillRect(point.getX(), super.point.getY(), width, length);
        } else if (width > 0 && length < 0) {
            g.fillRect(point.getX(), point.getY() + length, width, -length);
        } else if (width < 0 && length > 0) {
            g.fillRect(point.getX() + width, point.getY(), -width, length);
        } else {
            g.fillRect(point.getX() + width, point.getY() + length, -width, -length);
        }
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.length = widthBB;
        this.width = heightBB;
    }

    // Getters, Setters

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
