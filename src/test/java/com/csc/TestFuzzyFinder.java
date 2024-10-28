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
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }

  @Test
  void exampleFailingTestWithSortedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }


}
