package rhea_music.music_streams

import rhea_music.util.ImplicitConversions._

import scala_wrapper.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.constants.Chords
import rhea_music.constants.Durations.Duration
import rhea_music.music_types.{Chord, MusicString}

/**
  * @author Orestis Melkonian
  */
class ChordStream(val stream: Stream[Chord]) extends MusicStream(stream) {

  def setDuration(durationStream: DurationStream): ChordStream =
    Stream.zip[Chord, Duration, Chord](
      stream,
      durationStream,
      (c: Chord, d: Duration) => {
        c.duration = d
        c
      }
    )
}




