package rhea_music.music_types

/**
  * @author Orestis Melkonian
  */
class Instrument(instrument: Int) extends Wrapper {

  override def |>(s: String) = "I[" + instrument + "] " + s
}
