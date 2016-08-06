package rhea_music.chaos

import java.util.concurrent.TimeUnit

import rhea_music.ImplicitConversions._
import jm.constants.Durations._
import jm.music.data.{Note, Part, Phrase, Rest}
import org.rhea_core.Stream
import rhea_music.music_streams.NoteStream
import rhea_music.utils.Contants._

import scala.util.Random

/**
  * @author Orestis Melkonian
  */
class ChaosStream(stream: Stream[Double], range: (Double, Double)) {

  def mapToPitch(min: Int, max: Int): NoteStream =
    stream.map((t: Double) =>
      new Note(ChaosStream.mapRange(range._1, range._2, min, max, t).toInt, QN)
    ): Stream[Note]
  def mapToBass: NoteStream =
    mapToPitch _ tupled bassRange
  def mapToBaritone: NoteStream =
    mapToPitch _ tupled baritoneRange
  def mapToTenor: NoteStream =
    mapToPitch _ tupled tenorRange
  def mapToAlto: NoteStream =
    mapToPitch _ tupled altoRange
  def mapToSoprano: NoteStream =
    mapToPitch _ tupled sopranoRange

  def mapToRhythm(min: Double = THIRTYSECOND_NOTE_TRIPLET, max: Double = WHOLE_NOTE): Stream[Double] =
    stream.map((t: Double) => {
      val indexMin = ChaosStream.durations.indexOf(min).toDouble
      val indexMax = ChaosStream.durations.indexOf(max).toDouble
      val index = ChaosStream.mapRange(range._1, range._2, indexMin, indexMax, t).toInt
      ChaosStream.durations(index)
    }
  ): Stream[Double]
}

object ChaosStream {

  def from(cf: ChaoticFunction, N: Int): ChaosStream = {
    new ChaosStream(
      stream = Stream.just(cf.init).loopN(init => init.map(cf), N),
      range = cf.range(N)
    )
  }

  def from(cf: ComplexFunction, N: Int): (ChaosStream, ChaosStream) = {

    val streams = unzip(
      Stream.just(cf.init).loopN((init: Stream[(Double, Double)]) =>
        init.map[(Double, Double)](t => cf.call(t._1, t._2)),
        N
      )
    )

    val c1: ChaosStream =
      new ChaosStream(
        stream = streams._1,
        range = cf.range(N)._1
      )

    val c2: ChaosStream =
      new ChaosStream(
        stream = streams._2,
        range = cf.range(N)._2
      )

    (c1, c2)
  }


  def moveToZero(min: Double, max: Double): (Double, Double, Double) = {
    var offset = 0.0
    if (min < 0) {
      offset = Math.abs(min)
    }
    else {
      offset = - min
    }
    (min + offset, max + offset, offset)
  }
  /**
    * Maps a value to a different numeric range
    *
    * @param inputMin lower bound of x
    * @param inputMax upper bound of x
    * @param outputMin desired lower bound
    * @param outputMax desired upper bound
    * @param x    the value to map (aMin..aMax)
    * @return the mapped value (bMin..bMax)
    */
  def mapRange(inputMin: Double, inputMax: Double,
               outputMin: Double, outputMax: Double,
               x: Double): Double = {
    outputMin + (x - inputMin) * (outputMax - outputMin) / (inputMax - inputMin)
  }

  def unzip[T](stream: Stream[(T, T)]): (Stream[T], Stream[T]) = (
    stream.map((p: (T, T)) => p._1),
    stream.map((p: (T, T)) => p._2)
  )

  val durations: Array[Double] = Array(
    WHOLE_NOTE,
    DOUBLE_DOTTED_HALF_NOTE,
    DOTTED_HALF_NOTE,

    HALF_NOTE,
    DOUBLE_DOTTED_QUARTER_NOTE,
    DOTTED_QUARTER_NOTE,
    HALF_NOTE_TRIPLET,

    QUARTER_NOTE,
    DOUBLE_DOTTED_EIGHTH_NOTE,
    DOTTED_EIGHTH_NOTE,
    QUARTER_NOTE_TRIPLET,

    EIGHTH_NOTE,
    DOTTED_SIXTEENTH_NOTE,
    EIGHTH_NOTE_TRIPLET,

    SIXTEENTH_NOTE,
    SIXTEENTH_NOTE_TRIPLET,

    THIRTYSECOND_NOTE,
    THIRTYSECOND_NOTE_TRIPLET
  ).reverse
}
