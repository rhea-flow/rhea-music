package rhea_music.music_types

import rhea_music.constants.KeySignatureTypes.KeySignatureType

/**
  * @author Orestis Melkonian
  */
class KeySignature(override val t: KeySignatureType, var tone: Tone)
  extends Wrapper[KeySignatureType](t) {

  override def wrap = sth => "K" + tone.repr + t + " " + sth
}
