package rhea_music.music_streams

import compose.core.Score
import compose.core.Score.Note
import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import org.rhea_core.Stream
import rhea_music.random.Random._


/**
  * @author Orestis Melkonian
  */
class NoteStream(val stream: Stream[Note]) {

  def toScore: ScoreStream =
    stream.reduce[Score](Score.Empty, (s: Score, n: Note) => s + n : Score)
}

object NoteStream {

  def randNotes: NoteStream =
    Stream.just[Note](randNote).loop(
      (entry: Stream[Note]) => entry.map[Note]((n: Note) => randNote : Note)
    )
}
