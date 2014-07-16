#Enonic archetype project

To install enonic-plugin-archetype locally, run:

1. mvn archetype:create-from-project
2. cd target/generated-sources/archetype
3. mvn install

To create new project from archetype, select the installed archetype archetype com.enonic.plugin:enonic-plugin-archetype 
in your favourite IDE like IntelliJ or Eclipse and fill inn groupId, artifactId, version and package, or use commandline:     

1. mvn archetype:generate -DarchetypeCatalog=local
2. Choose: # with local -> com.enonic.plugin:enonic-plugin-archetype (enonic-plugin-archetype)
3. Fill inn groupId, artifactId, version and package for your plugin, example:

Example:    
1: local -> com.enonic.plugin:enonic-plugin-archetype (enonic-plugin-archetype) 

Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1    
Define value for property 'groupId': : com.enonic.plugin 
Define value for property 'artifactId': : my-enonic-plugin 
Define value for property 'version':  1.0-SNAPSHOT:  
Define value for property 'package':  com.enonic.plugin:  
Confirm properties configuration:  
groupId: com.enonic.plugin  
artifactId: my-enonic-plugin  
version: 1.0-SNAPSHOT   
package: com.enonic.plugin   
 Y: : y   
[INFO] ----------------------------------------------------------------------------   
[INFO] Using following parameters for creating project from Archetype: enonic-plugin-archetype:1.0-SNAPSHOT   
[INFO] ----------------------------------------------------------------------------   
[INFO] Parameter: groupId, Value: com.enonic.plugin   
[INFO] Parameter: artifactId, Value: my-enonic-plugin   
[INFO] Parameter: version, Value: 1.0-SNAPSHOT   
[INFO] Parameter: package, Value: com.enonic.plugin   
[INFO] Parameter: packageInPathFormat, Value: com/enonic/plugin   
[INFO] Parameter: package, Value: com.enonic.plugin   
[INFO] Parameter: version, Value: 1.0-SNAPSHOT   
[INFO] Parameter: groupId, Value: com.enonic.plugin   
[INFO] Parameter: artifactId, Value: my-enonic-plugin    
[INFO] project created from Archetype in dir: /Users/rfo/development/sourcecode/enonic/archetype/my-enonic-plugin   
[INFO] ------------------------------------------------------------------------   
[INFO] BUILD SUCCESS   
[INFO] ------------------------------------------------------------------------   