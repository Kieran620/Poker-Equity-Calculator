public class Tests {
    public void test1() {
        Hand hand = new Hand(new Card[]{new Card(10, "s"), new Card(12, "s"), new Card(14, "s"),
                new Card(14, "c"), new Card(14, "d")});

        Hand hand2 = new Hand(new Card[]{new Card(10, "c"), new Card(10, "d"), new Card(10, "h"),
                new Card(14, "h"), new Card(14, "c")});

        System.out.println(hand.bestHand() + " : " + hand2.bestHand());
        System.out.println(hand.compareTo(hand2));

        System.out.println(hand.rank.toString());
    }

    public void test2() {
        Solver s = new Solver(null, null, null, null);
        s.exec();
    }
}
