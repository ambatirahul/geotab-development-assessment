# Update Report

## Bug Fixes:

Missing Features Added: 
- Replacing every "Chuck Norris" with random names and pronoun when it's female.
- Print the certain number of jokes based on user input.
- Added Missing user prompt, etc;

Bugs Fixed:
- Null-Pointer Exceptions from the 2nd iteration run.
- Names are not replaced if more that one "Chuck Norris" were in the original joke

## Usability & UX

- Added a validator to check user's input, same question will prompt again if it's not a valid input.
- Messages printed to user are more readable.
- Changed the order of questions prompt to user, to make it more clear.


## Reliability & Quality

- Create constant class for messages and urls that will not be changed.
- Created interfaces for abstraction and easier unit testing.
- Separated business logic and utilities which calls api and print messages.
- JavaDocs added

## Future Maintenance & Extension

- Create layers for Models, Service and Utilites.
- Changed class/method modifiers to final or private as needed.
- Unit Tests

