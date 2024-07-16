object MergeSort {
  def merge(left: Seq[Int], right: Seq[Int]): Seq[Int] = {
    def mergeTail(left: Seq[Int], right: Seq[Int], acc: Seq[Int]): Seq[Int] = (left, right) match {
      case (Seq(), _) => acc ++ right
      case (_, Seq()) => acc ++ left
      case (lHead +: lTail, rHead +: rTail) => {
        if (lHead <= rHead) mergeTail(lTail, right, acc :+ lHead)
        else mergeTail(left, rTail, acc :+ rHead)
      }
    }
    mergeTail(left, right, Seq.empty[Int])
  }

  def mergeSort(items: Seq[Int]): Seq[Int] = {
    if (items.length <= 1) items
    else {
      val (left, right) = items.splitAt(items.length / 2)
      val (sortedLeft, sortedRight) = (mergeSort(left), mergeSort(right))
      merge(sortedLeft, sortedRight)
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Seq(35, 33, 23, 14, 555)
    val res = mergeSort(arr)
    res.foreach(elm => print(s"$elm, "))
  }
}
