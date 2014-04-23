// A number guessing game that uses baseball lingo
// Strike if the user's number matches the key exactly
// Ball if the user's number matches the key relatively
import java.util.*;

public class Homework2 {
    public static void main(String[] args) {
        GameKey newKey = new GameKey();
        Strikes newStrikes = new Strikes();
        Balls newBalls = new Balls();
        
        int maxSize = 3;
        boolean quit = false;
        boolean exceptionFound = false;
        
        while (quit == false) {
            
            int guessCount = 0;
            
            // Makes the key into an array
            ArrayList<Integer> numKey = new ArrayList<>();
            for (int i = 0; i < maxSize; i++) {
                while(true) {
                    Integer next = newKey.getRandom();
                    if (!numKey.contains(next)) {
                        numKey.add(next);
                        break;
                    }
                }
            }

            // Initial reset strike and ball count
            // If user wants to play again
            newStrikes.resetStrikes();
            newBalls.resetBalls();
            
            // Start of baseball
            while (newStrikes.getStrikes() != maxSize) {
                int userNum = -1;
                String userNumLength = "";
                boolean loop = true;
                
                // Reset strike and ball count
                // Each time the user fails to get 3 strikes
                newStrikes.resetStrikes();
                newBalls.resetBalls();

                do {
                    System.out.println("Number of Guesses: " + guessCount);
                    System.out.println("Debugging only: " + numKey.get(0) + "" + numKey.get(1) + "" + numKey.get(2));
                    System.out.print("Guess the three digit number (each number is unique from 0-9): ");
                    Scanner scanNumber = new Scanner(System.in);
                    String user = scanNumber.nextLine();
                
                    // Check if user used a letter or not
                    try {
                        userNumLength = user;
                        userNum = Integer.parseInt(user);
                        loop = false;
                    } catch(NumberFormatException e) {
                        System.out.println("Invalid Input");
                    }
                } while (loop);

                // Separates the user variables into digits
                // Puts user variable into an array
                List<Integer> checkUserNum = new ArrayList<>();
                while(userNum > 0) {
                    checkUserNum.add(userNum % 10);
                    userNum /= 10;
                }
                
                // This makes sure that if the number inputed began with 0
                // Then this will input a 0 before the array flips
                if (userNumLength.startsWith("0") == true) {
                    checkUserNum.add(0);
                }
                
                // This exception checks for duplicate digits inside the user's number
                try {
                    boolean duplicate = false;
                    for (int j = 0; j < checkUserNum.size(); j++) {
                        for (int k = j+1; k < checkUserNum.size(); k++) {
                            if (k != j && checkUserNum.get(k) == checkUserNum.get(j)) {
                                duplicate = true;
                            }
                        }
                    }
                    if (duplicate == true) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Found a duplicate. Please make each digit unique.");
                    exceptionFound = true;
                }
                
                // This exception checks if the length of the user's number is less than max size
                try {
                    if (checkUserNum.size() != maxSize || userNumLength.length() != maxSize) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.err.println("You did not put in 3 digits. Please use 3 unique numbers.");
                    exceptionFound = true;
                }
                
                // Array was inputed in reverse
                // This takes care of the array
                Collections.reverse(checkUserNum);

                // Array to hold boolean values 
                // To see if a spot inside both arrays has a strike or not
                ArrayList<Boolean> checkSpot = new ArrayList<>();
                checkSpot.clear();
                checkSpot.add(false);
                checkSpot.add(false);
                checkSpot.add(false);

                // Check each spot to see if the user's number is the same as the key
                if (exceptionFound == false) {
                    guessCount++;
                    for (int i = 0; i < maxSize; i++) {
                        if (checkUserNum.get(i).equals(numKey.get(i))) {
                            newStrikes.increaseStrikes();
                            checkSpot.remove(i);
                            checkSpot.add(i,true);
                        } 
                        if (checkUserNum.get(i).equals(numKey.get(0)) && checkSpot.get(i) == false) {
                            newBalls.increaseBalls();
                        } 
                        if (checkUserNum.get(i).equals(numKey.get(1)) && checkSpot.get(i) == false) {
                            newBalls.increaseBalls();
                        } 
                        if (checkUserNum.get(i).equals(numKey.get(2)) && checkSpot.get(i) == false) {
                            newBalls.increaseBalls();
                        }             
                    }
                } else {
                    // This will not give the user any hints if he or she was right
                    // Since the user was not playing the game right 
                    // (Cheating is not allowed)
                    newStrikes.resetStrikes();
                    newBalls.resetBalls();
                    exceptionFound = false;
                }

                System.out.println("# of strikes: " + newStrikes.getStrikes());
                System.out.println("# of balls: " + newBalls.getBalls());
            }
            
            System.out.println("You found the number with " + guessCount + " guesses!");
            System.out.print("Do you want to play again? (y/n): ");
            Scanner scanChoice = new Scanner(System.in);
            String choice = scanChoice.nextLine();
            
            if ("n".equals(choice) || "N".equals(choice)) {
                quit = true;
            } else {
                quit = false;
            }
        }
    }
}