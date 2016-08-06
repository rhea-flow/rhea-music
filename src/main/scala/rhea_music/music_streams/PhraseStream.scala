package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import jm.audio.Instrument
import jm.music.data.{Part, Phrase}
import jm.util.Play
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PhraseStream(val stream: Stream[Phrase]) {

  /**
    * @return the motif as a instrument part
    */
  def toPart: Stream[Part] =
    stream.map[Part]((p: Phrase) => new Part(p))

  /**
    * @param instr the instrument to use
    * @return the motif as a instrument part
    */
  def toPart(instr: Int): Stream[Part] =
    stream.map[Part]((p: Phrase) => new Part("intst" + instr, instr, p))

}
