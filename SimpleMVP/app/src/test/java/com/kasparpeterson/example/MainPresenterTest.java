package com.kasparpeterson.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by kaspar on 02/12/2016.
 */

public class MainPresenterTest {

    MainMVP.ViewOperations view;
    MainMVP.ModelOperations model;
    MainPresenter presenter;

    @Before
    public void setup() {
        view = mock(MainMVP.ViewOperations.class);
        model = mock(MainMVP.ModelOperations.class);
        presenter = new MainPresenter(view, model);
    }

    @Test
    public void onContinue_bothValuesNull() {
        presenter.onContinue(null, null);
        verify(view, times(1)).showFirstNameError();
        verify(view, times(1)).showLastNameError();
    }

    @Test
    public void onContinue_firstNameNull() {
        presenter.onContinue(null, "Valid Last Name");
        verify(view, times(1)).showFirstNameError();
        verify(view, never()).showLastNameError();
    }

    @Test
    public void onContinue_firstNameBlank() {
        presenter.onContinue("", "Valid Last Name");
        verify(view, times(1)).showFirstNameError();
        verify(view, never()).showLastNameError();
    }

    @Test
    public void onContinue_firstNameEmpty() {
        presenter.onContinue(" ", "Valid Last Name");
        verify(view, times(1)).showFirstNameError();
        verify(view, never()).showLastNameError();
    }

    @Test
    public void onContinue_firstNameTooShort() {
        presenter.onContinue("A", "Valid Last Name");
        verify(view, times(1)).showFirstNameError();
        verify(view, never()).showLastNameError();
    }

    @Test
    public void onContinue_lastNameNull() {
        presenter.onContinue("Valid First Name", null);
        verify(view, never()).showFirstNameError();
        verify(view, times(1)).showLastNameError();
    }

    @Test
    public void onContinue_lastNameBlank() {
        presenter.onContinue("Valid First Name", "");
        verify(view, never()).showFirstNameError();
        verify(view, times(1)).showLastNameError();
    }

    @Test
    public void onContinue_lastNameEmpty() {
        presenter.onContinue("Valid First Name", " ");
        verify(view, never()).showFirstNameError();
        verify(view, times(1)).showLastNameError();
    }

    @Test
    public void onContinue_lastNameTooShort() {
        presenter.onContinue("Valid First Name", "A");
        verify(view, never()).showFirstNameError();
        verify(view, times(1)).showLastNameError();
    }

    @Test
    public void onContinue_valid() {
        String first = "Valid First Name";
        String last = "Valid Last Name";
        presenter.onContinue(first, last);
        verify(view, never()).showFirstNameError();
        verify(view, never()).showLastNameError();
        verify(model, times(1)).saveDetails(first, last);
    }

    @Test
    public void onSaveDetailsSuccessful() {

    }

    @Test
    public void onSaveDetailsFailed() {

    }

}
