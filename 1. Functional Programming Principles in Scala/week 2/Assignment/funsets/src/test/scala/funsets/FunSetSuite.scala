package funsets

import org.junit._

/**
 * This class is a test suite for the methods in object FunSets.
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite {

  import FunSets._

  @Test def `contains is implemented`: Unit = {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s12 = union(s1, s2)
    val s23 = union(s2, s3)
    val s123 = union(s12, s3)
  }

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remvoe the
   * @Ignore annotation.
   */
  @Test def `singleton set one contains one`: Unit = {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton 1")
      assert(contains(s2, 2), "Singleton 2")
      assert(contains(s3, 3), "Singleton 3")
    }
  }

  @Test def `union contains all elements of each set`: Unit = {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  @Test def `intersection contains all common elements between both sets`: Unit = {
    new TestSets {
      val s = intersect(s12, s23)
      assert(contains(s, 2), "Intersect 1")
      assert(!contains(s, 1), "Intersect 2")
      assert(!contains(s, 3), "Intersect 3")
    }
  }

  @Test def `diff contains all elements in one set but not in the other one`: Unit = {
    new TestSets {
      val r1 = diff(s12, s1)
      val r2 = diff(s123, s2)
      val r3 = diff(s3, s12)
      val r4 = diff(s1, s1)
      assert(contains(r1, 2), "Diff 1")
      assert(contains(r2, 1), "Diff 2")
      assert(contains(r2, 3), "Diff 3")
      assert(!contains(r2, 2), "Diff 4")
      assert(contains(r3, 3), "Diff 5")
      assert(!contains(r4, 1), "Diff 6")
      assert(!contains(r4, 2), "Diff 7")
      assert(!contains(r4, 3), "Diff 8")
    }
  }

  @Test def `filter contains all elements of set for which some predicate holds`: Unit = {
    new TestSets {
      val r1 = filter(s123, x => x == 2)
      val r2 = filter(s123, x => x >= 1 && x <= 3)
      val r3 = filter(s123, x => x < 3)
      val r4 = filter(s123, x => x > 10)
      assert(contains(r1, 2), "Filter 1")
      assert(!contains(r1, 1), "Filter 2")
      assert(contains(r2, 1), "Filter 3")
      assert(contains(r2, 2), "Filter 4")
      assert(contains(r2, 3), "Filter 5")
      assert(!contains(r2, 0), "Filter 6")
      assert(!contains(r2, 4), "Filter 7")
      assert(contains(r3, 1), "Filter 8")
      assert(!contains(r3, 3), "Filter 9")
      assert(!contains(r3, -1), "Filter 10")
      assert(!contains(r4, 3), "Filter 11")
      assert(!contains(r4, 13), "Filter 12")
    }
  }

  @Test def `forall checks whether a given predicate is true for all bounded elements of a set`: Unit = {
    new TestSets {
      val r1 = forall(s123, x => x * x > 0 && x * x < 10)
      val r2 = forall(s123, x => x < 2)
      val r3 = forall(s123, x => x > -5)
      assert(r1 == true, "Forall 1")
      assert(r2 == false, "Forall 2")
      assert(r3 == true, "Forall 3")
    }
  }

  @Test def `exists checks whether a given predicate is true for at least one element of a set`: Unit = {
    new TestSets {
      val r1 = exists(s123, x => x * x > 0 && x * x < 10)
      val r2 = exists(s123, x => x < 2)
      val r3 = exists(s123, x => x > 5)
      assert(r1 == true, "Exists 1")
      assert(r2 == true, "Exists 2")
      assert(r3 == false, "Exists 3")
    }
  }

  @Test def `map transforms a set into another one by applying to each of its elements some function`: Unit = {
    new TestSets {
      val s = map(s123, x => x * x)
      assert(contains(s, 1), "Map 1")
      assert(contains(s, 4), "Map 2")
      assert(contains(s, 9), "Map 4")
      assert(!contains(s, 2), "Map 5")
      assert(!contains(s, 3), "Map 6")
      assert(!contains(s, bound + 1), "Map 7")
    }
  }



  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
