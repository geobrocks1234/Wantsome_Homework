package week7.StockMarket;

import java.util.Date;
import java.util.Objects;

public class StockUpdate implements Comparable<StockUpdate> {
    private String stockCode;
    private double price;
    private Date date;

    public StockUpdate(String stockCode, double price, Date date) {
        this.stockCode = stockCode;
        this.price = price;
        this.date = date;
    }

    public StockUpdate() {
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "StockUpdate{" +
                "stockCode='" + stockCode + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockUpdate that = (StockUpdate) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(stockCode, that.stockCode) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockCode, price, date);
    }

    @Override
    public int compareTo(StockUpdate o) {
        return this.date.compareTo(o.date);
    }
}