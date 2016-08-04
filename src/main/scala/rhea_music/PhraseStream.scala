package rhea_music

import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.audio.Instrument
import jm.music.data.{Part, Phrase}
import jm.util.Play
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PhraseStream(stream: Stream[Phrase]) {

  /**
    * @param instr the instrument to use
    * @return the motif as a instrument part
    */
  def toPart(instr: Int): Stream[Part] =
    stream.map[Part]((p: Phrase) => new Part("intst" + instr, instr, p))

  /**
    * Play part.
    */
  def play(): Unit =
    stream.subscribe((p: Phrase) => Play.midi(p))

  /**
    * Play the motif on the audio output.
    *
    * @param inst the instrument to use
    */
  def audio(inst: Instrument): Unit =
    stream.subscribe((p: Phrase) => Play.audio(p, Array(inst)))

}
