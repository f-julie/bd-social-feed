## Social Feed App

This is an application that keeps track of `User`s and their social media `Post`s
and allows users to follow one another to view each other's posts in their personalized
"feed".

Whenever a user creates a new post, all users who have elected to follow that user
will receive an update to their feed with the new post included in it. This is in 
accordance to the Observer Pattern and we'll need to design our system to that 
standard.

### Starter Project

The starter repo for this project includes a `User` class and
a `Post` class. Each user is identified by a `username` field
of type String (rather than an id number), and each `User`
has a list of usernames called `following`.

`Post`s are added to a `SourceFeed` static instance upon
creation, and contain a `username` identifying the poster.
The `SourceFeed` class stores a `List` of these `Post`s.

#### Data Storage

Instead of a database we are using `.json` files located in
the `src/resources` directory. Now that we know how to use
file i/o, we are closer to using a real database, but you will
notice we still have to program basic functionality ourselves.

You will be tasked with implementing several repository
methods which read, parse, and write JSON to these files.
We will be using the GSON library to help us with these
tasks.

This project contains a SeedData class. Which when ran creates
some data and saves it to our data files. This functionality
will be helpful but keep it mind it will not work until you've
completed Mastery Task 3.

### Tasks

* Implement the `Observer` interface in the `OUserFeed` class.
* Implement the `Source` interface in the `SourceFeed` class.
* Provide the business logic for the `UserInfoValidator` and
`EmailValidator` classes.
* Use GSON to provide JSON parsing functionality in the 
repository classes.
* Change the `postedon` field in the `Post` class from a
String to a `LocalDateTime` object.

## Completion

A completed project will pass all tests:
`./gradlew -q clean :test`
