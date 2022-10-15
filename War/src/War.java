/*Kevin Paul, 4B, 9/24/19*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class War {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner read = new Scanner(new File("war.dat"));
        RingBuffer<Integer> prize = new RingBuffer<>(52);

        while (read.hasNext()) {
            //d1 is a queue of integers (1 - 14), based on the scoring system in convert(); same with d2
            RingBuffer<Integer> d1 = convert(read.nextLine());
            RingBuffer<Integer> d2 = convert(read.nextLine());

            boolean isTieGame = true;
            for (int hands = 0; hands < 100000 && isTieGame == true; hands++) {
                int card1 = d1.dequeue(), card2 = d2.dequeue();

                if (card1 > card2) {
                    d1.enqueue(card1);
                    d1.enqueue(card2);
                } else if (card1 < card2) {
                    d2.enqueue(card1);
                    d2.enqueue(card2);
                } else { //if there's a tie -> war breaks out
                    prize.enqueue(card1);
                    prize.enqueue(card2);

                    int newCard1, newCard2;
                    do {
                        prize.enqueue(d1.dequeue()); //cards placed face down
                        prize.enqueue(d2.dequeue());

                        newCard1 = d1.dequeue();
                        newCard2 = d2.dequeue();
                        prize.enqueue(newCard1);
                        prize.enqueue(newCard2);

                        if (newCard1 > newCard2) {
                            for (int i = 0; i < prize.size(); i++) {
                                int card = prize.dequeue();
                                d1.enqueue(card);
                            }
                        } else if (newCard1 < newCard2) {
                            for (int i = 0; i < prize.size(); i++) {
                                int card = prize.dequeue();
                                d2.enqueue(card);
                            }
                        }
                    } while(newCard1 == newCard2);
                }

                if (d2.isEmpty()) {
                    System.out.println("Player 1 wins!");
                    isTieGame = false;
                } else if (d1.isEmpty()) {
                    System.out.println("Player 2 wins!");
                    isTieGame = false;
                }
            }

            if (isTieGame)
                System.out.println("Tie game stopped at 100000 plays.");
        }
    }

    static RingBuffer<Integer> convert(String line) {
        String[] temp = line.split(" ");
        RingBuffer<Integer> res = new RingBuffer<>(26);

        char[] scoring = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};

        for (int i = 0; i < 26; i++) {
            char numC = temp[i].charAt(0);

            for (int k = 0; k < 13; k++) {
                if (numC == scoring[k])
                    res.enqueue(k + 1);
            }
        }

        return res;
    }
}
