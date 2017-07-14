/*
 * This code is based on Jason Dunkelberger (a.k.a dirkraft) as stated below
*/
 
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jason Dunkelberger (a.k.a dirkraft)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

// For plantuml support
import net.sourceforge.plantuml.FileFormat
import net.sourceforge.plantuml.FileFormatOption
import net.sourceforge.plantuml.SourceStringReader
import org.apache.commons.io.FilenameUtils
// For gradle
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.TaskAction
// For File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import groovy.io.FileType

/**
 *
 */
class RenderPlantUmlTask extends DefaultTask {

    def Path assetsPathInput = project.projectDir.toPath().resolve('src/main/java/')
    //def Path assetsPathOutput = project.projectDir.toPath().resolve('assets/')
    def Path assetsPathOutput = project.projectDir.toPath().resolve('build/docs/javadoc/')
   
    RenderPlantUmlTask() {
        Path projectPath = project.projectDir.toPath()
        
        new File(assetsPathInput.toString()).eachFileRecurse( FileType.DIRECTORIES,     
            { file ->
                file.eachFileMatch(~/.*.puml/) 
                { pumlFile -> 
                    inputs.file pumlFile

                    //println "Input=${pumlFile}"
                    
                    def outFile=getDestination(pumlFile, '.png')
                    //println "Output=${outFile}"
                    
                    outputs.file outFile
                }
            }
        )
    }
    
    File getDestination(File puml, String extension) {
        // eg: puml = /workspaces/lapr4-2017/csheets17/src/main/java/csheets/application_start_image1.puml
        String baseName = FilenameUtils.getBaseName(puml.name)    // eg: application_start_image1
        String destName = "${baseName}"
        String basePath = FilenameUtils.getFullPath(puml.path)    // eg: /workspaces/lapr4-2017/csheets17/src/main/java/csheets/
        
        String assetsPathInputString=assetsPathInput.toString()
        //println "assetsPathInput="+assetsPathInputString
        
        String assetsPathOutputString=assetsPathOutput.toString()
        //println "assetsPathOutput="+assetsPathOutputString
        
        String relativePath=basePath.substring(assetsPathInputString.length())
        //println "relativePath=${relativePath}"
        
        String newRelativePathString = relativePath + destName + extension
        //println "newRelativePathString="+newRelativePathString
        
        String newAbsolutePathString = assetsPathOutputString+newRelativePathString
        //println "newAbsolutePathString="+newAbsolutePathString
        
        Path destPathPng=Paths.get(newAbsolutePathString)
        
        destPathPng.toFile()
    }

    String getDirectory(File file) {
        FilenameUtils.getFullPath(file.path)
    }
    
    @TaskAction
    def render() {
        Path projectPath = project.projectDir.toPath()
        for (int i=0; i<inputs.files.size(); i=i+1) {
            File puml = inputs.files[i]
            //File png = outputs.files[i]
            File png=getDestination(puml, '.png')
            
            String relPumlPath = projectPath.relativize(puml.toPath()).toString()
            String pumlContent = new String(Files.readAllBytes(puml.toPath()), 'UTF-8')
            
            // Now, generate the file
            SourceStringReader reader = new SourceStringReader(pumlContent)

            // IMPORTANT:
            // It is necessary to create the directory if it does not existe yet!
            if (!png.exists())
            {
                def dir=getDirectory(png)
                // println "Directory=${dir}"
                def subdir = new File(dir)
                subdir.mkdirs()
            }
            
            //println "Rendering ${relPumlPath} to ${projectPath.relativize(png.toPath()).toString()}"
            reader.generateImage(new FileOutputStream(png), new FileFormatOption(FileFormat.PNG))
        }
    }
}
