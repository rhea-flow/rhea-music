package rhea_music.chaos

import org.rhea_core.util.functions.Func1

/**
  * @author Orestis Melkonian
  */
class ComplexFunction(val func: Array[Double] => Tuple2[Double, Double] => Tuple2[Double, Double],
                      val constants: Array[Double],
                      val init: (Double, Double)
                     ) extends Func1[(Double, Double), (Double, Double)] {

  override def call(t: (Double, Double)): (Double, Double) = func(constants)(t)

  def range(N: Int): ((Double, Double), (Double, Double)) = {
    val f = func(constants)

    var x = init
    var min1 = x._1
    var max1 = x._1
    var min2 = x._2
    var max2 = x._2

    for (i <- 1 to N) {
      val xx = f(x)

      if (xx._1 < min1) {min1 = xx._1}
      if (xx._1 > max1) {max1 = xx._1}
      if (xx._2 < min2) {min2 = xx._2}
      if (xx._2 > max2) {max2 = xx._2}

      x = xx
    }

    ((min1, max1), (min2, max2))
  }
}

object ComplexFunction {

  def f3(A: Double, B: Double, init: (Double, Double) = (0.0, 0.0)): ComplexFunction =
    new ComplexFunction(
      constants = Array(A, B),
      init = (0.0, 0.0),
      func = c => p => (1 + p._2 - c(0) * p._1 * p._1, c(1) * p._1)
    )
}
