/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.orca.clouddriver.tasks.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.spinnaker.orca.api.pipeline.RetryableTask;
import com.netflix.spinnaker.orca.api.pipeline.TaskResult;
import com.netflix.spinnaker.orca.api.pipeline.models.StageExecution;
import com.netflix.spinnaker.orca.clouddriver.CloudDriverCacheService;
import com.netflix.spinnaker.orca.clouddriver.tasks.AbstractCloudProviderAwareTask;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageForceCacheRefreshTask extends AbstractCloudProviderAwareTask
    implements RetryableTask {
  static final String REFRESH_TYPE = "Image";

  @Autowired CloudDriverCacheService cacheService;

  @Autowired ObjectMapper objectMapper;

  @Override
  public TaskResult execute(StageExecution stage) {
    //    TODO-AJ Support force cache refresh for 'Image' (clouddriver-aws)
    //    TODO (duftler): Support force cache refresh for 'Image' (clouddriver-google)
    //    String cloudProvider = getCloudProvider(stage)
    //
    //    stage.context.targets.each { Map target ->
    //      cacheService.forceCacheUpdate(
    //        cloudProvider, REFRESH_TYPE, [account: target.account, imageName: target.imageName,
    // region: target.region]
    //      )
    //    }

    return TaskResult.SUCCEEDED;
  }

  @Override
  public long getBackoffPeriod() {
    return TimeUnit.SECONDS.toMillis(5);
  }

  @Override
  public long getTimeout() {
    return TimeUnit.MINUTES.toMillis(5);
  }
}
