package collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShowHand {
    private final int PLAY_NUM = 5;
    private String[] types = {"方块", "草花", "红心", "黑桃"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private List<String> cards = new LinkedList<>();
    private String[] players = new String[PLAY_NUM];
    private List<String>[] playersCards = new List[PLAY_NUM];

    public void initCards() {
        for (var i = 0; i < types.length; i++) {
            for (var j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }
        Collections.shuffle(cards);
    }

    public void initPlayer(String... names) {
        if (names.length > PLAY_NUM || names.length < 2) {
            System.out.println("玩家数量不对");
            return;
        } else {
            for (var i = 0; i < names.length; i++) {
                players[i] = names[i];
            }
        }
    }

    public void initPlayerCards() {
        for (var i = 0; i < players.length; i++) {
            if (players[i] != null && !players[i].equals("")) {
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    public void showAllCards() {
        for (var card : cards) {
            System.out.println(card);
        }
    }

    public void deliverCard(String first) {
        //int firstPos =
    }
}
