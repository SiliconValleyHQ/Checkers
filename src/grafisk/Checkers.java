package grafisk;

/**
 * Created by Weeto on 28/11/2016.
 */

/*
   This applet lets two uses play checkers against each other.
   Red always starts the game.  If a player can jump an opponent's
   piece, then the player must jump.  When a plyer can make no more
   moves, the game ends.

   This file defines four classes: the main applet class, Checkers;
   CheckersCanvas, CheckersMove, and CheckersData.
   (This is not very good style; the other classes really should be
   nested classes inside the Checkers class.)
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;


public class Checkers extends Applet {

   /* The main applet class only lays out the applet.  The work of
      the game is all done in the CheckersCanvas object.   Note that
      the Buttons and Label used in the applet are defined as
      instance variables in the CheckersCanvas class.  The applet
      class gives them their visual appearance and sets their
      size and positions.*/

    public void init() {

        setLayout(null);  // I will do the layout myself.

        setBackground(new Color(0,150,0));  // Dark green background.

      /* Create the components and add them to the applet. */

        CheckersCanvas board = new CheckersCanvas();
        // Note: The constructor creates the buttons board.resignButton
        // and board.newGameButton and the Label board.message.
        add(board);

        board.newGameButton.setBackground(Color.lightGray);
        add(board.newGameButton);

        board.resignButton.setBackground(Color.lightGray);
        add(board.resignButton);

        board.message.setForeground(Color.green);
        board.message.setFont(new Font("Serif", Font.BOLD, 14));
        add(board.message);

      /* Set the position and size of each component by calling
         its setBounds() method. */

        board.setBounds(20,20,164,164); // Note:  size MUST be 164-by-164 !
        board.newGameButton.setBounds(210, 60, 100, 30);
        board.resignButton.setBounds(210, 120, 100, 30);
        board.message.setBounds(0, 200, 330, 30);
    }

} // end class Checkers


