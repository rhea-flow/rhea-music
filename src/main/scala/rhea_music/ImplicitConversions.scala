package rhea_music

import jm.music.data._
import jm.music.tools.ca.CellularAutomata
import org.rhea_core.Stream
import rhea_music.cellular_automata.CAStream
import rhea_music.chaos.ChaosStream
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

  implicit def phrasifyStream(st: Stream[Phrase]): PhraseStream = new PhraseStream(st)
  implicit def _phrasifyStream(st: PhraseStream): Stream[Phrase] = st.stream

  implicit def cphrasifyStream(st: Stream[CPhrase]): CPhraseStream = new CPhraseStream(st)
  implicit def _cphrasifyStream(st: CPhraseStream): Stream[CPhrase] = st.stream

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

  implicit def cphraseToPart(st: CPhraseStream): PartStream = st.toPart
  implicit def cphraseToScore(st: CPhraseStream): ScoreStream = st.toPart.toScore

  implicit def cphraseToPart2(st: Stream[CPhrase]): PartStream = st.toPart
  implicit def cphraseToScore2(st: Stream[CPhrase]): ScoreStream = st.toPart.toScore

  implicit def partToScore(st: PartStream): ScoreStream = st.toScore
  implicit def partToScore2(st: Stream[Part]): ScoreStream = st.toScore


  /**
    * Chaos
    */

//  implicit def chaotifyStream(st: Stream[Double]): ChaosStream = new ChaosStream(st)

  /**
    * Cellular Automata
    */

  implicit def stToCa(stream: Stream[CellularAutomata]): CAStream = new CAStream(stream)
  implicit def _stToCa(ca: CAStream): Stream[CellularAutomata] = ca.stream
}
