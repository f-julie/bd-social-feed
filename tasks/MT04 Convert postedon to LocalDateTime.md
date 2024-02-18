## Working with GSON and LocalDateTime Objects

Right now the `postedon` field in the `Post` class is of type String. Eventually, 
we'd like to perform logic with this field and so it needs to be converted to a 
`LocalDateTime` object. You will notice that by default, GSON has issues converting
a LocalDateTime to JSON. Use a typeAdapter and the LocalDateTimeAdapter class to
help GSON with the conversion. 

### Completion

Once this is working `MT04_LocalDateTime` tests should all pass.

`./gradlew -q clean :test --tests 'com.bloomtech.socialfeed.MT04*'`