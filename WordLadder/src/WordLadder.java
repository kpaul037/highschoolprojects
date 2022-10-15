/*Kevin Paul, 4B, 10/19/19*/

import java.util.Scanner;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;

//NOTE: For queues, add to back; for stacks, add to front

public class WordLadder {
    static HashSet<String> dictionary = new HashSet(), usedWords = new HashSet();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("input.txt"));

        fillDictionary(); //adds all words from dictionary.txt to HashSet dictionary

        while (read.hasNextLine()) { //scope focuses on one pair
            String startingWord = read.next(), endingWord = read.next();
            LinkedList ladder = new LinkedList();

            usedWords.add(startingWord);
            String baseWord = startingWord;
            LinkedList baseStack = new LinkedList();

            boolean isFound = false;

            outer:
            while (true) {
                if (startingWord.equals(endingWord)) {
                    isFound = true;
                    LinkedList stack = new LinkedList();
                    stack.addToFront(startingWord);
                    stack.addToFront(endingWord);
                    ladder.addToBack(stack);
                    break;
                }

                for (int i = 0; i < baseWord.length(); i++) //finds one-letter variations of startingWord
                    for ( int k = 97; k < 123; k++) {
                        String newWord = baseWord.substring(0, i) + (char) k + baseWord.substring(i + 1);
                        if (dictionary.contains(newWord) && !usedWords.contains(newWord)) {
                            usedWords.add(newWord);
                            LinkedList stack = hardCopy(baseStack);
                            stack.addToFront(baseWord);
                            stack.addToFront(newWord);
                            ladder.addToBack(stack);

                            if (newWord.equals(endingWord)) { //checks to see if newWord is the endingWord; if so --> found and break
                                isFound = true;
                                break outer;
                            }
                        }
                    }

                //dequeue first stack in ladder queue --> new baseStack and baseWord
                if (ladder.size() > 0) {
                    baseStack = (LinkedList) ladder.removeFromFront();
                    baseWord = (String) baseStack.removeFromFront();
                } else //if no more stacks in ladder --> ladder is not possible
                    break;
            }

            if (isFound)
                print((LinkedList) ladder.get(ladder.size() - 1));
            else
                System.out.println("There is no word ladder between " + startingWord + " and " + endingWord + ".");

            usedWords = new HashSet();
        }
    }

    static void fillDictionary() throws FileNotFoundException {
        Scanner tempSc = new Scanner(new File("dictionary.txt"));

        String word;
        while (tempSc.hasNext()) {
            word = tempSc.nextLine();
            if (!(word.equals("")))
                dictionary.add(word);
        }
    }

    static void print(LinkedList stack) {
        for (int i = stack.size() - 1; i > 0; i--)
            System.out.print(stack.get(i) + ", ");
        System.out.println(stack.get(0) + ".");
    }

    static LinkedList hardCopy(LinkedList fromList) {
        LinkedList toList = new LinkedList();
        for (int i = 0; i < fromList.size(); i++)
            toList.addToBack(fromList.get(i));

        return toList;
    }
}