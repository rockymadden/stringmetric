package com.rockymadden.stringmetric

/**
 * Provides core CLI functionality. Note that some things might look sloppy (e.g. access modifiers, broad imports,
 * repetitive imports, etc), but are required because of the way scalascript is ultimately compiled.
 */
package object cli {
	type OptionMap = Map[Symbol, String]
}