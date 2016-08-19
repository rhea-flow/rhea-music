package rhea_music.music_types


/**
  * @author Orestis Melkonian
  */

class Voice(val voice: Int) extends Wrapper {

  override def |>(s: String) = "V" + voice + " " + s
}