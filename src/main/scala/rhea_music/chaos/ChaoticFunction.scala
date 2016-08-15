package rhea_music.chaos

import scala_wrapper.ImplicitConversions._
import org.rhea_core.util.functions.Func1

/**
  * @author Orestis Melkonian
  */
class ChaoticFunction(val func: Array[Double] => Double => Double,
                      val constants: Array[Double],
                      val init: Double
                     ) extends Func1[Double, Double] {

  override def call(t: Double): Double = func(constants)(t)

  def range(N: Int): (Double, Double) = {
    val f = func(constants)

    var x: Double = f(init)
    var min: Double = x
    var max: Double = x

    for (i <- 1 to N) {
      val xx = f(x)

      if (xx < min) {min = xx}
      if (xx > max) {max = xx}

      x = xx
    }

    (min, max)
  }
}

object ChaoticFunction {

  def f1(R: Double): ChaoticFunction =
    new ChaoticFunction(
      constants = Array(R),
      init = 0.0,
      func = c => x => 1 - c(0) * x * x
    )

  def f2(R: Double): ChaoticFunction =
    new ChaoticFunction(
      constants = Array(R),
      init = 0.0,
      func = c => x => c(0) * x * (1 - x)
    )
}
