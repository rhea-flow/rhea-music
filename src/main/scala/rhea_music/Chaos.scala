package rhea_music

import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.constants.Durations._
import jm.constants.Pitches._
import jm.music.data.Note
import org.rhea_core.Stream
import org.rhea_core.util.functions.Func1

object ChaoticMelodies {
  /**
    * Generate a new chaotic motif.
    *
    * @param func the chaotic recursive function to use
    * @param init the initial seed
    * @param N the number of notes the motif will consist of
    * @param rangeMix the lower bound of the chaotic system
    * @param rangeMax the upper bound of the chaotic system
    * @return the chaotic melody as a stream of notes
    */
  def generateChaoticMelody(func: Double => Double,
                            init: Double,
                            N: Int,
                            rangeMix: Double = -1,
                            rangeMax: Double = 1): Stream[Note] =
    Stream.just(init).loop((init: Stream[Double]) => init.map(func))
      .map[Note]((i: Double) => {
      val pitch = mapRange(rangeMix, rangeMax, E2, E6, i).toInt
      new Note(pitch, SN)
    })
      .take(N)


  /**
    * Generate a new complex motif.
    *
    * @param func the system of chaotic recursive function to use (2)
    * @param init the initial seed
    * @param N the number of notes the motif will consist of
    * @return the chaotic melody as a stream of notes
    */
  def generateComplexMelody(func: (Double, Double) => (Double, Double),
                            init: (Double, Double),
                            N: Int,
                            rangeMinX: Double = -1,
                            rangeMaxX: Double = 1,
                            rangeMinY: Double = -1,
                            rangeMaxY: Double = 1,
                            pitchMinX: Double = -1,
                            pitchMaxX: Double = 1,
                            pitchMinY: Double = -1,
                            pitchMaxY: Double = 1
                           ): (Stream[Note], Stream[Note]) =
    unzip(
      Stream.just(init).loop((init: Stream[(Double, Double)]) =>
        init.map[(Double, Double)](
          (t: (Double, Double)) => func.apply(t._1, t._2)
            )
          )
          .map[(Note, Note)]((i: (Double, Double)) => {
            val pitch1 = mapRange(rangeMinX, rangeMaxX, pitchMinX, pitchMaxX, i._1).toInt
            val pitch2 = mapRange(rangeMinY, rangeMaxY, pitchMinY, pitchMaxY, i._2).toInt
            (new Note(pitch1, SN), new Note(pitch2, SN))
          })
          .take(N)
    )

  private def mapRange(a1:Double, a2:Double, b1:Double, b2:Double, x:Double): Double =
    b1 + (x - a1) * (b2 - b1) / (a2 - a1)


  def unzip[T](stream: Stream[(T, T)]): (Stream[T], Stream[T]) =
    (
      stream.map((p: (T, T)) => p._1),
      stream.map((p: (T, T)) => p._2)
    )

}

object ChaoticFunctions {

  // R in [1,4]
  def f1(R: Double): Double => Double =
    (x: Double) => 1 - R * x * x

  def f2(R: Double): Double => Double =
    (x: Double) => R * x * (1 - x)

  /*
   * A = 1.4 => x in [-1.28, 1.28]
   * B = 0.3 => y in [-0.35, 0.35]
   */
  def f3(A: Double, B: Double): (Double, Double) => (Double, Double) =
    (x: Double, y: Double) => (1 + y - A * x * x, B * x)

}
