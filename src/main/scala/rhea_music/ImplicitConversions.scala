package rhea_music

import org.jfugue.pattern.Pattern
import org.rhea_core.Stream
import rhea_music.music_streams._
import rhea_music.music_types.MusicString
import rhea_music.util.RichArray

/**
 * @author Orestis Melkonian
 */
package object ImplicitConversions {

  implicit def stringToMusic(s: String): MusicString = new MusicString {override def repr: String = s}
  implicit def _stringToMusic(s: MusicString): String = s.repr

  implicit def stringToPattern(s: String): Pattern = new Pattern(s)
  implicit def msToPattern(ms: MusicString): Pattern = new Pattern(ms.repr)

  implicit def musicStream[T <: MusicString](s: Stream[T]): MusicStream = new MusicStream(s)

  // RichArrays
  implicit def enrichArray[T](a: Array[T]): RichArray[T] = new RichArray[T](a)
  implicit def _enrichArray[T](a: RichArray[T]): Array[T] = a.array

  /*// Notes
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

  implicit def charToRhythm(st: Stream[Char]): RhythmStream =
    new RhythmStream(st.map[Rhythm]((c: Char) => new Rhythm().addLayer(c.toString)))

  // Durations
  implicit def durifyStream(st: Stream[String]): DurationStream = new DurationStream(st)
  implicit def _durifyStream(st: DurationStream): Stream[String] = st.stream

  // Patterns
  implicit def patternifyStream(st: Stream[PatternProducer]): MusicStream = new MusicStream(st)
  implicit def _patternifyStream(st: MusicStream): Stream[PatternProducer] = st.stream

  implicit def noteToPat(st: NoteStream): MusicStream =
    new MusicStream(st.map((n: Note) => n.asInstanceOf[PatternProducer]))

  implicit def intervalToPat(st: IntervalsStream): MusicStream =
    new MusicStream(st.map((n: Intervals) => n.asInstanceOf[PatternProducer]))

  implicit def chordToPat(st: ChordStream): MusicStream =
    new MusicStream(st.map((n: Chord) => n.asInstanceOf[PatternProducer]))

  implicit def rhythmToPat(st: RhythmStream): MusicStream =
    new MusicStream(st.map((n: Rhythm) => n.asInstanceOf[PatternProducer]))

  implicit def charToPat(st: Stream[Char]): MusicStream =
    new MusicStream(charToRhythm(st).map((n: Rhythm) => n.asInstanceOf[PatternProducer]))
*/
}
