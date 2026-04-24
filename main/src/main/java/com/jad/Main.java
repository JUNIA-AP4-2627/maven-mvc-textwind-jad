package com.jad;

import com.jad.controller.Controller;
import com.jad.controller.IController;
import com.jad.model.IModel;
import com.jad.model.Model;
import com.jad.view.IView;
import com.jad.view.View;

public enum Main {
    ;

    public static void main(String[] args) {
        IModel model = new Model();
        IView view = new View(model);
        IController controller = new Controller(model, view);
        controller.proceed();
    }
}