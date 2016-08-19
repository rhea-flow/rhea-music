package rhea_music.music_types

/**
  * @author Orestis Melkonian
  */

class Tempo(val tempo: Int) extends Wrapper {

  override def |>(s: String) = "T" + tempo + " " + s
}


