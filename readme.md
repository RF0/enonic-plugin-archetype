#Enonic plugin archetype

To install enonic-plugin-archetype locally, run:

1. mvn archetype:create-from-project
2. cd target/generated-sources/archetype
3. mvn install

This will install the archetype in your local .m2/repository/com/enonic/plugin/enonic-plugin-archetype folder.
Make sure you update your local .m2 repository in your IDE for the archetype to be available.

Example for IntelliJ:  
Go to Preferences->Maven->Repositories and press the update button after installing the archetype  
To create new project from archetype:  

1. Select 'New module'  
2. Create module of type 'Maven', select 'Create from archetype'  
3. Select com.enonic.plugin:enonic-plugin-archtype:4.7.6 (version follows enonic cms version)  
4. Fill inn groupId, artifactId, version and package  

Example for commandline:       

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