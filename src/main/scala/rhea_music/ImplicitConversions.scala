package rhea_music

import jm.music.data._
import org.rhea_core.Stream

/**
 * @author Orestis Melkonian
 */
package object ImplicitConversions {

  implicit def notifyStream(st: Stream[Note]): NoteStream = new NoteStream(st)

  implicit def phrasifyStream(st: Stream[Phrase]): PhraseStream = new PhraseStream(st)

  implicit def partifyStream(st: Stream[Part]): PartStream = new PartStream(st)

  implicit def scorifyStream(st: Stream[Score]): ScoreStream = new ScoreStream(st)

}
