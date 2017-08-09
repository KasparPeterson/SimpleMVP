package ${packageName};

import android.support.annotation.Nullable;

public class ${className}Presenter extends ${className}MVP.PresenterViewOperations {

    @Override
    void onContinue(final String firstName, final String lastName) {
        onView(new ViewAction<${className}MVP.ViewOperations>() {
            @Override
            public void onAction(${className}MVP.ViewOperations view) {
                boolean isValid = true;

                if (isStringEmpty(firstName) || firstName.length() < 2) {
                    view.showFirstNameError();
                    isValid = false;
                }

                if (isStringEmpty(lastName) || lastName.length() < 2) {
                    view.showLastNameError();
                    isValid = false;
                }

                if (isValid) {
                    saveDetails(firstName, lastName);
                }
            }
        });
    }

    private void saveDetails(final String firstName, final String lastName) {
        // saving to somewhere
    }

    private static boolean isStringEmpty(@Nullable String string) {
        return string == null || string.trim().length() == 0;
    }
}
