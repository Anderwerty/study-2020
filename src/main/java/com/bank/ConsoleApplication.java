package com.bank;

import com.bank.controller.ApplicationController;
import com.bank.injector.ContextInjector;

public class ConsoleApplication {
    public static void main(String[] args) {

        ApplicationController controller = ContextInjector.INSTANCE.getController();
        controller.run();
    }
}
