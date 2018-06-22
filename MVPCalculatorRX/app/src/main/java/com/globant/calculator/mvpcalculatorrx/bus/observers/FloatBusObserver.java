package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class FloatBusObserver extends BusObserver<Float> {

    public FloatBusObserver() {
        super(Float.class);
    }
}
