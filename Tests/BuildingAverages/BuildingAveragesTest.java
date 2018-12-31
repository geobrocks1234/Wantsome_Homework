package BuildingAverages;

import org.junit.Assert;
import org.junit.Test;
import week6.BuildingAverages.Building;
import week6.BuildingAverages.BuildingRegistry;
import week6.BuildingAverages.Category;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static week4.ComplexNumber.TestUtil.assertTrue;

public class BuildingAveragesTest {
    @Test
    public void testAveragePricePerCategoryOnEmptyList() {
        List<Building> buildingList = new ArrayList<> ();

        Map<Category, Double> result = BuildingRegistry.averagePricePerCategory(buildingList);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testAveragePricePerCategory(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));

        Map<Category, Double> result = BuildingRegistry.averagePricePerCategory(buildingList);

        assertEquals(2, result.size());
    }

    @Test
    public void testAveragePricePerCategoryExpectedPrice(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        Map<Category, Double> expected = new HashMap<> ();
        expected.put(Category.RESIDENTIAL, 1234.56);
        expected.put(Category.OFFICE, 10.56);
        expected.put(Category.OFFICE, 20.56);

        Map<Category, Double> result = BuildingRegistry.averagePricePerCategory(buildingList);

        assertEquals(1234.56, result.get(Category.RESIDENTIAL), 0.00001);
        assertEquals(15.56, result.get(Category.OFFICE), 0.00001);
        assertEquals(20.56, result.get(Category.HOSPITAL), 0.00001);
    }

    @Test
    public void testAveragePricePerNeighborhoodOnEmptyList(){
        List<Building> buildingList = new ArrayList<>();

        Map<String, Double> result = BuildingRegistry.averagePricePerNeighborhood(buildingList);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testAveragePricePerNeighborhoodListSize(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Pacurari", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Tatarasi", 20.56, Category.HOSPITAL));

        Map<String, Double> result = BuildingRegistry.averagePricePerNeighborhood(buildingList);

        assertEquals(4, result.size());
    }

    @Test
    public void testAveragePricePerNeighborhoodExpectedPrice(){

        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        Map<String, Double> result = BuildingRegistry.averagePricePerNeighborhood(buildingList);

        assertEquals(1234.56, result.get("Dacia"), 0.00001);
        assertEquals(17.226666, result.get("Canta"), 0.00001);

    }

    @Test
    public void testUniqueCategoriesOnEmptyList(){
        List<Building> buildingList = new ArrayList<>();

        Set<Category> result = BuildingRegistry.uniqueCategories(buildingList);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testUniqueCategories(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        Set<Category> result = BuildingRegistry.uniqueCategories(buildingList);
        Set<Category> expected = new HashSet<>();
        expected.add(Category.RESIDENTIAL);
        expected.add(Category.OFFICE);
        expected.add(Category.HOSPITAL);

        assertEquals(result, expected);
    }

    @Test
    public void testHowManyUniqueCategories(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        Set<Category> result = BuildingRegistry.uniqueCategories(buildingList);

        assertEquals(3, result.size());
    }

    @Test
    public void testUniqueCategoriesCount(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        assertEquals(3, BuildingRegistry.uniqueCategoriesCount(buildingList));
    }
    @Test
    public void testBuildingNamesFromNeighborhood(){
        List<Building> buildingList = new ArrayList<>();
        buildingList.add(new Building("A1", "Dacia", 1234.56, Category.RESIDENTIAL));
        buildingList.add(new Building("B2", "Canta", 10.56, Category.OFFICE));
        buildingList.add(new Building("A3", "Canta", 20.56, Category.OFFICE));
        buildingList.add(new Building("A4", "Canta", 20.56, Category.HOSPITAL));

        List<String> expectedList = Arrays.asList("A3", "A4", "B2");
        assertEquals(expectedList, BuildingRegistry.buildingNamesFromNeighborhood(buildingList, "Canta"));
    }
}
