package rhea_music.chaos

/**
  * @author Orestis Melkonian
  */

class ChaoticFunction(val func: Array[Double] => Double => Double,
                      override val constants: Array[Double],
                      val initial: Double
                     ) extends ChaoticSystem(1)(Array(c => p => func(c)(p(0))), constants, Array(initial))

object ChaoticFunction {

  def f1(R: Double): ChaoticFunction =
    new ChaoticFunction(
      constants = Array(R),
      initial = 0.0,
      func = c => x => 1.0 - c(0) * x * x
    )

  // logistic map
  def f2(R: Double): ChaoticFunction =
    new ChaoticFunction(
      constants = Array(R),
      initial = 0.0,
      func = c => x => c(0) * x * (1.0 - x)
    )
}
