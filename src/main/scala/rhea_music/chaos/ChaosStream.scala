package rhea_music.chaos

import rhea_music.util.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.music_streams._
import rhea_music.chaos.ChaoticSystem.Range
import rhea_music.util.mapToArray
import rhea_music.constants.Notes.allNotes
import rhea_music.constants.Intervals.allIntervals
import rhea_music.constants.Durations.allDurations
import rhea_music.constants.Chords.allChords
import rhea_music.music_types.{Chord, Interval, Note}

import scala.collection.mutable.ArrayBuffer

/**
  * @author Orestis Melkonian
  */
class ChaosStream(stream: Stream[Double], range: Range) extends Stream[Double](stream.getGraph, stream.getToConnect) {

  override def print() = stream.toBlocking.toList.forEach(println)

  def mapTo[T](array: Array[T]): Stream[T] =
    stream.map[T](mapToArray(range._1, range._2, _, array))

  def mapToNotes: NoteStream =
    mapTo[Note](allNotes)

  def mapToIntervals: IntervalStream =
    mapTo[Interval](allIntervals)

  def mapToChords: ChordStream =
    mapTo[Chord](allChords)

  def mapToDuration: DurationStream =
    mapTo[String](allDurations)

  /*def mapToRhythm: RhythmStream =
  mapTo[Char](allRhythms)*/
}

object ChaosStream {

  def from(cs: ChaoticSystem, N: Int): Array[ChaosStream] = {
    val ret = new ArrayBuffer[ChaosStream]()
    val streams = Stream.just(cs.init).loopN(
      entry => entry.map(cs),
      N
    )
    val s = unzip[Double](streams, cs.arguments)
    val r = cs.range(N)
    assert(s.length == r.length)
    for (i <- s.indices)
      ret += new ChaosStream(stream = s(i), range = r(i))
    ret toArray
  }

  def unzip[T](stream: Stream[Array[T]], length: Int): Array[Stream[T]] = {
    var ret = new ArrayBuffer[Stream[T]]
    for (i <- 0 until length)
      ret += stream.copy().map((p: Array[T]) => p(i))
    ret toArray
  }

  /*def chaoticMelody(N: Int): MusicStream = {
    val (s1, s2) = from(ComplexFunction.f3(1.4, 0.3), N)
    s1.mapToNotes.setDuration(s2.mapToDuration)
  }

  def chaoticHarmony(N: Int): MusicStream = {
    val (s1, s2) = from(ComplexFunction.f3(1.4, 0.3), N)
    s1.mapToChords.setDuration(s2.mapToDuration)
  }*/
}
