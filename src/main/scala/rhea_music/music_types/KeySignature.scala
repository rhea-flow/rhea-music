package rhea_music.music_types

import rhea_music.constants.KeySignatureTypes.KeySignatureType

/**
  * @author Orestis Melkonian
  */
class KeySignature(override val t: KeySignatureType, var note: Note)
  extends Wrapper[KeySignatureType](t) {

  override def wrap = t => "K" + note + t
}
