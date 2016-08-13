package rhea_music.music_types

/**
  * @author Orestis Melkonian
  */
class Measure(val music: MusicString*) extends MusicString {

  override def repr: String = music.map(_.repr).mkString(" | ")

  def +(that: Measure): Measure =
    new Measure(this.music ++ that.music:_*)
}
