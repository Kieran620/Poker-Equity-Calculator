import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Solver {
    private Card a1, a2, b1, b2;
    private Card[] cards = new Card[4];
    private int[] possibleNums = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private String[] possibleSuits = new String[] {"s", "d", "c", "h"};

    public Solver(Card a1, Card a2, Card b1, Card b2) {
        this.a1 = a1;
        this.a2 = a2;
        this.b1 = b2;
        this.b2 = b2;
    }

    public void exec() {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        makeMap(map);

        for(int i = 0; i < cards.length; i++) {

        }

        System.out.print("Hand 1: ");
        String input = sc.next();

        a1 = new Card(map.get(input.substring(0, input.length()-1)), String.valueOf(input.charAt(input.length() - 1)));

        input = sc.next();

        a2 = new Card(map.get(input.substring(0, input.length()-1)), String.valueOf(input.charAt(input.length() - 1)));

        System.out.print("Hand 2: ");
        input = sc.next();

        b1 = new Card(map.get(input.substring(0, input.length()-1)), String.valueOf(input.charAt(input.length() - 1)));

        input = sc.next();

        b2 = new Card(map.get(input.substring(0, input.length()-1)), String.valueOf(input.charAt(input.length() - 1)));

//        System.out.println(a1.toString() + " " + a2.toString());
        solve(5);
    }

    private Card[] genCards(int size) {
        Card[] cards = new Card[size];
        for(int i = 0; i < cards.length; i++) {
            int r1 = (int) (Math.random() * 13);
            int r2 = (int) (Math.random() * 4);
            cards[i] = new Card(possibleNums[r1], possibleSuits[r2]);
        }
        return cards;
    }

    private Hand bestHand(HashSet<Hand> cards) {
        Hand best = null;
        for(Hand h : cards) {
            if(best == null)
                best = h;
            else if(h.compareTo(best) > 0) {
                best = h;
            }
        }
        return best;
    }


    private Card[] makeArray(Card a, Card b, Card[] middle) {
        Card[] arr = new Card[7];
        arr[0] = a;
        arr[1] = b;
        for(int i = 2; i < arr.length; i++) {
            arr[i] = middle[i-2];
        }
        return arr;
    }

    private void makeMap(HashMap<String, Integer> map) {
        for(int i = 2; i < possibleNums.length - 2; i++) {
            map.put("" + i, i);
        }
        map.put("j", 11);
        map.put("q", 12);
        map.put("k", 13);
        map.put("a", 14);
    }

    public double solve(int size) {

        double wins1 = 0, wins2 = 0, ties = 0;
        int iterations = 30000;
//        for(int i = 0; i < 100; i++) {
//            Card[] middle = genCards(size);
//            for(Card c : middle) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//            System.out.println(a1 + " " + a2);
//            System.out.println(b1 + " " + b2);
//            System.out.println(bestHand(Combination.makeCombination(makeArray(a1, a2, middle), 7, 5)));
//            System.out.println(bestHand(Combination.makeCombination(makeArray(b1, b2, middle), 7, 5)));
//            System.out.println("===============================");
//        }


        for(int i = 0; i < iterations; i++) {
            Card[] middle = genCards(size);

            Hand hand1 = bestHand(Combination.makeCombination(makeArray(a1, a2, middle), 7, 5));
            Hand hand2 = bestHand(Combination.makeCombination(makeArray(b1, b2, middle), 7, 5));

            int result = hand1.compareTo(hand2);

//            System.out.println(hand1.toString() + "-----------------" + hand2.toString());
//            System.out.println(result);

            if(result > 0)
                wins1++;
            else if(result < 0)
                wins2++;
            else
                ties++;
        }
        System.out.println("Hand1 win: " + wins1/iterations + ", Hand2 win: " + wins2/iterations + ", Tie: " + ties/iterations);
        return wins1/wins2;
    }

}
