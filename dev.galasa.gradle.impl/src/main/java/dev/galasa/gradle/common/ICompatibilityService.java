/*
 * Copyright contributors to the Galasa project
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package dev.galasa.gradle.common;

public interface ICompatibilityService {
    boolean isCurrentVersionLaterThanGradle8();
}
