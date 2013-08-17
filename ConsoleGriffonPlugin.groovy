/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class ConsoleGriffonPlugin {
    String version = '0.1.0'
    String griffonVersion = '1.4.0 > *'
    Map dependsOn = [:]
    List pluginIncludes = []
    String license = 'Apache Software License 2.0'
    List toolkits = ['console']
    List platforms = []
    String documentation = ''
    String source = 'https://github.com/griffon/griffon-console-plugin'

    List authors = [
        [
            id: 'aalmiray',
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Enables Console support'
    String description = '''
This plugin enables the usage of Griffon in a text-only environment.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Name* | *Type*             |
| ------ | ------------------ |
| bean   | `java.lang.Object` |
| list   | `java.util.List`   |

Configuration
-------------

Developers are responsible for keeping the application alive once the `ReadyEnd` event
has been posted to the event bus, otherwise the application will terminate immediately.
'''
}
