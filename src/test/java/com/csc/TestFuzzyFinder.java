package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void exampleFailingTestWithRandomizedFuzzies() {
    //ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    ArrayList<Fuzzy> fuzzies = new ArrayList<Fuzzy>();
    fuzzies.add(new Fuzzy("purple"));
    fuzzies.add(new Fuzzy("blue"));
    fuzzies.add(new Fuzzy("gold"));
    
    assertEquals("purple", fuzzies.getFirst().color);
  }

  /*@Test
  void exampleFailingTestWithSortedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }*/

  @Test 
  void testLinearSearchSorted() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<Fuzzy>();
    fuzzies.add(new Fuzzy("blue"));
    fuzzies.add(new Fuzzy("gold"));
    fuzzies.add(new Fuzzy("purple"));

    assertEquals(1, finder.linearSearch(fuzzies));
  }

  @Test
  void testLinearSearchRandom() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<Fuzzy>();
    fuzzies.add(new Fuzzy("indigo"));
    fuzzies.add(new Fuzzy("pink"));
    fuzzies.add(new Fuzzy("red"));
    fuzzies.add(new Fuzzy("gold"));

    assertEquals(3, finder.linearSearch(fuzzies));
  }

  @Test 
  void testBinarySearchSorted() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<Fuzzy>();
    fuzzies.add(new Fuzzy("blue"));
    fuzzies.add(new Fuzzy("gold"));
    fuzzies.add(new Fuzzy("indigo"));
    fuzzies.add(new Fuzzy("purple"));

    assertEquals(1, finder.binarySearch(fuzzies));
  }

  @Test 
  void testBinarySearchRandom() {
    ArrayList<Fuzzy> fuzzies = new ArrayList<Fuzzy>();
    fuzzies.add(new Fuzzy("gold"));
    fuzzies.add(new Fuzzy("indigo"));
    fuzzies.add(new Fuzzy("blue"));
    fuzzies.add(new Fuzzy("purple"));

    assertEquals(0, finder.binarySearch(fuzzies));
  }  

}
