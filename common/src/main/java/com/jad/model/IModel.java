package com.jad.model;

import com.jad.view.Screen;

public interface IModel {

    Screen getScreen();

    void moveAll();

    void turnLeft();

    void turnRight();
}
