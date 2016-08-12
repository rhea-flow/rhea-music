package rhea_music.music_streams

import org.jfugue.pattern.{Pattern, PatternProducer}
import rhea_music.ImplicitConversions._
import org.jfugue.theory.{Chord, Note}
import org.rhea_core.Stream
import rhea_music.util.random.randChord

/**
  * @author Orestis Melkonian
  */
class ChordStream(val stream: Stream[Chord]) {

  def setDuration(durationStream: DurationStream): PatternStream = {
    Stream.zip[Chord, String, PatternProducer](
      stream,
      durationStream,
      (c: Chord, d: String) =>
        new Pattern(c.toString + d).asInstanceOf[PatternProducer]: PatternProducer
    )
  }
}

object ChordStream {
  def randChords: ChordStream =
    PatternStream.repeatFunc(randChord)
}




