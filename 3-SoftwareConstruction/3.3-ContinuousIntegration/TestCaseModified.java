package com.nuop.tscp;

public class LiteratureTest {

  public static boolean isLiteratureIdCorrect(Integer literatureId) {
    return literatureId > 0 && literatureId < 1000000000;
  }

  public static boolean isLiteratureTypeCorrect(String literatureType) {
    return literatureType.equalsIgnoreCase("free")
        || literatureType.equalsIgnoreCase("trial")
        || literatureType.equalsIgnoreCase("paid");
  }

  private static Integer testLiterature(Literature literature) {

    if (!isLiteratureIdCorrect(literature.getLiteratureId())) {
      return -1;
    }

    if (!isLiteratureTypeCorrect(literature.getType())) {
      return -2;
    }

    return 0;
  }

  public static void main(String[] args) {

    Literature goodLiterature = new Literature(1, "trial");
    int actualResultFirst = testLiterature(goodLiterature);
    System.out.println("TC1: object " + goodLiterature + "  should pass check.      Expected result =  0, actual result =  " + actualResultFirst + " || " + ((0 == actualResultFirst)?("PASSED"):("FAILED")));

    Literature badLiteratureOne = new Literature(-20, "free");
    int actualResultSecond = testLiterature(badLiteratureOne);
    System.out.println("TC2: object " + badLiteratureOne + " should not pass check.  Expected result = -1, actual result = " + actualResultSecond + " || " + ((-1 == actualResultSecond)?("PASSED"):("FAILED")));

    Literature badLiteratureTwo = new Literature(10, "sold");
    int actualResultThird = testLiterature(badLiteratureTwo);
    System.out.println("TC3: object " + badLiteratureTwo + "  should not pass check.  Expected result = -9, actual result = " + actualResultThird + " || " + ((-9 == actualResultThird)?("PASSED"):("FAILED")));

    if (0 != actualResultFirst || -1 != actualResultSecond || -9 != actualResultThird) {
      System.exit(-1);
    }

  }
}

class Literature {

  private Integer literatureId;
  private String type;

  public Literature(Integer literatureId, String type) {
    this.literatureId = literatureId;
    this.type = type;
  }

  public Integer getLiteratureId() {
    return literatureId;
  }

  public void setLiteratureId(Integer literatureId) {
    this.literatureId = literatureId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Literature{" +
        "literatureId=" + literatureId +
        ", type='" + type + '\'' +
        '}';
  }
}
