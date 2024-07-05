sealed trait Expr
case class BinOp(left: Expr, op: String, right: Expr) extends Expr
case class Literal(value: Int) extends Expr
case class Variable(name: String) extends Expr

object SimplifyExpression {
  // From the book
  private def evaluate(expr: Expr, values: Map[String, Int]): Int = expr match {
    case BinOp(left, "+", right) => evaluate(left, values) + evaluate(right, values)
    case BinOp(left, "-", right) => evaluate(left, values) - evaluate(right, values)
    case BinOp(left, "*", right) => evaluate(left, values) * evaluate(right, values)
    case Literal(value)          => value
    case Variable(name)          => values(name)
  }

  // From the book
  private def stringify(expr: Expr): String = expr match {
    case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})"
    case Literal(value)         => value.toString
    case Variable(name)         => name
  }

  def main(args: Array[String]): Unit = {
    val smallExpr = BinOp(
      Variable("x"),
      "+",
      Literal(1)
    )

    // ((x + 1) * (y - 1))
    val largeExpr = BinOp(
      BinOp(Variable("x"), "+", Literal(1)),
      "*",
      BinOp(Variable("y"), "-", Literal(1))
    )

    // (1 + 1)
    val expr1 = BinOp(
      Literal(1),
      "+",
      Literal(1)
    )

    val res1 = stringify(smallExpr)
    println(res1)
    val res2 = evaluate(smallExpr, Map("x" -> 10))
    println(res2)
  }
}
