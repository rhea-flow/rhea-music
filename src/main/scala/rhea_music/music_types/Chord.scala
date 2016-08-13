package rhea_music.music_types

import rhea_music.util.constants.ChordTypes.ChordType

/**
  * @author Orestis Melkonian
  */
class Chord(var note: Note,
            var chordType: ChordType,
            var inversion: Int = 0,
            var bass: Note = null
          ) extends MusicString {

  override def repr: String =
    note + chordType + (
      if (bass != null)
        "^" + bass
      else
        "^" * inversion
    )

}
