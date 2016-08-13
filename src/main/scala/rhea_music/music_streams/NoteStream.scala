package rhea_music.music_streams

import org.jfugue.pattern.{Pattern, PatternProducer}
import rhea_music.ImplicitConversions._
import org.jfugue.theory.Note
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

  /*def setDuration(durationStream: DurationStream): MusicStream = {
    Stream.zip[Note, String, PatternProducer](
      stream,
      durationStream,
      (n: Note, d: String) =>
        new Pattern(n.originalString + d).asInstanceOf[PatternProducer]: PatternProducer
    )
  }*/
}

object NoteStream {

  /*def randNotes: NoteStream =
    MusicStream.repeatFunc(randNote)*/
}
