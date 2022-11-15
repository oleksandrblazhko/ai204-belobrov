package com.nuop.tscp;

import java.util.ArrayList;
import java.util.List;

public class LiteratureIdTest {

  public static int basicTestCaseNumber = 1;

  public static boolean isLiteratureIdCorrect(Integer literatureId) {
    return literatureId > 0 && literatureId < 1000000000;
  }

  public static void doTestCase(int testCaseNumber, int literatureId) {
    System.out.print("TC" + (basicTestCaseNumber + testCaseNumber) + ": ");
    if (isLiteratureIdCorrect(literatureId)) {
      System.out.println("PASSED");
    } else {
      System.out.println("FAILED");
    }
  }

  public static void main(String[] args) {

    List<Integer> values = new ArrayList<>(List.of(
        1, 12, 123, 12345125, 21564354, 999999999
    ));

    values.forEach((id) -> doTestCase(values.indexOf(id), id));
  }
}
