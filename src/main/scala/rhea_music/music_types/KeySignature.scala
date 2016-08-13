package rhea_music.music_types

import rhea_music.util.constants.KeySignatureTypes.KeySignatureType

/**
  * @author Orestis Melkonian
  */
class KeySignature(override val music: MusicString,
                   override val t: KeySignatureType,
                   var note: Note
                  ) extends Wrapper[KeySignatureType](music, t) {

  override def wrap = t => "K" + note + t

}
