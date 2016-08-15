package rhea_music.music_types

import rhea_music.constants.NoteMods.{NoteMod, noNoteMod, n}

/**
  * @author Orestis Melkonian
  */
class Tone(var base: Char = 'C',
           var mod: NoteMod = noNoteMod
          ) extends MusicString {

  override var repr: String = base + mod

  def clear() = {
    if (mod == n)
      mod = noNoteMod
  }


}


