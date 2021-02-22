//kc18182 - 1803189

package maze;

import javax.swing.*;
import java.awt.*;

//abstract class, that extends from JPanel, for the character and the tile in the maze.
abstract class Shape extends JPanel {
    abstract void setX(int x);
    abstract void setY(int y);
    abstract void setBG(Color color);
}
