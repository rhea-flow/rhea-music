package rhea_music.music_streams

import rhea_music.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.constants.Durations.Duration
import rhea_music.music_types.Note

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

  def setDuration(durationStream: DurationStream): MusicStream = {
    Stream.zip[Note, Duration, Note](
      stream,
      durationStream,
      (n: Note, d: Duration) => {
        n.duration = d
        n
      }
    )
  }
}

object NoteStream {

//  def randNotes: NoteStream =
//    MusicStream.repeatFunc(randNote)
}
