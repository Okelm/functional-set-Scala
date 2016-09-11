
object FunSets {

  type Set = Int => Boolean

  def contains(s: Set, elem: Int): Boolean = s(elem)

    def singletonSet(elem: Int): Set = (x:Int) => x==elem

    def union(s: Set, t: Set): Set = (y:Int)  => contains(s,y) ||contains(t,y)

    def intersect(s: Set, t: Set): Set = (y:Int)  => contains(s,y) && contains(t,y)

    def diff(s: Set, t: Set): Set = (y:Int)  => contains(s,y) && !contains(t,y)

    def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)


  val bound = 1000

    def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a <= -1000) true
      else if (contains(filter(s,p),a)) false
      else iter(a - 1)
    }
    iter(bound)
  }

  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  def printSet(s: Set) {
    println(toString(s))
  }
}
