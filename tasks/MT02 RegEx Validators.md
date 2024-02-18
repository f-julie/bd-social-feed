## RegEx Validation

We have two Validator classes that should be used to enforce restrictions on usernames, passwords, and emails during
`User` instantiation. At the moment each of these validators simply return `true`. Using RegEx pattern matchers,
implement the following rules for each of the corresponding validation methods:

1. `username`
    - Must be at least 4 characters in length.
    - Must begin with an uppercase letter.
    - Only allow letters and numbers
2. `password`
    - Must be at least 8 characters in length.
    - Must contain at least one uppercase letter.
    - Must contain at least one lowercase letter.
    - Must contain at least one number letter.
    - May only contain letters, numbers, and the symbols `!@#$%^&*`.
3. `email`
    - Must fit the standard email format `{name}@{domain}.{identier}`.
    - The `{name}` field must contain at least one letter, digit, `_`, or `.`.
    - The `{domain}` and `{identifier}` fields must only contain letters.
    - Each field must contain at least one character.
    
*HINT: It may be helpful to break validation into multiple pattern matching steps
rather than doing it all at once.*

### Completion

Once the `UserInfoValidator` and `EmailValidator` methods have been fully implemented
the tests under the `MT02_RegexValidators` class should all pass:

`./gradlew -q clean :test --tests 'com.bloomtech.socialfeed.MT02*'`