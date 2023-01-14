public class Tests {
    public void test1() {
        Hand hand = new Hand(new Card[]{new Card(3, "D"), new Card(5, "D"), new Card(5, "D"),
                new Card(5, "D"), new Card(5, "S")});

        Hand hand2 = new Hand(new Card[]{new Card(3, "D"), new Card(4, "S"), new Card(5, "D"),
                new Card(6, "S"), new Card(7, "S")});

        System.out.println(hand.bestHand());
        System.out.println(hand.rank.toString());
    }

    public void test2() {
        Solver s = new Solver(null, null, null, null);
        s.exec();
    }
}
