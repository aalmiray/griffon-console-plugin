
Enables Console support
------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/console](http://artifacts.griffon-framework.org/plugin/console)

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