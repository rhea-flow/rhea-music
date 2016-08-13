package rhea_music.chaos

import rhea_music.ImplicitConversions._

import org.jfugue.rhythm.Rhythm
import org.jfugue.theory.{Chord, Intervals, Note}
import org.rhea_core.Stream
import rhea_music.music_streams._
import rhea_music.util.mapToArray

import rhea_music.util.constants.Notes.allNotes
import rhea_music.util.constants.Intervals.allIntervals
import rhea_music.util.constants.Rhythms.allRhythms
import rhea_music.util.constants.Durations.allDurations

/**
  * @author Orestis Melkonian
  */
class ChaosStream(stream: Stream[Double], range: (Double, Double)) {

  def mapTo[T](array: Array[T]): Stream[T] =
    stream.map[T]((x: Double) =>
      mapToArray(range._1, range._2, x, array)
    )

  /*def mapToNotes: NoteStream =
    mapTo[Note](allNotes)

  def mapToIntervals: IntervalsStream =
    mapTo[Intervals](allIntervals)

  def mapToChords: ChordStream =
    mapTo[Chord](allChords)

  def mapToRhythm: RhythmStream =
    mapTo[Char](allRhythms)

  def mapToDuration: DurationStream =
    mapTo[String](allDurations)*/
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

  /*def chaoticMelody(N: Int): MusicStream = {
    val (s1, s2) = from(ComplexFunction.f3(1.4, 0.3), N)
    s1.mapToNotes.setDuration(s2.mapToDuration)
  }

  def chaoticHarmony(N: Int): MusicStream = {
    val (s1, s2) = from(ComplexFunction.f3(1.4, 0.3), N)
    s1.mapToChords.setDuration(s2.mapToDuration)
  }*/

  def unzip[T](stream: Stream[(T, T)]): (Stream[T], Stream[T]) = (
    stream.map((p: (T, T)) => p._1),
    stream.map((p: (T, T)) => p._2)
  )
}
