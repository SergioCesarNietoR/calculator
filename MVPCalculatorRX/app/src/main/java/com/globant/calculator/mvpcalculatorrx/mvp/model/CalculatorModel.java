package com.globant.calculator.mvpcalculatorrx.mvp.model;

public class CalculatorModel {

    public int operation = 0;
    public double valOne = 0;
    public double valTwo = 0;
    private double result = 0;

    public void doOperation() {
        switch (operation) {
            case 0:
                result = valOne + valTwo;
                break;
            case 1:
                result = valOne - valTwo;
                break;
            case 2:
                result = valOne * valTwo;
                break;
            case 3:
                result = valOne / valTwo;
                break;
        }
    }

    public double getResult() {
        return result;
    }

}
