import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Fenetre extends JFrame implements ActionListener{

    // Variables :

    JButton Noir, Rouge, Vert, Bleu, Jaune, Rose, Magenta, Orange, Ellipse, Rectangle, Square, Circle;
    Drawing draw = new Drawing();


    // Constructeur : décrit toute l'interface du paint

    public Fenetre(){

        this.setTitle("Paint"); // Titre de la fenetre
        this.setSize(800,600); // Taille de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme le programme quand on clique sur la croix

        Container contentPanel1 = this.getContentPane();
        contentPanel1.add(draw, "Center");

        // Menu déroulant

        JMenuBar m= new JMenuBar(); // Bar de menu

        // Sous menus

        JMenu menuFile = new JMenu("File");
        JMenu menuAuthors = new JMenu("Authhors");

        // Crétions des items des sous menus

        JMenuItem open = new JMenuItem("Open"); open.addActionListener(this);
        JMenuItem nouveau = new JMenuItem("New"); nouveau.addActionListener(this);
        JMenuItem save = new JMenuItem("Save"); save.addActionListener(this);
        JMenuItem quit = new JMenuItem("Quit"); quit.addActionListener(this);

        JMenuItem Creator = new JMenuItem("Creator"); Creator.addActionListener(this);

        // Ajout des items aux sous menus

        menuFile.add(open);
        menuFile.add(nouveau);
        menuFile.add(save);
        menuFile.add(quit);

        menuAuthors.add(Creator);

        // Ajout des sous menus au menus principal

        m.add(menuFile);
        m.add(menuAuthors);

        contentPanel1.add(m,"North"); // Place le menu déroulant en haut de la fenetre

        // Création des différents bouttons de l'interface :
        Noir = new JButton("Noir"); Noir.setBackground(Color.BLACK);
        Rouge = new JButton("Rouge"); Rouge.setBackground(Color.RED);
        Vert = new JButton("Vert"); Vert.setBackground(Color.GREEN);
        Bleu = new JButton("Bleu"); Bleu.setBackground(Color.BLUE);
        Jaune = new JButton("Jaune"); Jaune.setBackground(Color.YELLOW);
        Rose = new JButton("Rose"); Rose.setBackground(Color.PINK);
        Magenta = new JButton("Magenta"); Magenta.setBackground(Color.MAGENTA);
        Orange = new JButton("Orange"); Orange.setBackground(Color.ORANGE);
        Ellipse = new JButton("Ellipse");
        Rectangle = new JButton("Rectangle");
        Square = new JButton("Square");
        Circle = new JButton("Circle");

        // Affichage des boutons

        JPanel southPanel1 = new JPanel();

        southPanel1.setLayout(new GridLayout(2,6)); // Quadrillage de 2 lignes et 6 colonnes contenants les boutons

        // Ajout des boutons au panel
        southPanel1.add(Noir); Noir.addActionListener(this); // permet d'associer une action à un bouton
        southPanel1.add(Rouge); Rouge.addActionListener(this);
        southPanel1.add(Vert); Vert.addActionListener(this);
        southPanel1.add(Bleu); Bleu.addActionListener(this);
        southPanel1.add(Jaune); Jaune.addActionListener(this);
        southPanel1.add(Rose); Rose.addActionListener(this);
        southPanel1.add(Magenta); Magenta.addActionListener(this);
        southPanel1.add(Orange); Orange.addActionListener(this);
        southPanel1.add(Rectangle); Rectangle.addActionListener(this);
        southPanel1.add(Ellipse); Ellipse.addActionListener(this);
        southPanel1.add(Square); Square.addActionListener(this);
        southPanel1.add(Circle); Circle.addActionListener(this);

        contentPanel1.add(southPanel1,"South");



        this.setVisible(true); // permet d'afficher la fenetre

    }


    // Décrit les actions pour chaque élément de la fenetre
    public void actionPerformed(ActionEvent e){

        String cmd = e.getActionCommand();

        switch (cmd){
            case "Noir" : draw.setCouleur(Color.BLACK);
                break;

            case "Rouge" : draw.setCouleur(Color.red);
                break;

            case "Vert" : draw.setCouleur(Color.green);
                break;

            case "Bleu" : draw.setCouleur(Color.blue);
                break;

            case "Jaune" : draw.setCouleur(Color.yellow);
                break;

            case "Rose" : draw.setCouleur(Color.pink);
                break;

            case "Magenta" : draw.setCouleur(Color.magenta);
                break;

            case "Orange" : draw.setCouleur(Color.orange);
                break;

            case "Rectangle" : draw.setNameFigure("Rectangle");
                break;

            case "Ellipse" : draw.setNameFigure("Ellipse");
                break;

            case "Square" : draw.setNameFigure("Square");
                break;

            case "Circle" : draw.setNameFigure("Circle");
                break;

            case "Creator" : JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog( info, "Authors : Gaël Gourdin", "information",JOptionPane.INFORMATION_MESSAGE);
                break;

            case "New" : draw.reset();
                break;

            case "save" : draw.save();
                break;
        }
    }

    // Excecution : création de la fenetre :

    public static void main (String args[]){
        Fenetre win = new Fenetre();
    }
}
