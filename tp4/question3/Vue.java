
package question3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Vue extends JPanel implements Observer {// à compléter

    private JLabel etatPile, capacitePile;
    private PileModele<Integer> pile;

    String EmptyPileText = "Entrez des nombres entiers:";
    
    public Vue(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        
        this.capacitePile = new JLabel("Capacite = " + this.pile.capacite());
        this.etatPile = new JLabel(EmptyPileText);
        setLayout(new BorderLayout());
        add(capacitePile, BorderLayout.NORTH);
        add(etatPile, BorderLayout.CENTER);
        setBackground(Color.green);
        // inscription auprès du modèle comme observateur
        pile.addObserver(this);
        
        Vue2 vue2 = new Vue2(pile);
        add(vue2, BorderLayout.SOUTH);
    }

    public void update(Observable obs, Object arg) {
        if(pile.toString().equals("Sommet >> [] << Fin")) etatPile.setText(EmptyPileText);
        else etatPile.setText(obs.toString());
    }

}
