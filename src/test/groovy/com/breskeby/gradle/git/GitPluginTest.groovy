package com.breskeby.gradle.git

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

import spock.lang.Specification

class GitPluginTest extends Specification{

	private final Project project = ProjectBuilder.builder().build()
	private final GitPlugin plugin = new GitPlugin()

    def "Applying the Git plugin does not add any tasks"() {
	    when:
	    plugin.apply(project)
	    then:
	    project.tasks.all.size() == 0
	}
}
