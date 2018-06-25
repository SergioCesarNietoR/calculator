package com.globant.calculator.mvpcalculatorrx.mvp.presenter;

import android.app.Activity;

import com.globant.calculator.mvpcalculatorrx.bus.RxBus;
import com.globant.calculator.mvpcalculatorrx.bus.observers.DivisionButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.EqualsButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.MultiplicationObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.RestButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.SumButtonObserver;
import com.globant.calculator.mvpcalculatorrx.mvp.model.CalculatorModel;
import com.globant.calculator.mvpcalculatorrx.mvp.view.CalculatorView;

public class CalculatorPresenter {

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void setOperationType(int operationType) {
        model.operation = operationType;
    }

    public void setValuesForOperation(double valOne, double valTwo) {
        model.valOne = valOne;
        model.valTwo = valTwo;
    }

    public void onEqualsButtonPressed() {
        model.doOperation();
        view.setResult(String.valueOf(model.getResult()));
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.subscribe(activity, new SumButtonObserver() {
            @Override
            public void onEvent(SumButton value) {
                setOperationType(0);
            }
        });

        RxBus.subscribe(activity, new RestButtonObserver() {
            @Override
            public void onEvent(RestButton value) {
                setOperationType(1);
            }
        });

        RxBus.subscribe(activity, new MultiplicationObserver() {
            @Override
            public void onEvent(MutiplicationButton value) {
                setOperationType(2);
            }
        });

        RxBus.subscribe(activity, new DivisionButtonObserver() {
            @Override
            public void onEvent(DivisionButton value) {
                setOperationType(3);
            }
        });
        RxBus.subscribe(activity, new EqualsButtonObserver() {
            @Override
            public void onEvent(EqualsButton value) {
                setValuesForOperation(
                        Double.valueOf(view.valOneEt.getText().toString()),
                        Double.valueOf(view.valTwoEt.getText().toString()));

                onEqualsButtonPressed();
            }
        });
    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
