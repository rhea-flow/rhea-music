package rhea_music.music_types

import rhea_music.constants.KeySignatureTypes.KeySignatureType

/**
  * @author Orestis Melkonian
  */
class KeySignature(val key: KeySignatureType, var tone: Tone) extends Wrapper{

  override def |>(s: String) = "K" + tone.repr + key + " " + s
}
