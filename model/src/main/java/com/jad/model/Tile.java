package com.jad.model;

import com.jad.view.Sprite;

public enum Tile {
    WALL(true, new Sprite('#')),
    EMPTY(true, new Sprite('.')),
    ;

    private final boolean obstacle;
    private final Sprite sprite;

    Tile(final boolean obstacle, final Sprite sprite) {
        this.obstacle = obstacle;
        this.sprite = sprite;
    }

    public boolean isObstacle() {
        return this.obstacle;
    }

    public Sprite getSprite() {
        return this.sprite;
    }
}
