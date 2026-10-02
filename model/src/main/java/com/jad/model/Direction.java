package com.jad.model;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction turnLeft(final Direction direction) {
        return Direction.values()[(direction.ordinal() - 1 + Direction.values().length) % Direction.values().length];
    }

    public static Direction turnRight(final Direction direction) {
        return Direction.values()[(direction.ordinal() + 1 + Direction.values().length) % Direction.values().length];
    }
}
