@artifact.package@import java.util.Map;

import groovy.util.FactoryBuilderSupport;

import org.codehaus.griffon.runtime.core.AbstractGriffonView;

public class @artifact.name@ extends AbstractGriffonView {
    // these will be injected by Griffon
    private @artifact.name.plain@Controller controller;
    private @artifact.name.plain@Model model;
    private FactoryBuilderSupport builder;

    public void setController(@artifact.name.plain@Controller controller) {
        this.controller = controller;
    }

    public void setModel(@artifact.name.plain@Model model) {
        this.model = model;
    }

    public void setBuilder(FactoryBuilderSupport builder) {
        this.builder = builder;
    }

    // build the UI
    private void init() {
    }

    @Override
    public void mvcGroupInit(final Map<String, Object> args) {
        execInsideUISync(new Runnable() {
            public void run() {
                init();
            }
        });
    }
}