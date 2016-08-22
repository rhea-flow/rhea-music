package rhea_music.music_streams

import rhea_music.util.ImplicitConversions._
import rhea_music.util.Random.randNote
import org.rhea_core.Stream
import rhea_music.constants.Durations.Duration
import rhea_music.music_types.Note

/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

  def setDuration(durationStream: DurationStream): NoteStream =
    Stream.zip[Note, Duration, Note](
      stream, durationStream,
      (n: Note, d: Duration) => n.clone(duration = d)
    )
}

object NoteStream {

  def randNotes: NoteStream =
    MusicStream.repeatFunc(randNote)
}
