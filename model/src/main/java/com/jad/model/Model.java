package com.jad.model;

import com.jad.view.Screen;
import com.jad.view.Sprite;

import java.awt.*;

public class Model implements IModel {
    static final Dimension GRID_DIMENSION = new Dimension(80, 40);

    private final Grid grid;

    public Model() {
        this.grid = new Grid(Model.GRID_DIMENSION);
    }

    @Override
    public Screen getScreen() {
        Sprite[][] sprites = new Sprite[Model.GRID_DIMENSION.height][Model.GRID_DIMENSION.width];
        for (int row = 0; row < Model.GRID_DIMENSION.height; row++) {
            for (int column = 0; column < Model.GRID_DIMENSION.width; column++) {
                sprites[row][column] = this.grid.getTileAt(new Point(column, row)).getSprite();
            }
        }
        return new Screen(Model.GRID_DIMENSION, sprites);
    }
}
