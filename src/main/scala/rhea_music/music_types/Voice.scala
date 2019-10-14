package rhea_music.music_types

import org.rhea_core.Stream
import rhea_music.music_streams.MusicStream
import rhea_music.util.ImplicitConversions._

/**
  * @author Orestis Melkonian
  */

class Voice(val voice: Int) extends MusicString with Wrapper {

  override def |>(s: String) = repr + " " + s

  def ||>(s: MusicStream): MusicStream = Stream.concat(Stream.just(this), s)

  override var repr: String = "V" + voice
}
