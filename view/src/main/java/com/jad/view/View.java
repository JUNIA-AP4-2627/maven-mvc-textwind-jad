package com.jad.view;

import com.jad.controller.IController;
import com.jad.model.IModel;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

public class View implements IView {
    private final IModel model;
    private IController controller;
    private TextWindow textWindow;

    public View(final IModel model) {
        this.model = model;
        TextWindowSettings textWindowSettings = new TextWindowSettings();
        textWindowSettings.setScreenWidth(80);
        textWindowSettings.setScreenHeight(40);
        textWindowSettings.setTitle("Tron by JAD");
        textWindowSettings.setFontSize(16f);
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void displayMessage(final String message) {
        this.textWindow.display(message);
    }

    @Override
    public void displayScreen() {
        final Screen screen = this.model.getScreen();
        StringBuilder screenStr = new StringBuilder();
        for (int row = 0; row < screen.dimension().height; row++) {
            for (int column = 0; column < screen.dimension().width; column++) {
                screenStr.append(screen.sprites()[row][column].ascii());
            }
            screenStr.append("\n");
        }
        this.textWindow.display(screenStr.toString());
    }
}
