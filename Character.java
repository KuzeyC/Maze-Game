//kc18182 - 1803189

package maze;

import java.awt.*;

//This class is for the character in the game.
class Character extends Shape {
    int x;
    int y;

    Character(int x, int y) {
        //set the background to green.
        setBG(Color.green);
        //set x and y position.
        setX(x);
        setY(y);
    }

    //Method for moving up.
    void moveUp() {
        this.y--;
    }

    //Method for moving right.
    void moveRight() {
        this.x++;
    }

    //Method for moving down.
    void moveDown() {
        this.y++;
    }

    //Method for moving left.
    void moveLeft() {
        this.x--;
    }

    //Overriding the toString() method to return what I want it to return.
    @Override
    public String toString() {
        return "Character(" + this.x + ", " + this.y + ")";
    }

    @Override
    void setX(int x) {
        this.x = x;
    }

    @Override
    void setY(int y) {
        this.y = y;
    }

    @Override
    void setBG(Color color) {
        this.setBackground(color);
    }
}
