package rhea_music.music_streams

import jm.audio.Instrument
import jm.music.data.Score
import jm.util.{Play, View, Write}
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class ScoreStream(val stream: Stream[Score]) {

  /**
    * Play score using MIDI.
    */
  def play(): Unit =
    stream.subscribe((p: Score) => Play.midi(p))

  /**
    * Play the score on the audio output.
    * @param instruments the instruments to use
    */
  def audio(instruments: Array[Instrument]): Unit =
    stream.subscribe((s: Score) => Play.audio(s, instruments))

  /**
    * Write the score as an audio file.
    */
  def writeAudio(filename: String, instruments: Array[Instrument]): Unit =
    stream.subscribe((s: Score) =>
        Write.au(s, filename, instruments)
    )

  /**
    * Write the score as a midi file.
    */
  def writeMidi(filename: String): Unit =
    stream.subscribe((s: Score) => {
      Write.midi(s, filename)
    })

  /**
    * Display score in musical notation.
    */
  def notate() =
    stream.subscribe((s: Score) =>
      View.notate(s)
    )

}
