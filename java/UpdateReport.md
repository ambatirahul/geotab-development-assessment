# Update Report

## Overview:
- Reorganized and refactored project structure. Created layers for different classes based on 
their logics, created interfaces for service layer.

## Bug Fixes:

Missing Features Added: 
- Replacing every "Chuck Norris" with random names and pronoun when gender is female.
- Print the certain number of jokes based on user input.
- Added Missing user prompt, etc;

Bugs Fixed:
- Null-Pointer Exceptions from the 2nd iteration run due to empty Hashmap or HttpClient.
- Names are not replaced if more that one "Chuck Norris" were in the original joke.
- Broken user prompt

## Usability & UX

- Added a validator to check user's input, loop the question if it's not a valid input.
- Messages printed to user are more readable.
- Changed the order of questions prompt to user, to make it more clear.


## Reliability & Quality

- Create constant class for messages and urls that will not be changed.
- Created interfaces for abstraction and easier unit testing.
- Separated class that contains business logic with utilities and helper classes.
- Changed variable names to make them more meaningful and fits java code conventions;
- JavaDocs added

## Future Maintenance & Extension

- Create layers for Models, Service and Utilites.
- Changed class/method access modifiers to final or private for safety.
- Added Unit Tests

