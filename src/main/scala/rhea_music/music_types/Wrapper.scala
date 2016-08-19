package rhea_music.music_types

/**
  * Base class for music structures encapsulating others.
  * @author Orestis Melkonian
  */
trait Wrapper {
  def |>(s: String): String
}
