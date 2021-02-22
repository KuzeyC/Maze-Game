//kc18182 - 1803189

package maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

class Game extends JPanel implements Runnable {
    private Character player;
    private Tile[][] maze;
    private long startTime;

    Game(){
        //Start time of the program.
        startTime = System.currentTimeMillis();
        int mazeSize = 20;
        maze = createGrid(mazeSize);
        Thread game = new Thread(this, "Game Thread");
        game.start();

        addKeyListener(new KeyboardListener(this));

        new Maze(maze, mazeSize, mazeSize);
    }

    public void run() {
        boolean running = true;
        //While game is running.
        while (running) {
            requestFocus();
            maze[this.player.x][this.player.y].setComponentZOrder(player, 0);
            repaint();
            //if the player is at the end point, make the game stop running.
            if (this.player.x == 19 && this.player.y == 19) running = false;
        }
        endGame();
    }

    private Tile[][] createGrid(int mazeSize) {
        JPanel mazePanel = new JPanel();
        mazePanel.setLayout(new GridLayout(mazeSize, mazeSize));
        mazePanel.setSize(new Dimension(800,800));

        //Creating the maze grid with tile objects.
        Tile[][] mazeGrid = new Tile[20][20];

        //Making the maze grid have tile object in each position.
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                mazeGrid[j][i] = new Tile(j, i);
                mazePanel.add(mazeGrid[j][i], BorderLayout.CENTER);
            }
        }

        //Set the player to be a new Character with starting position as (0,0).
        this.player = new Character(0, 0);

        //Set the last tile of the maze to red to show the end point.
        mazeGrid[19][19].setBackground(Color.red);

        //Add the mazePanel JPanel to the Game JPanel.
        add(mazePanel);
        //return the grid.
        return mazeGrid;
    }

    private void endGame() {
        long time = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime);
        String gameOverText = "You have beaten the maze in " + time + " seconds. \n\n" + new ReadFromFile().read().toString() + "\n Restart the game to play again.";
        //Write the time taken to finish maze to the file.
        new WriteToFile(time);

        //setup Icon for better user experience.
        ImageIcon icon = new ImageIcon("gameOverIcon.png"); //https://www.flaticon.com/free-icon/game-over_75454
        //Game over JOptionPane.
        JOptionPane.showOptionDialog(null, gameOverText, "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
    }

    void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37://LEFT
                //If there isn't a wall on the left side of the player.
                if (!this.maze[player.x][player.y].walls[3]) {
                    player.moveLeft();
                }
                break;
            case 38://UP
                //If there isn't a wall on the above side of the player.
                if (!this.maze[player.x][player.y].walls[0]) {
                    player.moveUp();
                }
                break;
            case 39://RIGHT
                //If there isn't a wall on the right side of the player.
                if (!this.maze[player.x][player.y].walls[1]) {
                    player.moveRight();
                }
                break;
            case 40://DOWN
                //If there isn't a wall on the below side of the player.
                if (!this.maze[player.x][player.y].walls[2]) {
                    player.moveDown();
                }
                break;
        }
    }
}
