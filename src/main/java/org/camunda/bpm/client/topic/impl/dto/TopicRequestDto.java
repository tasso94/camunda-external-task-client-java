/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.client.topic.impl.dto;

import org.camunda.bpm.client.topic.TopicSubscription;

/**
 * @author Tassilo Weidner
 */
public class TopicRequestDto {

  protected String topicName;
  protected long lockDuration;

  public TopicRequestDto(String topicName, long lockDuration) {
    this.topicName = topicName;
    this.lockDuration = lockDuration;
  }

  public String getTopicName() {
    return topicName;
  }

  public long getLockDuration() {
    return lockDuration;
  }
  
  public static TopicRequestDto fromTopicSubscription(TopicSubscription topicSubscription) {
    long lockDuration = topicSubscription.getLockDuration();
    String topicName = topicSubscription.getTopicName();
    return new TopicRequestDto(topicName, lockDuration);
  }

}
