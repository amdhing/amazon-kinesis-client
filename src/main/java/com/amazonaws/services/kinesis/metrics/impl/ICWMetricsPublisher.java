/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates.
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.services.kinesis.metrics.impl;

import java.util.List;

/**
 * An ICWMetricsPublisher is a publisher that contains the logic to publish metrics.
 * 
 * @param <KeyType> is a class that stores information about a MetricDatum. This is useful when wanting
 *        to compare MetricDatums or aggregate similar MetricDatums.
 */

public interface ICWMetricsPublisher<KeyType> {

    /**
     * Given a list of MetricDatumWithKey, this method extracts the MetricDatum from each
     * MetricDatumWithKey and publishes those datums.
     * 
     * @param dataToPublish a list containing all the MetricDatums to publish
     */

    public void publishMetrics(List<MetricDatumWithKey<KeyType>> dataToPublish);
}
