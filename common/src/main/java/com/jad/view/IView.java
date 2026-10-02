package com.jad.view;

import com.jad.controller.IController;

public interface IView {
    void setController(IController controller);

    void displayMessage(final String message);

    void displayScreen();

    void handleInput();
}
