package com.jad.controller;

import com.jad.model.IModel;
import com.jad.view.IView;

public class Controller implements IController {
    private final IModel model;
    private final IView view;

    public Controller(final IModel model, final IView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }


    @Override
    public void proceed() {
        for (; ; ) {
            try {
                Thread.sleep(30);
                this.view.displayScreen();
                this.view.handleInput();
                this.model.moveAll();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
