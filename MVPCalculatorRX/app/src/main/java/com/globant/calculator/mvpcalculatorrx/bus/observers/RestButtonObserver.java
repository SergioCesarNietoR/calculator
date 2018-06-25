package com.globant.calculator.mvpcalculatorrx.bus.observers;

import android.app.backup.RestoreObserver;

public abstract class RestButtonObserver extends BusObserver<RestButtonObserver.RestButton> {
    public RestButtonObserver(){
        super(RestButton.class);
    }
    public static class RestButton{}
}
