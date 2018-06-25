package com.globant.calculator.mvpcalculatorrx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.globant.calculator.mvpcalculatorrx.mvp.model.CalculatorModel;
import com.globant.calculator.mvpcalculatorrx.mvp.presenter.CalculatorPresenter;
import com.globant.calculator.mvpcalculatorrx.mvp.view.CalculatorView;

public class MainActivity extends AppCompatActivity {

    private CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorPresenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculatorPresenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        calculatorPresenter.unregister();
    }
}
