package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class MultiplicationObserver extends BusObserver<MultiplicationObserver.MutiplicationButton> {

    public MultiplicationObserver() {
        super(MutiplicationButton.class);
    }

    public static class MutiplicationButton {

    }
}
