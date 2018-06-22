package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class CountButtonUpBusObserver extends BusObserver<CountButtonUpBusObserver.CountButtonUp> {
    public CountButtonUpBusObserver() {
        super(CountButtonUp.class);
    }

    public static class CountButtonUp {
    }
}