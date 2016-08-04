package rhea_music

import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.audio.Instrument
import jm.music.data.{Note, Part, Phrase, Score}
import jm.util.Play
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PartStream(stream: Stream[Part]) {

  /**
    * @return a Score containing all emitted Parts
    */
  def toScore: Stream[Score] =
    stream.collect[Score](() => new Score(), (s: Score, p: Part) => s.add(p))

  /**
    * Play part.
    */
  def play(): Unit =
    stream.subscribe((p: Part) => Play.midi(p))

  /**
    * Play the motif on the audio output.
    *
    * @param inst the instrument to use
    */
  def audio(inst: Instrument): Unit =
    stream.subscribe((p: Part) => Play.audio(p, Array(inst)))

}
