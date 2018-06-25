package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class EqualsButtonObserver extends  BusObserver<EqualsButtonObserver.EqualsButton> {

    public EqualsButtonObserver(){
        super(EqualsButton.class);
    }

    public static class EqualsButton{

    }
}
