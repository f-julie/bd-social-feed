package com.bloomtech.socialfeed.validators;

import com.bloomtech.socialfeed.exceptions.EmailValidationException;

public class EmailValidator implements Validator {
    public EmailValidator() {
    }

    private boolean isValidEmail(String email) {
        /*TODO: Validate that email begins with a letter or number, contains only letters, numbers, "." and "_", and
        *that it follows the pattern of name@domain.identifier
        */

        return true;
    }

    @Override
    public void validate(Object emailData) {
        String email = (String) emailData;
        if (!isValidEmail(email)) {
            throw new EmailValidationException("Invalid Email: Email address must include '@' before domain and a domain identifier after a '.'!");
        }
    }
}
