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

import griffon.application.StandaloneGriffonApplication;
import griffon.core.UIThreadManager;
import griffon.util.GriffonExceptionHandler;
import griffon.util.UIThreadHandler;
import org.codehaus.griffon.runtime.core.AbstractGriffonApplication;

import java.lang.reflect.InvocationTargetException;

import static griffon.util.GriffonExceptionHandler.sanitize;

/**
 * Basic implementation of {@code GriffonApplication} that runs in standalone mode using Console.
 *
 * @author Andres Almiray
 */
public abstract class AbstractConsoleGriffonApplication extends AbstractGriffonApplication implements ConsoleGriffonApplication,
    StandaloneGriffonApplication {
    @SuppressWarnings("rawtypes")
    private static final Class[] CTOR_ARGS = new Class[]{String[].class};

    public AbstractConsoleGriffonApplication() {
        this(AbstractConsoleGriffonApplication.EMPTY_ARGS);
    }

    public AbstractConsoleGriffonApplication(String[] args) {
        super(args);
        UIThreadManager.getInstance().setUIThreadHandler(getUIThreadHandler());
    }

    protected UIThreadHandler getUIThreadHandler() {
        return new ConsoleUIThreadHandler();
    }

    public void bootstrap() {
        initialize();
    }

    public void realize() {
        startup();
    }

    public void show() {
        callReady();
    }

    public boolean shutdown() {
        if (super.shutdown()) {
            exit();
        }
        return false;
    }

    public void exit() {
        System.exit(0);
    }

    public Object createApplicationContainer() {
        return null;
    }

    /**
     * Calls the ready lifecycle method after the UI thread calms down
     */
    protected void callReady() {
        ready();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void run(Class applicationClass, String[] args) {
        GriffonExceptionHandler.registerExceptionHandler();
        StandaloneGriffonApplication app = null;
        try {
            app = (StandaloneGriffonApplication) applicationClass.getDeclaredConstructor(CTOR_ARGS).newInstance(new Object[]{args});
            app.bootstrap();
            app.realize();
            app.show();
        } catch (InstantiationException e) {
            sanitize(e).printStackTrace();
        } catch (IllegalAccessException e) {
            sanitize(e).printStackTrace();
        } catch (InvocationTargetException e) {
            sanitize(e).printStackTrace();
        } catch (NoSuchMethodException e) {
            sanitize(e).printStackTrace();
        }
    }
}
