package com.jad.view;

import com.jad.controller.IController;
import com.jad.model.IModel;

public class View implements IView {
    private final IModel model;
    private IController controller;

    public View(final IModel model) {
        this.model = model;
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }
}
