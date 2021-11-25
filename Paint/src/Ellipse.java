import java.awt.Color;
import java.awt.Graphics;


public class Ellipse extends Figure { // Sous classe de Figure

    // Variables :

    protected int semiAxisX = 0;
    protected int semiAxisY = 0;


    public Ellipse (int px, int py, Color c){ // Constructeur
        super(c, new Point(px,py));
    }

    // Overrride des méhtodes abstraites de Figure :

    // Défini le dessin pour toute les directions de la souris
    public void draw (Graphics g){

        g.setColor(super.couleur);

        if (semiAxisX > 0 && semiAxisY > 0) {
            g.fillOval(point.getX(), point.getY(), semiAxisX, semiAxisY);
        } else if (semiAxisX > 0 && semiAxisY < 0) {
            g.fillOval(point.getX(), point.getY() + this.semiAxisY, this.semiAxisX, -this.semiAxisY);
        } else if (semiAxisX < 0 && semiAxisY > 0) {
            g.fillOval(point.getX() + semiAxisX, point.getY(), -semiAxisX, semiAxisY);
        } else {
            g.fillOval(point.getX() + semiAxisX, point.getY() + semiAxisY, -semiAxisX, -semiAxisY);
        }
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        this.semiAxisX = heightBB;
        this.semiAxisY = widthBB;
    }
}
