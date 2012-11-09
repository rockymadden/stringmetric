package org.hashtree.stringmetric

import org.hashtree.stringmetric.phonetic.{ MetaphoneAlgorithm, NysiisAlgorithm, RefinedSoundexAlgorithm, SoundexAlgorithm }
import org.hashtree.stringmetric.similarity.NGramAlgorithm

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Algorithm]]. */
trait StringAlgorithm extends Algorithm[String] {

}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringAlgorithm]]. */
object StringAlgorithm {
	def computeMetaphone(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] =
		MetaphoneAlgorithm.compute(charArray)(stringFilter)

	def computeMetaphone(string: String)(implicit stringFilter: StringFilter): Option[String] =
		MetaphoneAlgorithm.compute(string)(stringFilter)

	def computeNGram(charArray: Array[Char])(n: Int)(implicit stringFilter: StringFilter): Option[Array[Array[Char]]] =
		NGramAlgorithm.compute(charArray)(n)(stringFilter)

	def computeNGram(string: String)(n: Int)(implicit stringFilter: StringFilter): Option[Array[String]] =
		NGramAlgorithm.compute(string)(n)(stringFilter)

	def computeNysiis(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] =
		NysiisAlgorithm.compute(charArray)(stringFilter)

	def computeNysiis(string: String)(implicit stringFilter: StringFilter): Option[String] =
		NysiisAlgorithm.compute(string)(stringFilter)

	def computeRefinedSoundex(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] =
		RefinedSoundexAlgorithm.compute(charArray)(stringFilter)

	def computeRefinedSoundex(string: String)(implicit stringFilter: StringFilter): Option[String] =
		RefinedSoundexAlgorithm.compute(string)(stringFilter)

	def computeSoundex(charArray: Array[Char])(implicit stringFilter: StringFilter): Option[Array[Char]] =
		SoundexAlgorithm.compute(charArray)(stringFilter)

	def computeSoundex(string: String)(implicit stringFilter: StringFilter): Option[String] =
		SoundexAlgorithm.compute(string)(stringFilter)

	def metaphone: MetaphoneAlgorithm.type = MetaphoneAlgorithm

	def nGram: NGramAlgorithm.type = NGramAlgorithm

	def nysiis: NysiisAlgorithm.type = NysiisAlgorithm

	def refinedSoundex: RefinedSoundexAlgorithm.type = RefinedSoundexAlgorithm

	def soundex: SoundexAlgorithm.type = SoundexAlgorithm
}