package rhea_music.chaos

/**
  * @author Orestis Melkonian
  */
class ComplexFunction(val func1: Array[Double] => Array[Double] => Double,
                      val func2: Array[Double] => Array[Double] => Double,
                      override val constants: Array[Double],
                      val initial: (Double, Double)
                     ) extends ChaoticSystem(2)(Array(func1, func2), constants,
                                                Array(initial._1, initial._2)) {
}

object ComplexFunction {

  // x' = y' - Ax^2
  // y' = Bx

  def f3(A: Double, B: Double, init: (Double, Double) = (0.0, 0.0)): ComplexFunction =
    new ComplexFunction(
      constants = Array(A, B),
      initial = (0.0, 0.0),
      func1 = c => p => 1.0 + p(1) - c(0) * p(0) * p(0),
      func2 = c => p => c(1) * p(0)
    )
}
