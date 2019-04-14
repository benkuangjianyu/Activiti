/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.spring.boot;

import java.util.List;

import org.activiti.spring.process.ResourceFinderDescriptor;

public class ProcessDefinitionResourceFinder implements ResourceFinderDescriptor {
    
    private ActivitiProperties activitiProperties;
    
    public ProcessDefinitionResourceFinder(ActivitiProperties activitiProperties) {
       this.activitiProperties = activitiProperties;
    }

    @Override
    public List<String> getLocationSuffixes() {
        return activitiProperties.getProcessDefinitionLocationSuffixes();
    }

    @Override
    public String getLocationPrefix() {
        return activitiProperties.getProcessDefinitionLocationPrefix();
    }

    @Override
    public boolean isCheckResources() {
        return activitiProperties.isCheckProcessDefinitions();
    }

    @Override
    public String getMsgForEmptyResources() {
        return "No process definitions were found for auto-deployment in the location";
    }

    @Override
    public String getMsgForResourcesLoadOk() {
        return "The following process definition files will be deployed:";
    }
   
}
