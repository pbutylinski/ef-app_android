package org.eurofurence.connavigator.extensions

/**
 * Infix assertion of equality
 */
infix fun Any?.assert(equalTo: Any?) {
    if (this != equalTo)
        throw AssertionError("$this is supposed to be equal to $equalTo.")
}

/**
 * Infix assertion of inequality
 */
infix fun Any?.assertNot(equalTo: Any?) {
    if (this == equalTo)
        throw AssertionError("$this is supposed to be not equal to $equalTo.")
}