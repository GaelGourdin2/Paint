import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener {

    // Variables :

    private Color couleur;
    private ArrayList<Figure> list = new ArrayList<>();
    private String nameFigure;
    private int x, y;


    public Drawing(){ // Constructeur

        this.setBackground(Color.white);
        this.x = 0;
        this.y = 0;
        this.list.add(new Rectangle(0, 0, Color.BLACK));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    // Methodes :

    // Supprime les éléments présents sur le paint
    public void reset() {
        list.clear();
        super.paintComponent(this.getGraphics());
    }

    // Sauvegarde du fichier :

    public void save(){
         try{
             FileOutputStream fos = new FileOutputStream("sauveDessin");
             ObjectOutputStream oos = new ObjectOutputStream(fos);

             oos.writeInt(list.size());
             for(Figure f : list){
                 oos.writeObject(f);
                 }
             oos.close();
             }
         catch (Exception e){
             System.out.println("Problemos !");
             }
         }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        this.setBackground(Color.white);

        for (Figure figure : list){
            figure.draw(g);
        }

    }


    // Override des méthodes abstraites des classes abstraites implémentées

    // Ajuste la taille de la dernière figure de la liste en fonction des déplacement de la souris
    public void mouseDragged(MouseEvent e){

        this.list.get(this.list.size() - 1).setBoundingBox(e.getX() - this.x, e.getY() - this.y);
        this.repaint();
    }

    // Ajoute une figure à la liste en fonction de la figure selectionée
    public void mousePressed(MouseEvent e){

        // Récupèere les coordonnées de la souris
        this.x = e.getX();
        this.y = e.getY();

        switch (nameFigure){
            case "Rectangle" : this.list.add(new Rectangle(x, y, couleur));
                break;

            case "Ellipse" : this.list.add(new Ellipse(x, y, couleur));
                break;

            case "Circle" : this.list.add(new Circle(x, y, couleur));
                break;

            case "Square" : this.list.add(new Square(x, y, couleur));
                break;
        }

    }

    // Les autres méthodes n'ont pas besoins d'être détaillées

    public void mouseMoved(MouseEvent e){

    }

    public void mouseClicked(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){
    }


    // Getters and Setters :

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public String getNameFigure() {
        return nameFigure;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }
}
