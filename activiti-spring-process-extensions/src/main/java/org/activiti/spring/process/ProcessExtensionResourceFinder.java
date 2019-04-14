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

package org.activiti.spring.process;

import java.util.ArrayList;
import java.util.List;

public class ProcessExtensionResourceFinder implements ResourceFinderDescriptor {

    private boolean checkResources;
    private String locationPrefix;
    private List<String> locationSuffixes;
        
    public ProcessExtensionResourceFinder(boolean checkResources,
                                          String locationPrefix,
                                          String locationSuffix) {
        
        this.checkResources = checkResources;
        this.locationPrefix = locationPrefix;
        locationSuffixes = new ArrayList<>();
        if (locationSuffix != null) {
            locationSuffixes.add(locationSuffix);
        }
    }
    
    @Override
    public List<String> getLocationSuffixes() {
        return locationSuffixes;
    }

    @Override
    public String getLocationPrefix() {
        return locationPrefix;
    }

    @Override
    public boolean isCheckResources() {
        return checkResources;
    }

    @Override
    public String getMsgForEmptyResources() {
        return "No process extensions were found for auto-deployment in the location";
    }

    @Override
    public String getMsgForResourcesLoadOk() {
        return "The following process extension files will be deployed:";
    }
    
    
    
}
