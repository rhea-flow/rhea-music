package rhea_music


import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.audio.Instrument
import jm.constants.ProgramChanges._
import jm.music.data.Score
import jm.util.{Play, Write}
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class ScoreStream(stream: Stream[Score]) {

  /**
    * Play part.
    */
  def play(): Unit =
    stream.subscribe((p: Score) => Play.midi(p))

  /**
    * Play the motif on the audio output.
    *
    * @param inst the instrument to use
    */
  def audio(inst: Instrument): Unit =
    stream.subscribe((s: Score) => Play.audio(s, Array(inst)))

  /**
    * Play the motif on the audio output.
    *
    */
  def writeAudio(filename: String, instruments: Array[Instrument]): Unit =
    stream.subscribe(
      (s: Score) => {
        Write.au(s, filename, instruments)
      }
    )

}
