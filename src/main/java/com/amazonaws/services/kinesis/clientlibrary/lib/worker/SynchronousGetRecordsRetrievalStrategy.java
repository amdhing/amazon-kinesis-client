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
package com.amazonaws.services.kinesis.clientlibrary.lib.worker;

import com.amazonaws.services.kinesis.model.GetRecordsResult;
import lombok.Data;
import lombok.NonNull;

/**
 *
 */
@Data
public class SynchronousGetRecordsRetrievalStrategy implements GetRecordsRetrievalStrategy {
    @NonNull
    private final KinesisDataFetcher dataFetcher;

    @Override
    public GetRecordsResult getRecords(final int maxRecords) {
        return dataFetcher.getRecords(maxRecords).accept();
    }

    @Override
    public void shutdown() {
        //
        // Does nothing as this retriever doesn't manage any resources
        //
    }

    @Override
    public boolean isShutdown() {
        return false;
    }
    
    @Override
    public KinesisDataFetcher getDataFetcher() {
        return dataFetcher;
    }
}
