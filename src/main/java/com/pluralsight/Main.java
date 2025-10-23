package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        Deck deck = new Deck();

        welcomeMessage();

        System.out.print("Player One, please enter your name: ");
        String player1 = keyboard.nextLine();
        System.out.print("Player Two, please enter your name: ");
        String player2 = keyboard.nextLine();

        System.out.printf("\nWelcome %s & %s to the table.\n", player1, player2);
        player1Hand(deck);
        player2Hand(deck);

    }

    public static void player1Hand(Deck deck) {
        Hand hand1 = new Hand();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            card.flip();
            hand1.deal(card);

            System.out.println("The card is faced up: " + card.isFaceUp());
            System.out.print(card.getPointValue());
            System.out.println(" " + card.getSuit());
        }

        int handValue = hand1.getValue();

        System.out.printf("\nPlayer One's hand is worth %d points.\n\n", handValue);

    }

    public static void player2Hand(Deck deck) {
        Hand hand2 = new Hand();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            card.flip();
            hand2.deal(card);

            System.out.println("The card is faced up: " + card.isFaceUp());
            System.out.print(card.getPointValue());
            System.out.println(" " + card.getSuit());
        }

        int handValue = hand2.getValue();

        System.out.printf("\nPlayer Two's hand is worth %d points.\n\n", handValue);

    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Rivers!");
    }


}
