package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import org.jfugue.theory.Note
import org.rhea_core.Stream
import rhea_music.util.random._

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {
}

object NoteStream {

  def randNotes: NoteStream =
    PatternStream.repeatFunc(randNote)
}
