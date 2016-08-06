package rhea_music.chaos

import org.rhea_core.util.functions.Func1

/**
  * @author Orestis Melkonian
  */
class GenericFunction[T <: Ordered[T],C](val func: Array[C] => T => T,
                                         val constants: Array[C],
                                         val init: T
                                        ) extends Func1[T, T] {

  // TODO generalise for systems with N chaotic equations

  override def call(t: T): T = func(constants)(t)

  def range(N: Int): (T, T) = {
    val f = func(constants)

    var x: T = f(init)
    var min: T = x
    var max: T = x

    for (i <- 1 to N) {
      val xx: T = f(x)

      if (xx < min) {min = xx}
      if (xx > max) {max = xx}

      x = xx
    }

    (min, max)
  }
}

object GenericFunction {

  def f3(): GenericFunction[(Double, Double), Double] =
    new GenericFunction[(Double, Double), Double](
      constants = Array(1.4, 0.3),
      init = (0.0, 0.0),
      func = c => p => (1 + p._2 - c(0) * p._1 * p._1, c(1) * p._1)
    )
}
