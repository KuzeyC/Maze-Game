//kc18182 - 1803189

package maze;

import java.awt.*;

class Tile extends Shape {
    int x;
    int y;
    boolean visited;
    boolean[] walls = {true, true, true, true};

    Tile(int x, int y) {
        //Make tile properly sized.
        this.setLayout(new BorderLayout());
        //set the background to light gray.
        setBG(Color.lightGray);
        //set x and y position.
        setX(x);
        setY(y);
        this.visited = false;
    }

    //paintComponent to add walls.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1));

        //Add top wall.
        if (this.walls[0])
            g2d.drawLine(0,0, this.getWidth(), 0);
        //Add right wall.
        if (this.walls[1])
            g2d.drawLine(this.getWidth(), 0, this.getWidth(), this.getHeight());
        //Add bottom wall.
        if (this.walls[2])
            g2d.drawLine(0, this.getHeight(), this.getHeight(), this.getWidth());
        //Add left wall.
        if (this.walls[3])
            g2d.drawLine(0, 0, 0, this.getHeight());
    };

    //Overriding the toString() method to return what I want it to return.
    @Override
    public String toString() {
        return "Tile(" + this.x + ", " + this.y + ")   Walls(" + this.walls[0] + ", " + this.walls[1] + ", " + this.walls[2] + ", " + this.walls[3] + ")";
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
