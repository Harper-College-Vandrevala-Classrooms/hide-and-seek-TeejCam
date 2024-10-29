package com.csc;
import java.util.ArrayList;
import java.util.List;

public class FuzzyFinder {
  // Your code goes here!

  public static int linearSearch(List<Fuzzy> fuzzies) 
  {
    for(int i=0; i < fuzzies.size(); i++) {
      if(fuzzies.get(i).color.equals("gold")) {
        return i;
      }
    }
    return -1;
  }

  public static int binarySearch(List<Fuzzy> fuzzies)
  {
    int low = 0;
    int high = fuzzies.size() - 1;
    String str = "gold";

    while(low <= high) {
      int midPos = (low + high) /2;
      //Fuzzy midFuzzy = fuzzies.get(midPos); //list[midPos]
      String midFuzColor = fuzzies.get(midPos).color;

      if(midFuzColor.equals("gold")) { //midFuzColor.equals("gold")
        return midPos; 
      }

      if(str.compareTo(midFuzColor) < 0) {
        high = midPos - 1;
      }
      else {
        low = midPos + 1;
      }
    }
    return -1;
  }


  public static void main(String args[]) {
    //System.out.println("In addition to your search functions, you can write a main function if you wish!");

    FuzzyListGenerator generator = new FuzzyListGenerator();
    FuzzyFinder finder = new FuzzyFinder();

    ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

    int testOne = finder.linearSearch(sortedFuzzies);
    int testTwo = finder.binarySearch(sortedFuzzies);
    int testThree = finder.linearSearch(randomFuzzies);
    int testFour = finder.binarySearch(randomFuzzies);

    System.out.println(testOne);
    System.out.println(testTwo);
    System.out.println(testThree);
    System.out.println(testFour);



  }
}
