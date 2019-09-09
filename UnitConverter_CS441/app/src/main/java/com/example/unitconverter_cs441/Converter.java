package com.example.unitconverter_cs441;

public class Converter {
    private final int cost;

    public enum Subscription {
        AMAZONPRIME,
        DISNEYPLUS,
        HBOGO,
        HULU,
        NETFLIX,
        NINTENDOONLINE,
        SPOTIFYPREMIUM;

        public static Subscription fromString(String text) {
            for (Subscription name : Subscription.values()) {
                if (text.equalsIgnoreCase(name.toString())) {
                    return name;
                }
            }
            throw new IllegalArgumentException("Please select a subscription service.");
        }
    }

    public Converter(Subscription sub) {
        int price = 1;

        switch (sub) {
            case AMAZONPRIME:
                price = 13;
                break;

            case DISNEYPLUS:
                price = 7;
                break;

            case HBOGO:
                price = 15;
                break;

            case HULU:
                price = 12;
                break;

            case NETFLIX:
                price = 9;
                break;

            case NINTENDOONLINE:
                price = 4;
                break;

            case SPOTIFYPREMIUM:
                price = 10;
                break;
        }

        cost = price;
    }

    public int convert(int budget) {
        return budget/cost;
    }

    public int remainder(int budget) {
        if(budget%cost == 0) return cost;
        else return budget%cost;
    }
}
