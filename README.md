# Geotab Development Assessment - Report

## Overview:

- Created interfaces (implementations can be different at any point and or in the future)
- Refactored and reorganized the code (based on single responsibility principle) 
- Structured packages accordingly (utils, helpers, models, interfaces, services, constants)

## Bugs and fixes:

### Bugs

- Broken user prompt.
- Null pointer exception from the 2nd iteration run due to empty Hashmap or HttpClient.
- Names are not replaced if more that one "Chuck Norris" were in the original joke.

### Fixes

- Added missing user prompt.
- Replacing every "Chuck Norris" with random name and pronoun when gender is female.
- Print number of jokes based on user input.

## Usability & UX

- Made input case-insensitive.
- Added a Validator to check user input, loop the question if not a valid input.
- Reordered the questions to make it more clear and readable.

### Improvements

- Used singleton (lazy initialization) pattern for Http client.
- Created interfaces instead of concrete classes, so in future we can introduce implementations of those.
- Created a constants file, where all the string constants be placed and referred to it instead of local string values.
- Created models from Joke, Person.
- Created Utils, Helper classes in aiding and supporting the code base and functionality.
- Added unit tests.

## Future Maintenance & Extension

- Need to add more unit tests.
- Introduce Dependency Injection (testing will be easier, and development too)
- Standardize logging error, exceptions. 
- Log output and exceptions into it's own files for monitoring and debugging purpose
- Break the services into it's own service (potential microservices if services are small, complex and independent enough) at project level.

## Reliability & Quality

- Java docs added for classes, functions and tests.
- Changed variable names to make them more meaningful and fits standards and conventions.
- Created interfaces for abstraction and easier unit testing.
- Separated class that contains business logic with utilities and helper classes.
- Create constant class for messages and urls that will not be changed.
