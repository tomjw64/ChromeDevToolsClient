package com.hubspot.chrome.devtools.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.PACKAGE, ElementType.TYPE })
@Retention(RetentionPolicy.CLASS) // Make it class retention for incremental compilation
@JsonSerialize
@Value.Style(
  get = { "is*", "get*" }, // Detect 'get' and 'is' prefixes in accessor methods
  init = "set*", // Builder initialization methods will have 'set' prefix
  typeAbstract = { "Abstract*", "*IF" }, // 'Abstract' prefix, and 'IF' suffix, will be detected and trimmed
  typeImmutable = "*", // No prefix or suffix for generated immutable type
  optionalAcceptNullable = true, // allow for an Optional<T> to have a setter that takes a null value of T
  visibility = ImplementationVisibility.SAME, // Generated class will have the same visibility as the abstract class/interface)
  jdkOnly = true // For Guava 18+, this stops MoreObjects from being used in toString and ImmutableHashMap.Builder from being used for building map fields (among other effects).
)
public @interface ChromeStyle {
}
