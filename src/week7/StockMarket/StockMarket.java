package week7.StockMarket;

import java.util.*;

public class StockMarket<T extends StockUpdate> {
    private Map<String, Set<T>> allUpdates;

    public StockMarket() {
        allUpdates = new HashMap<>();
    }

    public void add(T update) {
        Set<T> codeUpdates = allUpdates.get(update.getStockCode());
        if (codeUpdates == null) {
            codeUpdates = new TreeSet<>();
            codeUpdates.add(update);
            allUpdates.put(update.getStockCode(), codeUpdates);
        } else {
            codeUpdates.add(update);
        }
    }

    public List<T> queryUpdates(Date from, Date to) {
        List<T> filteredUpdates = new ArrayList<>();
        for (Map.Entry<String, Set<T>> entry : allUpdates.entrySet()) {
            Set<T> updates = entry.getValue();
            for (T update : updates) {
                if (update.getDate().after(from) && update.getDate().before(to))
                    filteredUpdates.add(update);
            }
        }
        return filteredUpdates;
    }

    public List<T> queryUpdates(Date from, Date to, String stockCode) throws UpdatesNotFoundException {
        Set<T> currentUpdates = allUpdates.get(stockCode);
        if (currentUpdates == null) {
            throw new UpdatesNotFoundException("No entries found for: " + stockCode);
        }
        return findUpdatesByDateFromSet(from, to, currentUpdates);
    }

    private List<T> findUpdatesByDateFromSet(Date from, Date to, Set<T> currentUpdates) {
        List<T> filteredUpdates = new ArrayList<>();
        for (T update : currentUpdates) {
            if (update.getDate().after(from) && update.getDate().before(to))
                filteredUpdates.add(update);
        }
        return filteredUpdates;
    }

    public double getPrice(Date date, String stockCode) {
        TreeSet<StockUpdate> codeUpdates = (TreeSet<StockUpdate>) allUpdates.get(stockCode);
        if (codeUpdates == null) {
            return 0;
        }
        StockUpdate temp = new StockUpdate();
        temp.setDate(date);
        StockUpdate found = codeUpdates.ceiling(temp);
        if (found == null) {
            return 0;
        }
        return found.getPrice();
    }

    public Map<String, Double> getPrices(Date date) {
        Map<String, Double> prices = new HashMap<>();
        for (Map.Entry<String, Set<T>> entry : allUpdates.entrySet()) {
            prices.put(entry.getKey(), getPrice(date, entry.getKey()));
        }
        return prices;
    }

    @Override
    public String toString() {
        return "StockMarket{" +
                "allUpdates=" + allUpdates +
                '}';
    }
}