## Implement the Observer Pattern

The Observer and Source interfaces have been provided for you already. Your task
is to implement these interfaces in the `OUserFeed` and `SourceFeed` classes.

You will also want to attach the user's feed to the SourceFeed after instantiation.

The one and only `SourceFeed` instance is initialized from with `App`. You can make global
references to this instance during your implementation. You should not create
any other `SourceFeed` instances

### Completion

The `SourceFeed` should allow Observers to attach and detach, and it should
call each observer's `update` method from its `updateAll` method.

Each `OUserFeed` observer instance should attach to the `SourceFeed` and should 
contain a list of `Post`s of only the users the user who owns the feed is following.

All tests should pass after running the following command:

`./gradlew -q clean :test --tests 'com.bloomtech.socialfeed.MT01*'`