package org.hashtree.stringmetric

import org.hashtree.stringmetric.phonetic.{ MetaphoneAlgorithm, NysiisAlgorithm, RefinedSoundexAlgorithm, SoundexAlgorithm }

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Algorithm]]. */
trait StringAlgorithm extends Algorithm[String, StringFilter] {
	def compute(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]]
}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringAlgorithm]]. */
object StringAlgorithm {
	def computeMetaphone(charArray: Array[Char]): Option[Array[Char]] = MetaphoneAlgorithm.compute(charArray)

	def computeMetaphone(string: String): Option[String] = MetaphoneAlgorithm.compute(string)

	def computeNysiis(charArray: Array[Char]): Option[Array[Char]] = NysiisAlgorithm.compute(charArray)

	def computeNysiis(string: String): Option[String] = NysiisAlgorithm.compute(string)

	def computeRefinedSoundex(charArray: Array[Char]): Option[Array[Char]] = RefinedSoundexAlgorithm.compute(charArray)

	def computeRefinedSoundex(string: String): Option[String] = RefinedSoundexAlgorithm.compute(string)

	def computeSoundex(charArray: Array[Char]): Option[Array[Char]] = SoundexAlgorithm.compute(charArray)

	def computeSoundex(string: String): Option[String] = SoundexAlgorithm.compute(string)

	def metaphone: MetaphoneAlgorithm.type = MetaphoneAlgorithm

	def nysiis: NysiisAlgorithm.type = NysiisAlgorithm

	def refinedSoundex: RefinedSoundexAlgorithm.type = RefinedSoundexAlgorithm

	def soundex: SoundexAlgorithm.type = SoundexAlgorithm
}