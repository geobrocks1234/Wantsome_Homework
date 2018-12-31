package week7.StockMarket;

import java.util.Date;

public class StockUpdateExtended extends StockUpdate {
    private String trader;

    public StockUpdateExtended(String stockCode, double price, Date date, String trader) {
        super(stockCode, price, date);
        this.trader = trader;
    }

    public StockUpdateExtended() {
    }

    @Override
    public String toString() {
        return "StockUpdateExtended{" + super.toString() +
                ", trader='" + trader + '\'' +
                '}';
    }
}