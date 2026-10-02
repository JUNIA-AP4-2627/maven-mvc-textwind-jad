package com.jad.model;

import java.awt.*;

public class LightCycle {
    private final Grid grid;
    private Point position;
    private Direction direction;

    public LightCycle(final Point position, final Direction direction, final Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.grid.setTileAt(Tile.WALL, this.position);
    }

    public Point getPosition() {
        return this.position;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void turnLeft() {
        this.direction = Direction.turnLeft(this.direction);
    }

    public void turnRight() {
        this.direction = Direction.turnRight(this.direction);
    }

    public void moveForward() {
        final int newX = this.position.x + ((this.direction.ordinal() % 2 == 1)
                ? 2 - this.direction.ordinal()
                : 0);

        final int newY = this.position.y + ((this.direction.ordinal() % 2 == 0)
                ? this.direction.ordinal() - 1
                : 0);
        this.position = this.grid.wrapPosition(new Point(newX, newY));
        this.grid.setTileAt(Tile.WALL, this.position);
    }

}
