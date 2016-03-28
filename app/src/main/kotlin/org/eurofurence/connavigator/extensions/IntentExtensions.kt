package org.eurofurence.connavigator.extensions

import android.content.Intent
import java.io.Serializable

/**
 * Checks if the intent has the given extra defined.
 */
infix fun Intent.has(key: String) = this.hasExtra(key)

/**
 * Gets the corresponding string extra or null if not present.
 */
operator fun Intent.get(key: String) = if (this has key) this.getStringExtra(key) else null

/**
 * Puts a string into the intent or removes it if null specified
 */
operator fun Intent.set(key: String, value: String?) {
    if (value == null)
        this.removeExtra(key)
    else
        this.putExtra(key, value)
}

/**
 * Sets the context to booleans, [get] will return a boolean.
 */
val Intent.booleans: IntentContextBoolean
    get() = IntentContextBoolean(this)

class IntentContextBoolean(val intent: Intent) {
    /**
     * Gets the corresponding boolean extra or null if not present.
     */
    operator fun get(key: String) = intent.getBooleanExtra(key, false)

    /**
     * Puts a boolean into the intent or removes it if null specified
     */
    operator fun set(key: String, value: Boolean?) {
        if (value == null)
            intent.removeExtra(key)
        else
            intent.putExtra(key, value)
    }
}


/**
 * Sets the context to booleans, [get] will return an integer
 */
val Intent.ints: IntentContextInt
    get() = IntentContextInt(this)

class IntentContextInt(val intent: Intent) {
    /**
     * Gets the corresponding integer extra or null if not present.
     */
    operator fun get(key: String) = if (intent has key) intent.getIntExtra(key, 0) else null

    /**
     * Puts an integer into the intent or removes it if null specified
     */
    operator fun set(key: String, value: Int?) {
        if (value == null)
            intent.removeExtra(key)
        else
            intent.putExtra(key, value)
    }
}

/**
 * Sets the context to booleans, [get] will return a float.
 */
val Intent.floats: IntentContextFloat
    get() = IntentContextFloat(this)

class IntentContextFloat(val intent: Intent) {
    /**
     * Gets the corresponding float extra or null if not present.
     */
    operator fun get(key: String) = if (intent has key) intent.getFloatExtra(key, 0.0f) else null

    /**
     * Puts a float into the intent or removes it if null specified
     */
    operator fun set(key: String, value: Float?) {
        if (value == null)
            intent.removeExtra(key)
        else
            intent.putExtra(key, value)
    }
}

/**
 * Sets the context to booleans, [get] will return a double.
 */
val Intent.doubles: IntentContextDouble
    get() = IntentContextDouble(this)

class IntentContextDouble(val intent: Intent) {
    /**
     * Gets the corresponding double extra or null if not present.
     */
    operator fun get(key: String) = if (intent has key) intent.getDoubleExtra(key, 0.0) else null

    /**
     * Puts a double into the intent or removes it if null specified
     */
    operator fun set(key: String, value: Double?) {
        if (value == null)
            intent.removeExtra(key)
        else
            intent.putExtra(key, value)
    }
}

/**
 * Sets the context to booleans, [get] will return a object, they need to be serializable, however.
 */
val Intent.objects: IntentContextObjects
    get() = IntentContextObjects(this)

class IntentContextObjects(val intent: Intent) {
    /**
     * Gets the corresponding object extra or null if not present.
     */
    operator fun get(key: String) = if (intent has key) intent.getSerializableExtra(key) else null

    /**
     * Gets the corresponding object extra or null if not present.
     */
    operator fun <T : Serializable> get(key: String, classOfT: Class<T>) = get(key).let {
        if (classOfT.isInstance(it))
            classOfT.cast(it)
        else null
    }

    /**
     * Puts a serializable into the intent or removes it if null specified
     */
    operator fun set(key: String, value: Serializable?) {
        if (value == null)
            intent.removeExtra(key)
        else
            intent.putExtra(key, value)
    }
}