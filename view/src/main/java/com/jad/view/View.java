package com.jad.view;

import com.jad.controller.IController;
import com.jad.model.IModel;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class View implements IView {
    private final IModel model;
    private IController controller;
    private TextWindow textWindow;
    private HashMap<String, Boolean> pressedKeys;

    public View(final IModel model) {
        this.model = model;
        TextWindowSettings textWindowSettings = new TextWindowSettings();
        textWindowSettings.setScreenWidth(160);
        textWindowSettings.setScreenHeight(40);
        textWindowSettings.setTitle("Tron by JAD");
        textWindowSettings.setFontSize(16f);
        textWindowSettings.addKeyboardListener(KeyEvent.VK_LEFT, "left");
        textWindowSettings.addKeyboardListener(KeyEvent.VK_RIGHT, "right");
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
        this.pressedKeys = new HashMap<>();
        this.pressedKeys.put("left", false);
        this.pressedKeys.put("right", false);

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
                screenStr.append(screen.sprites()[row][column].ascii());
            }
            screenStr.append("\n");
        }
        this.textWindow.display(screenStr.toString());
    }

    @Override
    public void handleInput() {
        if (this.textWindow.isOn("left")) {
            if (!this.pressedKeys.get("left")) {
                this.model.turnLeft();
                this.pressedKeys.put("left", true);
            }
        } else {
            this.pressedKeys.put("left", false);
        }
        if (this.textWindow.isOn("right")) {
            if (!this.pressedKeys.get("right")) {
                this.model.turnRight();
                this.pressedKeys.put("right", true);
            }
        } else {
            this.pressedKeys.put("right", false);
        }
    }
}
