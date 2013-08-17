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
package griffon.console.widgets;

import org.codehaus.griffon.runtime.core.AbstractObservable;

/**
 * @author Andres Almiray
 */
public class MutableAction extends AbstractObservable {
    public static final String NAME = "name";

    private Runnable runnable;
    private String name;

    public MutableAction() {
    }

    public MutableAction(String name) {
        this.name = name;
    }

    public MutableAction(Runnable runnable) {
        this.runnable = runnable;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        pcs.firePropertyChange(NAME, this.name, this.name = name);
    }

    public String toString() {
        return name;
    }

    public void call() {
        execute();
    }

    public void execute() {
        if (runnable != null) {
            runnable.run();
        }
    }
}
