## Implementing the Repositories

We are getting closer to using real databases in this course. In this project we take
one step closer, reading and writing to .json files. By maintaining the JSON format
in these files, we can use a transpiler such as GSON to convert between text files
and strings to useable Java objects.

For any data layer, we want to restrict access to it by any means other than through
a repository. We don't want other classes, or worse other coders, to try to read and
write to our database, instead we write a single repository and require database
requests to pass through it instead.

Our repositories will need to use file i/o and the GSON library to parse our objects
to and from JSON, and then store that info in the PostData.json and UserData.json
files inside the resource directory.

### Implement the User Repository `save` Method

Some of the logic has been implemented for you. We can see that we first attempt to
getAllUsers so that we have a list of all existing users. This is for two reasons:
1. So that we can check if the new User we are trying to add already exists
 (this has been implemented for you).
2. Because when we write to the UserData.json file, we are going to replace the entire
file with the updated list of users as opposed to trying to append a new user into
the list. (You can see already what kinds of features a real database might have 
figured out for us already).

What's left is for you to convert this list of users into JSON and write it to the
UserData.json file.

*HINT: You should use `Gson`s `setPrettyPrint()` method to pretty-print the JSON
in the file*.

When you have completed this task, run the App class which calls on the SeedData to 
run. If you check the UserData.json file after this you will see you have one user's
data. (Why is it only one?)

### Implement the getAllUsers Method

Now that we have some data in the UserData.json file, we can try to get that data back.
Right now this method returns an empty array. Implement the logic to read the UserData
file, convert the resulting String into a list of User objects, and return that list.

When you are done, if you run the App main method again, the UserData.json file will
now have all three User's data.

### Implement the PostRepository methods

This repository should follow similar logic to the UserRepository.

### Completion

When you are done all of the tests in the `MT03_JsonReadWrite` class should pass.

`./gradlew -q clean :test --tests 'com.bloomtech.socialfeed.MT03*'`
