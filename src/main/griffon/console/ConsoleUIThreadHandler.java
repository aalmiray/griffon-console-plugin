/*
 * Copyright 2012-2013 the original author or authors.
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

package griffon.console;

import org.codehaus.griffon.runtime.util.AbstractUIThreadHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes code honoring Console's threading model.
 *
 * @author Andres Almiray
 */
public class ConsoleUIThreadHandler extends AbstractUIThreadHandler {
    private static final Logger LOG = LoggerFactory.getLogger(griffon.console.ConsoleUIThreadHandler.class);

    public ConsoleUIThreadHandler() {
    }

    public boolean isUIThread() {
        return false;
    }

    public void executeAsync(Runnable runnable) {
        runnable.run();
    }

    public void executeSync(final Runnable runnable) {
        runnable.run();
    }
}
