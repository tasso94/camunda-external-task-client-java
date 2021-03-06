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
package org.camunda.bpm.client.impl.variable.mapper;

import org.camunda.bpm.client.impl.EngineClientException;
import org.camunda.bpm.client.task.impl.dto.TypedValueDto;
import org.camunda.bpm.engine.variable.type.ValueType;
import org.camunda.bpm.engine.variable.value.TypedValue;

/**
 * @author Tassilo Weidner
 */
public interface ValueMapper<T extends TypedValue> {

  String getTypeName();

  T deserializeTypedValue(TypedValueDto typedValueDto) throws EngineClientException;

  default TypedValueDto serializeTypedValue(TypedValue typedValue) {
    TypedValueDto typedValueDto = new TypedValueDto();

    ValueType valueType = typedValue.getType();
    typedValueDto.setValueInfo(valueType.getValueInfo(typedValue));

    String typeName = valueType.getName();
    String typeNameCapitalized = Character.toUpperCase(typeName.charAt(0)) + typeName.substring(1);
    typedValueDto.setType(typeNameCapitalized);

    typedValueDto.setValue(typedValue.getValue());

    return typedValueDto;
  }

}
