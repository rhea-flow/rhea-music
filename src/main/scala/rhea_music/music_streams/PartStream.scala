package rhea_music.music_streams

import rhea_music.ImplicitConversions._

import jm.audio.Instrument
import jm.music.data.{Part, Score}
import jm.util.Play
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class PartStream(val stream: Stream[Part]) {

  /**
    * @return a Score containing all emitted Parts
    */
  def toScore: ScoreStream =
    stream.collect[Score](() => new Score(), (s: Score, p: Part) => s.add(p))

}
