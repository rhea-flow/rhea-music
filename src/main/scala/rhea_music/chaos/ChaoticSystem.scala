package rhea_music.chaos

import org.rhea_core.util.functions.Func1
import rhea_music.chaos.ChaoticSystem.{Constants, Range, SubFunc, X}
import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
class ChaoticSystem(val arguments: Int)
                   (val funcs: Array[SubFunc],
                    val constants: Constants,
                    val init: X
                   ) extends Func1[X, X] {

  override def call(x: X): X = {
    assert(x.length == arguments)
    assert(x.length == funcs.length)

    var ret = new ArrayBuffer[Double]()
    for (i <- x.indices) {
      val func = funcs(i)(constants)
      // Round result
      val x_ = BigDecimal(func.apply(x)).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
      ret += x_
    }

    ret.toArray
  }

  def range(N: Int): Array[Range] = {
    val ret = new ArrayBuffer[Range]()
    var x: X = init
    for (j <- 0 until arguments)
      ret += ((x(j), x(j)))
    for (i <- 0 until N-1) {
      x = this.call(x)
      for (j <- 0 until arguments)
        ret(j) = (math.min(ret(j)._1, x(j)), math.max(ret(j)._2, x(j)))
    }
    ret toArray
  }
}

object ChaoticSystem {

  type Range = (Double, Double)
  type Constants = Array[Double]
  type X = Array[Double]
  type SubFunc = Constants => X => Double

  val F1: ChaoticSystem =
    new ChaoticSystem(1)(
      constants = Array(1.4),
      init = Array(0.0),
      funcs = Array(c => p => 1.0 - c(0) * p(0) * p(0))
    )

  val F3: ChaoticSystem =
    new ChaoticSystem(2)(
      constants = Array(1.4, 0.3),
      init = Array(0.0, 0.0),
      funcs = Array(
        c => p => 1.0 + p(1) - c(0) * p(0) * p(0),
        c => p => c(1) * p(0)
      )
    )
}
