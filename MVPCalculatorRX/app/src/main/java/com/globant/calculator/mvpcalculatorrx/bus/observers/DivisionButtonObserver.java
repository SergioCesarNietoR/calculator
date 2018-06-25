package com.globant.calculator.mvpcalculatorrx.bus.observers;

public abstract class DivisionButtonObserver extends BusObserver<DivisionButtonObserver.DivisionButton>{

    public DivisionButtonObserver(){
        super(DivisionButton.class);
    }

    public static class DivisionButton{

    }
}
