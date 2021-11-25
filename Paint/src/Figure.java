import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure {

    // Variables : protected pour pouvoir les utiliser uniquement dans les sous classes

    protected Point point;
    protected Color couleur;


    public Figure(Color couleur, Point point){ // Constructeur
        this.couleur = couleur;
        this.point = point;
    }

    // Méthodes absraites à redéfinir dans les sous classes :

    public abstract void draw (Graphics g);
    public abstract void setBoundingBox (int heightBB, int widthBB);

    @Override
    public String toString() {
        return "Figure {" +
                "origine = " + point +
                ", couleur = " + couleur +
                '}';
    }

    // Getter/Setter :

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

}

