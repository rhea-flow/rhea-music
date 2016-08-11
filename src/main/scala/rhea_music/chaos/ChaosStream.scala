package rhea_music.chaos

import org.jfugue.rhythm.Rhythm
import rhea_music.ImplicitConversions._
import org.jfugue.theory.{Chord, Intervals, Note}
import org.rhea_core.Stream
import rhea_music.music_streams.{ChordStream, IntervalsStream, NoteStream, RhythmStream}
import rhea_music.util.mapToArray
import rhea_music.util.constants.Notes.allNotes
import rhea_music.util.constants.Intervals.allIntervals
import rhea_music.util.constants.Chords.allChords
import rhea_music.util.constants.Rhythms.allRhythms

/**
  * @author Orestis Melkonian
  */
class ChaosStream(stream: Stream[Double], range: (Double, Double)) {

  def mapToNotes: NoteStream =
    stream.map[Note]((x: Double) =>
      mapToArray(range._1, range._2, x, allNotes)
    )

  def mapToIntervals: IntervalsStream =
    stream.map[Intervals]((x: Double) =>
      mapToArray(range._1, range._2, x, allIntervals)
    )

  def mapToChords: ChordStream =
    stream.map[Chord]((x: Double) =>
      mapToArray(range._1, range._2, x, allChords)
    )

  def mapToRhythm: RhythmStream =
    stream.map[Rhythm]((x: Double) =>
      new Rhythm().addLayer("" + mapToArray(range._1, range._2, x, allRhythms))
    )
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

  def unzip[T](stream: Stream[(T, T)]): (Stream[T], Stream[T]) = (
    stream.map((p: (T, T)) => p._1),
    stream.map((p: (T, T)) => p._2)
  )
}
