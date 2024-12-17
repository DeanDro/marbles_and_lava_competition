package marbles_and_lava_compeition.git.utilities;

import marbles_and_lava_compeition.git.utilities.Marbles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class CountriesPopulation {

    private HashMap<String, String> countriesDict;

    public CountriesPopulation(){
        this.countriesDict = new HashMap<>();
    }

    // Helper to check if an integer is included in an array
    private Boolean containsElement(int[] array, int element){
        for(int i: array){
            if (i == element){
                return true;
            }
        }
        return false;
    }

    // Gets an array and redistributes elements to a random list
    public String[] randomizeElementsOrder(String[] origList){
        Random random = new Random();
        String[] randomOrder = new String[origList.length];
        int[] elementsSelected = new int[origList.length];

        Arrays.fill(elementsSelected, 100);

        int j = random.nextInt(origList.length);
        for (int i = 0; i< origList.length; i++){

            while (this.containsElement(elementsSelected, j)){
                j = random.nextInt(origList.length);
            }

            randomOrder[i] = origList[j];
            elementsSelected[i] = j;
        }

        return randomOrder;
    }

    //
    public void addMarbleData(String name){

        String path = "images/flags/"+name.toLowerCase()+"_circle.png";
        this.countriesDict.put(name, path);
    }

    public HashMap<String , String> getHashMap(){
        return this.countriesDict;
    }

    public void populateAllCountries(String[] countries){

        for (String name : countries) {
            this.addMarbleData(name);
        }
    }
}
