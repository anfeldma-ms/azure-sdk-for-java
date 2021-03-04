// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.iot.deviceupdate.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for DeviceState. */
public final class DeviceState extends ExpandableStringEnum<DeviceState> {
    /** Static value NotStarted for DeviceState. */
    public static final DeviceState NOT_STARTED = fromString("NotStarted");

    /** Static value Incompatible for DeviceState. */
    public static final DeviceState INCOMPATIBLE = fromString("Incompatible");

    /** Static value AlreadyInDeployment for DeviceState. */
    public static final DeviceState ALREADY_IN_DEPLOYMENT = fromString("AlreadyInDeployment");

    /** Static value Canceled for DeviceState. */
    public static final DeviceState CANCELED = fromString("Canceled");

    /** Static value InProgress for DeviceState. */
    public static final DeviceState IN_PROGRESS = fromString("InProgress");

    /** Static value Failed for DeviceState. */
    public static final DeviceState FAILED = fromString("Failed");

    /** Static value Succeeded for DeviceState. */
    public static final DeviceState SUCCEEDED = fromString("Succeeded");

    /**
     * Creates or finds a DeviceState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding DeviceState.
     */
    @JsonCreator
    public static DeviceState fromString(String name) {
        return fromString(name, DeviceState.class);
    }

    /** @return known DeviceState values. */
    public static Collection<DeviceState> values() {
        return values(DeviceState.class);
    }
}
