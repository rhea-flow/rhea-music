package rhea_music.music_types


/**
  * @author Orestis Melkonian
  */

class Voice(val voice: Int) extends MusicString with Wrapper {

  override def |>(s: String) = "V" + voice + " " + s

  override var repr: String = "V" + voice
}