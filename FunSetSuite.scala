import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  test("singletonSet(1) contains 1") {

    new TestSets {
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

    test("set intersation ONLY") {
      new TestSets {
        val s = union(s1, s2)
        val s4 = intersect(s, s2) // name of s3 needed overriding so that s4
        assert(contains(s4, 2), "Union 2")
        assert(!contains(s4, 3), "Union 3")
      }
    }

  test("set contains diff") {
    new TestSets {
      val s = union(s1, s2)
      val s4 = diff(s, s2) // name of s3 would need overriding so that s4
      assert(!contains(s4, 2), "Union 2")
      assert(contains(s4, 1), "Union 3")
    }
  }

  test("set contains filtered content ") {
    new TestSets {
      val s = union(s1, s2)
      val s4 = filter(s, s1) // name of s3 would need overriding so that s4
      assert(!contains(s4, 2), "Union 2")
      assert(contains(s4, 1), "Union 3")
    }
  }
}
