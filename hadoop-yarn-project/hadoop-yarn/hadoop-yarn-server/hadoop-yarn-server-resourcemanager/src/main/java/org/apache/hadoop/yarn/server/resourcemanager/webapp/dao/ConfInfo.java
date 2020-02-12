/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
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
package org.apache.hadoop.yarn.server.resourcemanager.webapp.dao;

import org.apache.hadoop.conf.Configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Map;

@XmlRootElement(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfInfo {

  protected ArrayList<ConfItem> property = new ArrayList<>();

  public ConfInfo() {
  } // JAXB needs this

  public ConfInfo(Configuration conf) {
    for (Map.Entry<String, String> entry : conf) {
      add(new ConfItem(entry.getKey(), entry.getValue()));
    }
  }

  public void add(ConfItem confItem) {
    property.add(confItem);
  }

  public ArrayList<ConfItem> getItems() {
    return property;
  }

  @XmlAccessorType(XmlAccessType.FIELD)
  public static class ConfItem {

    private String name;
    private String value;

    public ConfItem() {
      // JAXB needs this
    }

    public ConfItem(String name, String value){
      this.name = name;
      this.value = value;
    }

    public String getKey() {
      return name;
    }

    public String getValue() {
      return value;
    }
  }
}
