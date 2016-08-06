package rhea_music

import jm.music.data._
import org.rhea_core.Stream
import rhea_music.chaos.ChaosStream
import rhea_music.music_streams.{NoteStream, PartStream, PhraseStream, ScoreStream}

/**
 * @author Orestis Melkonian
 */
package object ImplicitConversions {

  /**
    * Musical structures
    */

  implicit def notifyStream(st: Stream[Note]): NoteStream = new NoteStream(st)
  implicit def _notifyStream(st: NoteStream): Stream[Note] = st.stream

  implicit def phrasifyStream(st: Stream[Phrase]): PhraseStream = new PhraseStream(st)
  implicit def _phrasifyStream(st: PhraseStream): Stream[Phrase] = st.stream

  implicit def partifyStream(st: Stream[Part]): PartStream = new PartStream(st)
  implicit def _partifyStream(st: PartStream): Stream[Part] = st.stream

  implicit def scorifyStream(st: Stream[Score]): ScoreStream = new ScoreStream(st)
  implicit def _scorifyStream(st: ScoreStream): Stream[Score] = st.stream

  // Cross-conversion
  implicit def noteToPhrase(st: NoteStream): PhraseStream = st.toPhrase
  implicit def noteToPart(st: NoteStream): PartStream = st.toPhrase.toPart
  implicit def noteToScore(st: NoteStream): ScoreStream = st.toPhrase.toPart.toScore

  implicit def noteToPhrase2(st: Stream[Note]): PhraseStream = st.toPhrase
  implicit def noteToPart2(st: Stream[Note]): PartStream = st.toPhrase.toPart
  implicit def noteToScore2(st: Stream[Note]): ScoreStream = st.toPhrase.toPart.toScore

  implicit def phraseToPart(st: PhraseStream): PartStream = st.toPart
  implicit def phraseToScore(st: PhraseStream): ScoreStream = st.toPart.toScore

  implicit def phraseToPart2(st: Stream[Phrase]): PartStream = st.toPart
  implicit def phraseToScore2(st: Stream[Phrase]): ScoreStream = st.toPart.toScore

  implicit def partToScore(st: PartStream): ScoreStream = st.toScore
  implicit def partToScore2(st: Stream[Part]): ScoreStream = st.toScore

  /**
    * Chaos
    */

//  implicit def chaotifyStream(st: Stream[Double]): ChaosStream = new ChaosStream(st)
}
