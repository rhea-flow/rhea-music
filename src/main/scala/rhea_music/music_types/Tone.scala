package rhea_music.music_types

import rhea_music.constants.NoteMods.{NoteMod, noNoteMod, n}

/**
  * @author Orestis Melkonian
  */
class Tone(var base: Char = 'C',
           var mod: NoteMod = noNoteMod
          ) extends MusicString {

  override var repr: String = base + mod

  override def equals(o: Any) = o match {
    case that: Tone => (base == that.base) && (mod == that.mod)
    case _ => false
  }

  def clear() = {
    if (mod == n)
      mod = noNoteMod
  }


}


