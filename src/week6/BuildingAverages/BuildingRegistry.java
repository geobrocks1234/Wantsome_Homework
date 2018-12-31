package week6.BuildingAverages;

import java.util.*;

public class BuildingRegistry {

    public static Map<Category, Double> averagePricePerCategory(Collection<Building> buildings){

        Map<Category, Integer> countPerCategMap = new HashMap<>();
        Map<Category, Double> sumPerCategMap = new HashMap<>();

        for(Building building: buildings){
            int oldCount = countPerCategMap.getOrDefault(building.getCategory(),0);
            countPerCategMap.put(building.getCategory(), oldCount+1);

            double oldSum = sumPerCategMap.getOrDefault(building.getCategory(), 0.0);
            sumPerCategMap.put(building.getCategory(), oldSum+building.getPrice());
        }

        Map<Category, Double> result = new HashMap<>();

        for(Category category: countPerCategMap.keySet()){
            int count = countPerCategMap.get(category);
            double sum = sumPerCategMap.get(category);

            double average = sum/count;
            result.put(category, average);
        }
        return result;
    }

    public static Map<String, Double> averagePricePerNeighborhood(List<Building> buildings){
        Map<String, Integer> count = new HashMap<>();
        Map<String, Double> price = new HashMap<>();

        for(Building building: buildings){
            int oldCount = count.getOrDefault(building.getNeighbourhood(), 0);
            count.put(building.getNeighbourhood(),oldCount+1);

            double oldSum = price.getOrDefault(building.getNeighbourhood(), 0.0);
            price.put(building.getNeighbourhood(), oldSum+building.getPrice());
        }

        Map<String, Double> result = new HashMap<>();

        for(String neighborhood: count.keySet()){
            int newCount = count.get(neighborhood);
            double newPrice = price.get(neighborhood);

            double average = newPrice/newCount;
            result.put(neighborhood, average);
        }

        return result;
    }

    public static Set<Category> uniqueCategories(Collection<Building> buildings){

        Set<Category> result = new TreeSet<>();

        for(Building building: buildings){
            result.add(building.getCategory());
        }

        return result;
    }

    public static int uniqueCategoriesCount(Collection<Building> buildings){
        return uniqueCategories(buildings).size();
    }

    public static List<String> buildingNamesFromNeighborhood(Collection<Building> buildings, String neighbourhoodName){
        List<String> result = new ArrayList<>();
        for(Building building: buildings){
            if(building.getNeighbourhood().equalsIgnoreCase(neighbourhoodName)){
                result.add(building.getName());
            }
        }
        Collections.sort(result);
        return result;
    }
}

