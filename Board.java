//kc18182 - 1803189

package maze;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.border.*;

class Board extends JFrame {
    Board() {
        //JPanel for the menu.
        JPanel menu = new JPanel();
        menu.setBackground(new Color(227, 146, 84));
        //Button for start game.
        JButton startBut = createButton("Start Game");

        //Button for how to play.
        JButton howToPlayBut = createButton("How to Play");

        //Button for scores.
        JButton scoresBut = createButton("Scores");

        //Action Listener for the How to Start Button.
        startBut.addActionListener(actionEvent -> {
            setSize(new Dimension(800, 800));
            menu.setVisible(false);
            remove(menu);
            Game game = new Game();
            add(game);
            game.setLayout(new GridLayout());
            setLocationRelativeTo(null);
        });

        //Action Listener for the How to Play Button.
        howToPlayBut.addActionListener(actionEvent -> {
            ImageIcon icon = new ImageIcon("howToPlayIcon.png"); //https://www.flaticon.com/free-icon/question-mark_36601
            String howToPlayText = "This is a Maze game. \nThe objective of the game is to \nget to the end point (red) in the \nshortest time possible by \nmoving the character (green) with arrow keys. \nA new maze is generated every game.";
            JOptionPane.showOptionDialog(null, howToPlayText, "How To Play", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, JOptionPane.OK_OPTION);
        });

        //Action Listener for the Scores Button.
        scoresBut.addActionListener(actionEvent -> {
            ImageIcon icon = new ImageIcon("scoresIcon.png"); //https://www.flaticon.com/free-icon/trophy_263056
            JOptionPane.showOptionDialog(null, new ReadFromFile().read().toString(), "Scores", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, JOptionPane.OK_OPTION);
        });

        //add the buttons to the menu JPanel.
        menu.add(startBut);
        menu.add(howToPlayBut);
        menu.add(scoresBut);

        //Add the menu JPanel to the JFrame.
        add(menu);
        //Setup the JFrame.
        setup();
    }

    //Setting up the JFrame
    private void setup() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(new GridLayout());
        setSize(new Dimension(400, 500));
        setLocationRelativeTo(null);
        setTitle("Maze - kc18182 - 1803189");
    }

    //Method for create buttons easily.
    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 100));
        button.setBackground(new Color(235, 177, 134));
        button.setBorder(new LineBorder(new Color(135, 86, 50)));
        return button;
    }
}
