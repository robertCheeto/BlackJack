package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();

        welcomeMessage();
        String player1 = player1Name(keyboard);
        String player2 = player2Name(keyboard);

        System.out.printf("\nWelcome %s & %s to the table.\n\n", player1, player2);

        int score1 = player1Hand(deck);
        int score2 = player2Hand(deck);

        calculate(score1, score2, player1, player2);

    }

    public static int player1Hand(Deck deck) {
        Hand hand1 = new Hand();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            card.flip();
            hand1.deal(card);

            System.out.println(card.getValue() + " " + card.getSuit());
        }

        int handValue = hand1.getValue();

        System.out.printf("\nPlayer One's hand is worth %d points.\n\n", handValue);

        return handValue;
    }

    public static int player2Hand(Deck deck) {
        Hand hand2 = new Hand();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            card.flip();
            hand2.deal(card);

            System.out.println(card.getValue() + " " + card.getSuit());
        }

        int handValue = hand2.getValue();

        System.out.printf("\nPlayer Two's hand is worth %d points.\n\n", handValue);

        return handValue;
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Rivers!");
        System.out.println("Tonight, we are playing Blackjack, or as the kids say, Twenty One!\n");
    }

    public static String player1Name(Scanner keyboard) {
        System.out.print("Player One, please enter your name: ");
        String player1 = keyboard.nextLine();

        return player1;
    }

    public static String player2Name(Scanner keyboard) {
        System.out.print("Player Two, please enter your name: ");
        String player2 = keyboard.nextLine();

        return player2;
    }

    public static void calculate(int score1, int score2, String player1, String player2) {

        if ((score1 <= 21) && (score2 <= 21)) {
            if (score1 > score2) {
                System.out.printf("%s's score of %d is higher than %s's score of %d.\n%s Wins!", player1, score1, player2,score2, player1);
            }
            else if (score1 == score2) {
                System.out.printf("%s's score of %d is the same as %s's score of %d.\nIt's a Draw!", player1, score1, player2,score2, player1);
            }
            else {
                System.out.printf("%s's score of %d is higher than %s's score of %d.\n%s Wins!", player2, score2, player1,score1, player2);
            }
        }
        else if ((score1 > 21) && (score2 <= 21)) {
            System.out.printf("%s's score of %d over 21. \n%s Wins!", player1, score1, player2);
        }
        else {
            System.out.printf("%s's score of %d over 21. \n%s Wins!", player2, score2, player1);
        }
    }


}
