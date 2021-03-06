/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dtstack.flinkx.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Content Config
 *
 * Company: www.dtstack.com
 * @author huyifan.zju@163.com
 */
public class ContentConfig extends AbstractConfig {

    public final static String KEY_READER_CONFIG = "reader";
    public final static String KEY_WRITER_CONFIG = "writer";
    public final static String KEY_STEPS_CONFIG = "steps";

    ReaderConfig reader;
    WriterConfig writer;
    List<StepConfig> steps;
    public ContentConfig(Map<String, Object> map) {
        super(map);
        if(map != null) {
            reader = new ReaderConfig((Map<String, Object>) map.get(KEY_READER_CONFIG));
            writer = new WriterConfig((Map<String, Object>) map.get(KEY_WRITER_CONFIG));
            List<Map<String,Object>> stepList = (List<Map<String, Object>>) map.get(KEY_STEPS_CONFIG);
            steps = new ArrayList<StepConfig>();
            for(Map<String,Object> stepMap : stepList) {
            	steps.add(new StepConfig(stepMap));
            }
            
            
        }
    }

    public ReaderConfig getReader() {
        return reader;
    }

    public void setReader(ReaderConfig reader) {
        this.reader = reader;
    }

    public WriterConfig getWriter() {
        return writer;
    }

    public void setWriter(WriterConfig writer) {
        this.writer = writer;
    }
    public List<StepConfig> getSteps() {
    	return steps;
    }
}
