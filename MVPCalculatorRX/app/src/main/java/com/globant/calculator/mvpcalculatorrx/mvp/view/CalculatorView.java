package com.globant.calculator.mvpcalculatorrx.mvp.view;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import com.globant.calculator.mvpcalculatorrx.R;
import com.globant.calculator.mvpcalculatorrx.bus.RxBus;
import com.globant.calculator.mvpcalculatorrx.bus.observers.DivisionButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.EqualsButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.MultiplicationObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.RestButtonObserver;
import com.globant.calculator.mvpcalculatorrx.bus.observers.SumButtonObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalculatorView extends ActivityView {

    @BindView(R.id.result_et) public TextView resultLabel;
    @BindView(R.id.val_one_et) public EditText valOneEt;
    @BindView(R.id.val_two_et) public EditText valTwoEt;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }

    @OnClick(R.id.plus_button)
    public void sumButtonPressed() {
        RxBus.post(new SumButtonObserver.SumButton());
    }

    @OnClick(R.id.rest_button)
    public void restButtonPressed() {
        RxBus.post(new RestButtonObserver.RestButton());
    }

    @OnClick(R.id.multiply_button)
    public void multiplicationButtonPressed() {
        RxBus.post(new MultiplicationObserver.MutiplicationButton());
    }
    @OnClick(R.id.division_button)
    public void divisionButtonPressed() {
        RxBus.post(new DivisionButtonObserver.DivisionButton());
    }

    @OnClick(R.id.equals_button)
    public void equalsButtonPressed() {
        RxBus.post(new EqualsButtonObserver.EqualsButton());
    }

}
