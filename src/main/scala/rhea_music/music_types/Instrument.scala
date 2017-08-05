package rhea_music.music_types

import rhea_music.music_streams.MusicStream

/**
  * @author Orestis Melkonian
  */
class Instrument(instrument: Int) extends Wrapper {

  override def |>(s: String) = "I[" + instrument + "] " + s
  def ||>(s: MusicStream): MusicStream = "I[" + instrument + "] " + s.extractString
}
