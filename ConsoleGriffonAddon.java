/*
 * Copyright 20012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

import griffon.console.factory.BeanFactory;
import griffon.console.factory.CollectionFactory;
import griffon.util.ApplicationHolder;
import griffon.util.RunnableWithArgs;
import griffon.util.RunnableWithArgsClosure;
import groovy.util.FactoryBuilderSupport;
import org.codehaus.griffon.runtime.core.AbstractGriffonAddon;

import java.util.Map;

/**
 * @author Andres Almiray
 */
public class ConsoleGriffonAddon extends AbstractGriffonAddon {
    public ConsoleGriffonAddon() {
        super(ApplicationHolder.getApplication());
        factories.put("bean", new BeanFactory(Object.class, true));
        factories.put("list", new CollectionFactory());

        attributeDelegates.add(new RunnableWithArgsClosure(new RunnableWithArgs() {
            public void run(Object[] args) {
                FactoryBuilderSupport builder = (FactoryBuilderSupport) args[0];
                Object node = args[1];
                Map attributes = (Map) args[2];
                if (attributes.containsKey("id")) {
                    String id = attributes.remove("id").toString();
                    builder.setVariable(id, node);
                }
            }
        }));
    }
}