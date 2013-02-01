package com.rockymadden.stringmetric

import com.rockymadden.stringmetric.phonetic.{ MetaphoneAlgorithm, NysiisAlgorithm, RefinedSoundexAlgorithm, SoundexAlgorithm }
import com.rockymadden.stringmetric.similarity.NGramAlgorithm

/** Trait for all string based [[com.rockymadden.stringmetric.Algorithm]]. */
trait StringAlgorithm extends Algorithm[String]

/** Standalone convenience object for all extending [[com.rockymadden.stringmetric.StringAlgorithm]]. */
object StringAlgorithm {
	def computeWithMetaphone(charArray: Array[Char])
		(implicit stringFilter: StringFilter): Option[Array[Char]] =

		MetaphoneAlgorithm.compute(charArray)(stringFilter)

	def computeWithMetaphone(string: String)
		(implicit stringFilter: StringFilter): Option[MetaphoneAlgorithm.ComputeReturn] =

		MetaphoneAlgorithm.compute(string)(stringFilter)

	def computeWithNGram(charArray: Array[Char])(n: Int)
		(implicit stringFilter: StringFilter): Option[Array[Array[Char]]] =

		NGramAlgorithm.compute(charArray)(n)(stringFilter)

	def computeWithNGram(string: String)(n: Int)
		(implicit stringFilter: StringFilter): Option[NGramAlgorithm.ComputeReturn] =

		NGramAlgorithm.compute(string)(n)(stringFilter)

	def computeWithNysiis(charArray: Array[Char])
		(implicit stringFilter: StringFilter): Option[Array[Char]] =

		NysiisAlgorithm.compute(charArray)(stringFilter)

	def computeWithNysiis(string: String)
		(implicit stringFilter: StringFilter): Option[NysiisAlgorithm.ComputeReturn] =

		NysiisAlgorithm.compute(string)(stringFilter)

	def computeWithRefinedSoundex(charArray: Array[Char])
		(implicit stringFilter: StringFilter): Option[Array[Char]] =

		RefinedSoundexAlgorithm.compute(charArray)(stringFilter)

	def computeWithRefinedSoundex(string: String)
		(implicit stringFilter: StringFilter): Option[RefinedSoundexAlgorithm.ComputeReturn] =

		RefinedSoundexAlgorithm.compute(string)(stringFilter)

	def computeWithSoundex(charArray: Array[Char])
		(implicit stringFilter: StringFilter): Option[Array[Char]] =

		SoundexAlgorithm.compute(charArray)(stringFilter)

	def computeWithSoundex(string: String)
		(implicit stringFilter: StringFilter): Option[SoundexAlgorithm.ComputeReturn] =

		SoundexAlgorithm.compute(string)(stringFilter)

	def metaphone: MetaphoneAlgorithm.type = MetaphoneAlgorithm

	def nGram: NGramAlgorithm.type = NGramAlgorithm

	def nysiis: NysiisAlgorithm.type = NysiisAlgorithm

	def refinedSoundex: RefinedSoundexAlgorithm.type = RefinedSoundexAlgorithm

	def soundex: SoundexAlgorithm.type = SoundexAlgorithm
}
