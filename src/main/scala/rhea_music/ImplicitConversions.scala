package rhea_music

import scala.language.implicitConversions
import compose.core.Score
import compose.core.Score.Note
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

  implicit def scorifyStream(st: Stream[Score]): ScoreStream = new ScoreStream(st)
  implicit def _scorifyStream(st: ScoreStream): Stream[Score] = st.stream

  /**
    * Cross-conversion
    */
  implicit def noteToScore(ns: Stream[Note]): ScoreStream = ns.toScore
  implicit def noteToScore2(ns: NoteStream): ScoreStream = ns.toScore
}
