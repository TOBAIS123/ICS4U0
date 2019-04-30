public class DeckofCards {

    private Card myDeck[];

    private int myCardNum = 0;


    public DeckofCards() {
        String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
        myDeck = new Card[52];

        for (int n = 0; n < 52; n++) {
            myDeck[n] = new Card(faces[n % 13], suits[n / 13]);
        }
    }

    public Card deal() {
        if (myCardNum < 52)
            return myDeck[myCardNum++];
        else
            return null;
    }


    public void shuffle() {
        for (int i = myDeck.length-1; i > 0; i--) {
            int randCard = (int) (Math.random() * (i + 1));
            //swap
            Card temp = myDeck[i]; 
            myDeck[i] = myDeck[randCard];
            myDeck[randCard] = temp;
        }
        myCardNum = 0;
    }
}