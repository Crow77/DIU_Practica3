/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3diu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author dilmasae
 */
public class Estela extends JPanel {
    
    private LinkedList<Point> puntos;
    private Color colorFondo, colorFigura;
    private String figura;
    private int c;
    
    private final int MEDIDA = 10;
    private final int PUNTO_TRIANGULO = 7;
    private final int ULTIMA_POSICION = 4;

    public Estela() {
        puntos = new LinkedList<>();
        colorFondo = Color.WHITE;
        colorFigura = Color.BLACK;
        figura = "Circulo";
        c = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        this.setBackground(colorFondo);
        g.setColor(colorFigura);
        
        switch(figura) {
            case "Circulo":
                for(Point punto : puntos) g.fillOval(punto.x, punto.y, MEDIDA, MEDIDA);
                break;
            case "Cuadrado":
                for(Point punto : puntos) g.fillRect(punto.x, punto.y, MEDIDA, MEDIDA);
                break;
            case "Triangulo":
                for(Point punto : puntos) {
                    int[] x = new int[]{punto.x - PUNTO_TRIANGULO, punto.x, punto.x + PUNTO_TRIANGULO};
                    int[] y = new int[]{punto.y + PUNTO_TRIANGULO, punto.y - PUNTO_TRIANGULO, punto.y + PUNTO_TRIANGULO};
                    g.fillPolygon(x, y, 3);
                }
                break;    
        }

    }
    
    public void add(int x, int y) {
        c++;
        
        if(c % 15 == 0) {
            
            c = 0;
            
            if(puntos.size() <= ULTIMA_POSICION) puntos.add(new Point(x, y));
            else {
                puntos.remove(ULTIMA_POSICION);
                puntos.add(0, new Point(x, y));
            }
        }
        
    }
    
    public void vaciar() {
        puntos.clear();
    }

    public LinkedList<Point> getPuntos() {
        return puntos;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public Color getColorFigura() {
        return colorFigura;
    }
    
    public String getFigura() {
        return figura;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
        this.setBackground(colorFondo);
    }

    public void setColorFigura(Color colorFigura) {
        this.colorFigura = colorFigura;
    }
    
    public void setFigura(String figura) {
        this.figura = figura;
    }
    
}
