package rhea_music.music_streams

import scala_wrapper.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.music.data.{CPhrase, Part}
import org.rhea_core.Stream

/**
  * @author Orestis Melkonian
  */
class CPhraseStream(val stream: Stream[CPhrase]) {

  /**
    * @return the chords as an instrument part
    */
  def toPart: Stream[Part] =
    stream.collect[Part](() => new Part("Piano",0,0), (p: Part, c: CPhrase) => {
      c.setAppend(true)
      p.addCPhrase(c)
    })
  
  def setRhythm(rhythm: Stream[Double]): CPhraseStream =
    Stream.zip[Double, CPhrase, CPhrase](rhythm, stream, (r: Double, c: CPhrase) => {
      c.setRhythmValue(r.toInt)
      c
    }: CPhrase)

}
