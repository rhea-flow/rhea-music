package rhea_music

import org.jfugue.pattern.PatternProducer
import org.jfugue.rhythm.Rhythm
import org.jfugue.theory.{Chord, Intervals, Note}
import org.rhea_core.Stream
import rhea_music.music_streams._

/**
 * @author Orestis Melkonian
 */
package object ImplicitConversions {

  // Notes
  implicit def notifyStream(st: Stream[Note]): NoteStream = new NoteStream(st)
  implicit def _notifyStream(st: NoteStream): Stream[Note] = st.stream

  // Intervals
  implicit def intervalifyStream(st: Stream[Intervals]): IntervalsStream = new IntervalsStream(st)
  implicit def _intervalifyStream(st: IntervalsStream): Stream[Intervals] = st.stream

  // Chords
  implicit def chordifyStream(st: Stream[Chord]): ChordStream = new ChordStream(st)
  implicit def _chordifyStream(st: ChordStream): Stream[Chord] = st.stream

  // Rhythms
  implicit def rhythmifyStream(st: Stream[Rhythm]): RhythmStream = new RhythmStream(st)
  implicit def _rhythmifyStream(st: RhythmStream): Stream[Rhythm] = st.stream

  // Durations
  implicit def durifyStream(st: Stream[String]): DurationStream = new DurationStream(st)
  implicit def _durifyStream(st: DurationStream): Stream[String] = st.stream

  // Patterns
  implicit def patternifyStream(st: Stream[PatternProducer]): PatternStream = new PatternStream(st)
  implicit def _patternifyStream(st: PatternStream): Stream[PatternProducer] = st.stream

  implicit def noteToPat(st: NoteStream): PatternStream =
    new PatternStream(st.map((n: Note) => n.asInstanceOf[PatternProducer]))

  implicit def intervalToPat(st: IntervalsStream): PatternStream =
    new PatternStream(st.map((n: Intervals) => n.asInstanceOf[PatternProducer]))

  implicit def chordToPat(st: ChordStream): PatternStream =
    new PatternStream(st.map((n: Chord) => n.asInstanceOf[PatternProducer]))

  implicit def rhythmToPat(st: RhythmStream): PatternStream =
    new PatternStream(st.map((n: Rhythm) => n.asInstanceOf[PatternProducer]))

}
