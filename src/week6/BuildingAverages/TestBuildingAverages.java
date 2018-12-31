package week6.BuildingAverages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestBuildingAverages {
    public static void main(String[] args) {
        List<Building> buildingList = new ArrayList<> ();
        Map<Category, Double> averagePricePerCategory = BuildingRegistry.averagePricePerCategory(buildingList);
        System.out.println(averagePricePerCategory);

        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        System.out.println(BuildingRegistry.averagePricePerCategory(buildingList));

        System.out.println(BuildingRegistry.uniqueCategories(buildingList));

        System.out.println(BuildingRegistry.buildingNamesFromNeighborhood(buildingList, "Canta"));
        System.out.println(BuildingRegistry.buildingNamesFromNeighborhood(buildingList, "Tatarasi"));

        System.out.println(BuildingRegistry.averagePricePerNeighborhood(buildingList));
        System.out.println(BuildingRegistry.uniqueCategoriesCount(buildingList));
    }
}
