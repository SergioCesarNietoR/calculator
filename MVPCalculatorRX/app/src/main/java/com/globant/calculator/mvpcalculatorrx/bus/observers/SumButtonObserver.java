package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class SumButtonObserver extends BusObserver<SumButtonObserver.SumButton> {

    public SumButtonObserver(){
        super(SumButton.class);
    }

    public static class SumButton{

    }
}
