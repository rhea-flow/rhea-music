package rhea_music.music_streams

import org.jfugue.pattern.{Pattern, PatternProducer}
import rhea_music.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.music_types.Chord

/**
  * @author Orestis Melkonian
  */
class ChordStream(val stream: Stream[Chord]) {

  /*def setDuration(durationStream: DurationStream): MusicStream = {
    Stream.zip[Chord, String, PatternProducer](
      stream,
      durationStream,
      (c: Chord, d: String) =>
        new Pattern(c.toString + d).asInstanceOf[PatternProducer]: PatternProducer
    )
  }*/
}




