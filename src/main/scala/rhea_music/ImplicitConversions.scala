package rhea_music

import org.jfugue.theory.Note
import org.rhea_core.Stream
import rhea_music.music_streams._

/**
 * @author Orestis Melkonian
 */
package object ImplicitConversions {

  /**
    * Musical structures
    */

  implicit def notifyStream(st: Stream[Note]): NoteStream = new NoteStream(st)
  implicit def _notifyStream(st: NoteStream): Stream[Note] = st.stream

}
