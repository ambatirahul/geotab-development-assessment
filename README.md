# Geotab Development Assessment

As part of your application to Geotab Inc., we ask that you complete the following challenge. 

To submit the your challenge please follow the steps below:
- Fork this Github Project to your own repo.
- Choose one of the two available languages(Java or CSharp).
- Create a Branch containing your changes and create a Pull Request.

Please submit your completed challenge via a github link to your Pull Request to your own repo.

Improve this software considering the following aspects;
1. Usability & UX
2. Future Maintenance & Extension
3. Reliability & Quality 

It's possible that there are existing bugs within this solution - make sure to fix those as well.

# Updates by Will Zhang

FOUND BUGS:
- Second iteration will fail because httpClient is re-instantiated.
Fix: Create static class Variable HttpClient in JsonFeed.java instead of creating a new object in each method.
- Missing logic to replace name
Fix: added 
- Missing getInput after asked user to specify a category.
Fix: added
- Missing case 'n' and '2'
Fix: added
- potential NullPointer Exception when no name is input
Fix: added checker for null and empty input
- url error in method getCategories
Fix: added the missing suffix.
  
-Bugs in getnames after get categories
Fix: names = null -> names.clear()
  
- Number of Jokes not working.
Fix: Added logic to make number work.
  
-missing replacing name function
Fix: Added 

-Constructer's parameter int result is never used.
Fix: deleted the constructor parameter

- getRandomJoke return the whole reponse
Fix: returns only the joke 
  
- exception when category doesn't exist
Fix: print the error message

OTHER FIXES:
In Method getRandomJokes(), replaced url+= category to url +="?category="+ category
Typo in JsonFeed.java responsebody ->responseBody getnames()->getNames()




