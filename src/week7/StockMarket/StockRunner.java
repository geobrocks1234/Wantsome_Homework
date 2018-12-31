package week7.StockMarket;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockRunner {

    public static Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public static void main(String[] args) throws ParseException {
        StockMarket<StockUpdate> market = new StockMarket();
        market.add(new StockUpdate("A", 10, parseDate("2018-01-01")));
        market.add(new StockUpdate("A", 20, parseDate("2018-02-01")));
        market.add(new StockUpdate("A", 30, parseDate("2018-03-01")));
        market.add(new StockUpdate("A", 5, parseDate("2018-04-30")));
        market.add(new StockUpdate("B", 1, parseDate("2018-02-01")));
        market.add(new StockUpdate("B", 2, parseDate("2018-03-03")));
        market.add(new StockUpdate("B", 3, parseDate("2018-04-04")));

        System.out.println("Current Stock Market : " + market);
        market.add(new StockUpdate("C", 1, parseDate("2018-01-01")));
        System.out.println("Current Stock Market : " + market);
        System.out.println(market.queryUpdates(parseDate("2018-01-15"), parseDate("2018-04-30")));
        try {
            System.out.println(market.queryUpdates(parseDate("2018-01-15"), parseDate("2018-04-30"), "D"));
        } catch (UpdatesNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Price for A: " + market.getPrice(parseDate("2018-03-03"), "A"));
        System.out.println("Price for all codes: " + market.getPrices(parseDate("2018-03-01")));

        StockMarket<StockUpdateExtended> marketExtended = new StockMarket();
        marketExtended.add(new StockUpdateExtended("A", 10, parseDate("2018-01-01"), "Lucian"));
        marketExtended.add(new StockUpdateExtended("B", 1, parseDate("2018-02-01"), "Cristi"));
        System.out.println(marketExtended);
    }
}
