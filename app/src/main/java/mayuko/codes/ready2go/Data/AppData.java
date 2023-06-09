package mayuko.codes.ready2go.Data;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import mayuko.codes.ready2go.Database.RoomDB;
import mayuko.codes.ready2go.Models.Items;
import mayuko.codes.ready2go.Constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB database;
    String category;
    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 1;

    public AppData(RoomDB database){
        this.database = database;
    }

    public AppData(RoomDB database, Context context){
        this.database = database;
        this.context = context;
    }

    public List<Items> getBasicData(){
        category = "Basic Needs";
        List<Items> basicItem = new ArrayList<>();
        basicItem.add(new Items("Visa",category,false));
        basicItem.add(new Items("Passport",category,false));
        basicItem.add(new Items("Tickets",category,false));
        basicItem.add(new Items("Wallet",category,false));
        basicItem.add(new Items("Driving License",category,false));
        basicItem.add(new Items("Currency",category,false));
        basicItem.add(new Items("House Key",category,false));
        basicItem.add(new Items("Book",category,false));
        basicItem.add(new Items("Travel Pillow",category,false));
        basicItem.add(new Items("Eye Patch",category,false));
        basicItem.add(new Items("Umbrella",category,false));
        basicItem.add(new Items("Note Book",category,false));

        return basicItem;
    }

    public List<Items> getPersonalCareData(){
        String[] data = {"Tooth-brush", "Tooth-paste", "Floss", "Mouthwash", "Shaving Cream", "Razor Blade", "Soap", "Fiber", "Shampoo",
                "Hair Conditioner", "Brush", "Comb", "Hair Dryer", "Curling Iron", "Hair Moulder", "Hair Clip", "Moisturizer", "Lip Cream",
                "Contact Lens", "Perfume", "Deodorant", "Makeup Materials", "Makeup Remover", "Wet Wipes", "Pad", "Ear Stick", "Cotton",
                "Nail Polish", "Nail Polish Remover", "Tweezers", "Nail Scissors", "Nail Files", "Suntan Cream"};
        return prepareItemsList(Constants.PERSONAL_CARE_CAMEL_CASE, data);
    }

    public List<Items> getClothingData(){
        String []data = {"Stockings", "Underwear", "Pajamas", "T-Shirts", "Casual Dress", "Evening Dress",
        "Shirt", "Cardigan", "Vest", "Jacket", "Skirt", "Trousers", "Jeans", "Shorts", "Suit",
        "Coat", "Rain Coat", "Glove", "Hat", "Scarf", "Bikini", "Belt", "Slipper", "Sneakers", "Casual Shoes",
        "Heeled Shoes", "Sports Wear"};
        return prepareItemsList(Constants.CLOTHING_CAMEL_CASE,data);
    }

    public List<Items> getBabyNeedsData(){
        String []data = {"Snapsuit", "Outfit", "JumpSuit", "Baby Socks", "Baby Hat", "Baby Pyjamas",
        "Baby Bath Towel", "Muslin", "Blanket", "Dribble Bibs", "Baby Laundry Detergent",
        "Baby Bottles", "Baby Food Thermos", "Baby Bottle Brushes", "Brest-feeding Cover",
        "Breast Pump", "Water Bottle", "Storage Container", "Baby Food Spoon",
        "Highchairs", "Diaper", "Baby Cotton", "Wet Wipes", "Baby Care Cover", " Baby Shampoo", "Baby Soap",
        "Baby Nail Scissors", "Body Moisturizer", "Potty", "Diaper Rash Cream", "Serum Physiological", "Nasal Aspirator", "Fly Repellent Lotion",};
        return prepareItemsList(Constants.BABY_NEEDS_CAMEL_CASE,data);
    }

    public  List<Items> getHealthData(){
        String []data = {"Aspirin", "Drugs Used", "Vitamins Used", "Lens Solutions", "Condom",
        "Hot Water Bag", "Tincture of Lodine", "Adhesive Plaster", "First Aid Kit", "Replacement Lens", "Pain Reliever", "Fever Reducer", "Diarrhea Stopper",
        "Pain Relieve Spray"};
        return prepareItemsList(Constants.HEALTH_CAMEL_CASE,data);
    }

    public List<Items> getTechnologyData(){
        String []data = {"Mobile Phone", "Phone Cover", "E-Book Reader", "Camera", "Camera Charger",
        "Portable Speaker", "IPad (TAB)", "Headphone",
        "Laptop", "Laptop Charger", "Mouse", "Extension Cable", "Data Transfer Cable",
        "Battery", "Power Bank", "DVD Player", "Flash-Light", "MP# Player", "MP3 Player Charger",
        "Voltage Adapter", "SD Card"};
        return prepareItemsList(Constants.TECHNOLOGY_CAMEL_CASE,data);
    }
    public List<Items> getFoodData(){
        String []data = {"Snack", "Sandwich", "Juice", "Tea Bags", "Coffee", "Water", "Thermos", "Chips", "Baby Food"};
        return prepareItemsList(Constants.FOOD_CAMEL_CASE,data);
    }

    public List<Items> getBeachSuppliesData(){
        String []data ={"Sea Glasses", "Sea Bed", "Suntan Cream", "Beach Umbrella", "Swim Fins", "Beach Bag",
                "Beach Towel", "Beach Slippers", "Sunbed", "Snorkel", "Waterproof Clock" };
        return prepareItemsList(Constants.BEACH_SUPPLIES_CAMEL_CASE,data);
    }

    public List<Items> getCarSuppliesData(){
        String []data = {"Pump", "Car Jack", "Spare Car Key","Accident Record Set","Auto Refrigerator",
        "Car Cover", "Car Charger", "Window Sun Shades"};
        return prepareItemsList(Constants.CAR_SUPPLIES_CAMEL_CASE,data);
    }

    public List<Items> getNeedsData(){
        String []data = {"Backpack","Daily Bags","Laundry Bag","Sewing Kit",
        "Travel Lock","Language Tag", "Magazine",
        "Sports Equipment","Important Numbers"};
        return prepareItemsList(Constants.NEEDS_CAMEL_CASE,data);
    }

    public List<Items> prepareItemsList(String category, String []data){
        List<String> list = Arrays.asList(data);
        List<Items> dataList = new ArrayList<>();
        dataList.clear();

        for (int i = 0; i < list.size(); i++){
            dataList.add(new Items(list.get(i), category, false));
        }
        return dataList;
    }

    public List<List<Items>> getAllData(){
        List<List<Items>> listOfAllItems = new ArrayList<>();
        listOfAllItems.clear();
        listOfAllItems.add(getBasicData());
        listOfAllItems.add(getClothingData());
        listOfAllItems.add(getPersonalCareData());
        listOfAllItems.add(getBabyNeedsData());
        listOfAllItems.add(getHealthData());
        listOfAllItems.add(getTechnologyData());
        listOfAllItems.add(getFoodData());
        listOfAllItems.add(getBeachSuppliesData());
        listOfAllItems.add(getCarSuppliesData());
        listOfAllItems.add(getNeedsData());
        return listOfAllItems;
    }

    public void persistAllData(){
        List<List<Items>> listOfAllItems = getAllData();
        for (List<Items> list: listOfAllItems){
            for (Items items:list){
                database.mainDao().saveItem(items);
            }
        }
        System.out.println("Data added.");
    }

    public void persistDataByCategory(String category, Boolean onlyDelete){
        try{
            List<Items> list = deleteAndGetListByCategory(category, onlyDelete);
            if (!onlyDelete){
                for (Items item : list){
                    database.mainDao().saveItem(item);
                }
                Toast.makeText(context, category + "Reset Successfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, category + "Reset Successfully", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private List<Items> deleteAndGetListByCategory(String category, Boolean onlyDelete){
        if (onlyDelete){
            database.mainDao().deleteAllByCategoryAndAddedBy(category, Constants.SYSTEM_SMALL);
        }else {
            database.mainDao().deleteAllByCategory(category);
        }

        switch (category){
            case Constants.BASIC_NEEDS_CAMEL_CASE:
                return getBasicData();

            case Constants.CLOTHING_CAMEL_CASE:
                return getClothingData();

            case Constants.PERSONAL_CARE_CAMEL_CASE:
                return getPersonalCareData();

            case Constants.BABY_NEEDS_CAMEL_CASE:
                return getBabyNeedsData();

            case Constants.HEALTH_CAMEL_CASE:
                return getHealthData();

            case Constants.TECHNOLOGY_CAMEL_CASE:
                return getTechnologyData();

            case Constants.FOOD_CAMEL_CASE:
                return getFoodData();

            case Constants.BEACH_SUPPLIES_CAMEL_CASE:
                return getBeachSuppliesData();

            case Constants.CAR_SUPPLIES_CAMEL_CASE:
                return getCarSuppliesData();

            case Constants.NEEDS_CAMEL_CASE:
                return getNeedsData();

            default:
                return new ArrayList<>();
        }
    }
}

