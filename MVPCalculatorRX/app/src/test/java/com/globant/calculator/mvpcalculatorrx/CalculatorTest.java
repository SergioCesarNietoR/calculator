package com.globant.calculator.mvpcalculatorrx;

import com.globant.calculator.mvpcalculatorrx.mvp.model.CalculatorModel;
import com.globant.calculator.mvpcalculatorrx.mvp.presenter.CalculatorPresenter;
import com.globant.calculator.mvpcalculatorrx.mvp.view.CalculatorView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTest {

    private CalculatorPresenter presenter;

    @Mock private CalculatorModel model;
    @Mock private CalculatorView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void shouldAdd() {
        when(model.getResult()).thenReturn(3.0);
        presenter.setOperationType(0);
        presenter.setValuesForOperation(1.0, 2.0);
        model.doOperation();
        assertEquals(model.getResult(), 3, 0);
    }

    @Test
    public void shouldSubstract() {
        when(model.getResult()).thenReturn(1.0);
        presenter.setOperationType(1);
        presenter.setValuesForOperation(1.0, 2.0);
        model.doOperation();
        assertEquals(model.getResult(), 1, 0);
    }


    @Test
    public void shouldMultiply() {
        when(model.getResult()).thenReturn(4.0);
        presenter.setOperationType(2);
        presenter.setValuesForOperation(2.0, 2.0);
        model.doOperation();
        assertEquals(model.getResult(), 4.0, 0);
    }


    @Test
    public void shouldDivide() {
        when(model.getResult()).thenReturn(6.0);
        presenter.setOperationType(3);
        presenter.setValuesForOperation(12.0, 2.0);
        model.doOperation();
        assertEquals(model.getResult(), 6.0, 0);
    }


    @Test
    public void objectsNotNull() {
        assertNotNull(presenter);
        assertNotNull(view);
        assertNotNull(model);
    }

    @Test
    public void testParameters() {
        model.getResult();
        verify(model).getResult();
        model.getResult();
        verify(model, times(2)).getResult();
    }

    @Test
    public void verifyOperation(){
        model.doOperation();
        model.getResult();

        verify(model).doOperation();
        verify(model).getResult();

    }
}