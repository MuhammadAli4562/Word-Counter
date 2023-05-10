// Bonus Line 52: Ignore the case of word, 81: Shows total count

// For taking input, scanner and Arrays funtion
import java.util.*;
// For using beffered reader for reading file
import java.io.*;
// Main Class
public class wordCounter{
    // Main Function
    public static void main(String[] args)
    {
        // System.in is a standard input stream
        Scanner input = new Scanner(System.in);
        // Print statement
        System.out.print("Enter File Address: ");
        // Taking input of fileName
        String fileAddress = input.next();
        // Input stream is closed
        input.close();
        // Creating a variable and storing file address
        File file = new File(fileAddress);
        // Check whether the file exist or not    
        if(file.exists()) {
            // wordCounter method is called with fileAddress as an argument
            wordCounterMethod(fileAddress);  
        } else {
            System.out.println("No file exist with this Address!");
            System.out.println("Local Disk:\\Folders directory\\File Name.format");
            System.out.println("Example: D:\\Java\\wordChecker.txt");
            return;    
        }
    }
    // Counter Method
    static void wordCounterMethod(String file)
    {
        // Handling exception
        try {
            // Variables
            String line;
            String[] words = null;
            String[] allWords = {};
            int count = 0;
            // Bonus, total counts
            int totalCount = 0;
            // For reading file
            BufferedReader readFile = new BufferedReader(new FileReader(file));
            // Looping till end of file
            while ((line = readFile.readLine()) != null) {
                //Split the word using space
                words = line.split(" ");
                // Reading line word by word
                for (String word : words) {
                    // Adding all words to Array
                    allWords = Arrays.copyOf(allWords, allWords.length + 1);
                    // Bonus
                    allWords[allWords.length - 1] = word.toLowerCase();
                }
            }
            // Sorting the Array in ascending order
            Arrays.sort(allWords);
            // A new Array
            String[] newWords = {};
            boolean present = false;
            // Initializing newArray without duplicates from older array(i.e., allWords)
            for (int i = 0; i < allWords.length; i++) {
                present = false;
                for (int j = 0; j < newWords.length; j++)
                    if (newWords[j].equals(allWords[i]))
                        present = true;
                if (present == false) {
                    newWords = Arrays.copyOf(newWords, newWords.length + 1);
                    newWords[newWords.length - 1] = allWords[i];
                }
            }
            // Displaying the output by comparing both arrays
            for (int i = 0; i < newWords.length; i++) {
                count = 0;
                for (int j = 0; j < allWords.length; j++)
                    if (allWords[j].equals(newWords[i]))
                        count++;
                System.out.println(newWords[i] + ": " + count);
                // Bonus Total Count
                totalCount += count;
            }
            System.out.println("Total: " + totalCount);
            // Closing readFile
            readFile.close();
        } catch (Exception fileError) {
            System.out.println("An error occurred.");
            fileError.printStackTrace();
        }
    }
}