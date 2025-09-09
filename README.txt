Summary of AI Use: 


I used ChatGPT as a support tool to help implement my code.


ChatGPT helped me with:
- Structuring my Java code (class and method organization)
- Troubleshooting Git and GitHub errors (e.g., cleaning embedded `.git` directories, fixing rebase conflicts)
- Understanding and applying Java concepts like file reading, string processing, and data output


Prompt Example:
"How do I read lines from a file in Java and split by comma?"


AI Response Excerpt:
"Use `BufferedReader` along with `FileReader` to read the file, then call `.split(',')` on each line to parse CSV values."


Explanation of Use:
I used the AI’s response to better understand how to structure file input and output in Java, then wrote my own implementation. For Git troubleshooting, I used ChatGPT to understand how to remove embedded `.git` folders and fix push conflicts, but executed the cleanup myself.


External Source Usage: 


**External Source 1**  
Link: https://www.baeldung.com/java-buffered-reader  
Usage: Helped me understand how to use `BufferedReader` to read lines from a text file.


**External Source 2**  
Link: https://stackoverflow.com/questions/26239816/how-to-split-a-string-by-comma-in-java  
Usage: Helped confirm how `.split(",")` works in Java and why escaping special characters isn't necessary for basic CSV parsing.


**External Source 3**
Link: https://www.baeldung.com/java-string-split  
Usage: Helped confirm that `String.split()` trims whitespace and handles simple delimiter cases.








**External Source 4**
Link: https://stackoverflow.com/questions/1757065/java-splitting-a-comma-separated-string-but-ignoring-commas-in-quotes  
Usage: Confirmed limitations of basic split methods and when a more robust CSV parser would be needed.


**External Source 5**
Link: https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files  
Usage: Used to help prevent `.DS_Store` files from being tracked or pushed to the GitHub repository.